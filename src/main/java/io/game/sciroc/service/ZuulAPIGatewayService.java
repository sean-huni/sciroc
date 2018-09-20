package io.game.sciroc.service;

import io.game.sciroc.domain.LeagueEntries;
import io.game.sciroc.entity.Match;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.service
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 23:19
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */

@FeignClient(name = "zuul", url = "localhost:8005")
public interface ZuulAPIGatewayService {

    @GetMapping(path = "/api/game/game-engine/pc-move")
    String pcMove();

    @PostMapping(path = "/api/leaderboard/game-match/save")
    void saveMatchStat(@RequestBody Match match);

    @GetMapping(path = "/api/leaderboard/game-match/get/{name}")
    Collection<Match> findAllMatchesByName(@PathVariable("name") String name);

    /**
     * Computes the decision of the recent match.
     *
     * @param player1 choice.
     * @param player2 choice.
     * @return Result {@link Character} of the match.
     */
    @GetMapping(value = "/api/leaderboard/game-match/decision/{player1}/{player2}")
    Character getUmpireDecision(@PathVariable("player1") String player1, @PathVariable("player2") String player2);

    /**
     * Finds all League entries in the database.
     *
     * @return a League-Table of all {@link List<LeagueEntries>}.
     */
    @GetMapping(value = "/api/leaderboard/game-match/get-league")
    List<LeagueEntries> getLeagueTable();
}
