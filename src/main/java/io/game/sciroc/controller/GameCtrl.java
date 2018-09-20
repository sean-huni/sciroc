package io.game.sciroc.controller;

import io.game.sciroc.command.MatchPlayResponse;
import io.game.sciroc.command.PlayRequest;
import io.game.sciroc.domain.LeagueEntries;
import io.game.sciroc.domain.MatchStat;
import io.game.sciroc.entity.Match;
import io.game.sciroc.service.ZuulAPIGatewayService;
import io.game.sciroc.utils.converter.MatchStatToMatch;
import io.game.sciroc.utils.converter.MatchToMatchStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.controller
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 20:51
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@RestController
@RequestMapping("/game")
public class GameCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeCtrl.class);
    private ZuulAPIGatewayService zuulAPIGatewayService;
    private MatchStatToMatch matchStatToMatch;
    private MatchToMatchStat matchToMatchStat;

    @Autowired
    public GameCtrl(ZuulAPIGatewayService zuulAPIGatewayService) {
        this.zuulAPIGatewayService = zuulAPIGatewayService;
    }

    @Autowired
    public void setMatchStatToMatch(MatchStatToMatch matchStatToMatch) {
        this.matchStatToMatch = matchStatToMatch;
    }

    @Autowired
    public void setMatchToMatchStat(MatchToMatchStat matchToMatchStat) {
        this.matchToMatchStat = matchToMatchStat;
    }

    @PostMapping(value = "/cast-spell", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MatchPlayResponse> play(@CookieValue(value = "codename", defaultValue = "no-name")
                                                          String codeName, @Valid @RequestBody final PlayRequest playRequest, HttpServletRequest request, HttpServletResponse response) {
        MatchPlayResponse matchPlayResponse = new MatchPlayResponse();

        HttpSession session = null != request || null != request.getSession(FALSE) ? request.getSession(FALSE) : request.getSession();

        if (session != null && session.isNew()) {

            LOGGER.debug("Session is new...");
        } else LOGGER.debug("Session is NOT new...");

        LOGGER.info("codename: {}", codeName);
        LOGGER.debug("pPlay: {}", playRequest);

        Collection<Match> matches = zuulAPIGatewayService.findAllMatchesByName(codeName);
        String pcMove = zuulAPIGatewayService.pcMove();
        Character result = zuulAPIGatewayService.getUmpireDecision(playRequest.getChoice(), pcMove);

        int i = matches.size();
        LOGGER.debug("Matches-Size: {}", i);
        long x = i + 1L;

        proc(playRequest, x, pcMove, result, codeName, matchPlayResponse);

        List<Match> matchList = (List<Match>) matches;
        Collections.reverse(matchList);
        MatchStat stat = new MatchStat();
        if (matchList.size() > 0) {
            stat = matchToMatchStat.convert(matchList.get(0));
        }

        LOGGER.debug("MatchStat: {}", stat);
        matchPlayResponse.setMatchStats(stat);

        LOGGER.debug("playResponse: {}", matchPlayResponse);

        return new ResponseEntity(matchPlayResponse, HttpStatus.OK);
    }

    @GetMapping("/match-stats")
    public List<MatchStat> getMatchStats(@CookieValue(value = "codename") String codename) {
        List<MatchStat> statList = zuulAPIGatewayService.findAllMatchesByName(codename).stream().map(match -> matchToMatchStat.convert(match)).collect(Collectors.toList());
        return statList;
    }

    @GetMapping("/league-table")
    public List<LeagueEntries> getLeagueTable() {
        return zuulAPIGatewayService.getLeagueTable();
    }


    private void proc(PlayRequest playRequest, long x, String pcMove, Character result, String codeName, MatchPlayResponse matchPlayResponse) {

        MatchStat matchStat = new MatchStat();
        matchStat.setRound(x);
        matchStat.setMe(playRequest.getChoice().toUpperCase());
        matchStat.setPc(pcMove.toUpperCase());
        matchStat.setResult(result);
        matchStat.setTimestamp(new Timestamp(new Date().getTime()));

        Match match = matchStatToMatch.convert(matchStat);
        match.setCodeName(codeName);

        zuulAPIGatewayService.saveMatchStat(match);

        matchPlayResponse.setCodeName(codeName);
    }

}
