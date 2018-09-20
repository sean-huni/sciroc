package io.game.sciroc.utils;

import io.game.sciroc.domain.LeagueEntries;
import io.game.sciroc.domain.MatchStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.utils
 * USER      : sean
 * DATE      : 17-Mon-Sep-2018
 * TIME      : 00:10
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public class Storage {
    private static final Logger LOGGER = LoggerFactory.getLogger(Storage.class);
    private static List<StaticMatchStat> staticMatchStat;

    static {
        staticMatchStat = new ArrayList<>();
    }

    public static List<StaticMatchStat> allMatchStats() {
        return staticMatchStat;
    }

    public static void addStat(String name, MatchStat matchStat) {
        try {
            matchStat.setResult(processResult(matchStat.getMe(), matchStat.getPc()));
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage(), e);
        }
        staticMatchStat.add(convert(name, matchStat));
    }

    static StaticMatchStat convert(String name, MatchStat matchStat) {
        StaticMatchStat newEntry = new StaticMatchStat();

        List<StaticMatchStat> matchStats = staticMatchStat.stream()
                .filter(x -> name.equals(x.getCodeName()))
                .collect(Collectors.toList());

        long i = ((long) matchStats.size()) + 1L;
        newEntry.setCodeName(name);
        newEntry.setMatchNo(i);
        newEntry.sethChoice(matchStat.getMe());
        newEntry.setPcChoice(matchStat.getPc());
        newEntry.setResult(matchStat.getResult());
        newEntry.setTimestamp(matchStat.getTimestamp());
        return newEntry;
    }

    public static Map<String, LeagueEntries> leagueTable() throws IllegalAccessException {
        Map<String, LeagueEntries> leagueTableMap = new HashMap<>();

        long fixtureNo = 1L;
        for (StaticMatchStat stat : staticMatchStat) {
            LeagueEntries leagueEntries = new LeagueEntries();
            long points;
            Character c = processResult(stat.gethChoice(), stat.getPcChoice());
            stat.setResult(c);
            if (leagueTableMap.containsKey(stat.getCodeName())) {
                LeagueEntries oldRecord = leagueTableMap.get(stat.getCodeName());

                leagueEntries.setPlayed(add(oldRecord.getPlayed(), 1L));

                if (c == Result.DREW.getResult()) {
                    points = 1L;
                    leagueEntries.setDrew(add(leagueEntries.getDrew(), 1L));
                } else if (c == Result.WON.getResult()) {
                    points = 3L;
                    leagueEntries.setWon(add(leagueEntries.getWon(), 1L));
                } else {
                    points = 0L;
                    leagueEntries.setLost(add(leagueEntries.getLost(), 1L));
                }

            } else {
                leagueEntries.setPlayed(1L);

                if (c == Result.DREW.getResult()) {
                    points = 1L;
                    leagueEntries.setDrew(1L);
                } else if (c == Result.WON.getResult()) {
                    points = 3L;
                    leagueEntries.setWon(1L);
                } else {
                    points = 0L;
                    leagueEntries.setLost(1L);
                }
            }

            leagueEntries.setId(fixtureNo);
            leagueEntries.setPoints(points);
            leagueTableMap.put(stat.getCodeName(), leagueEntries);
            fixtureNo++;
        }
        return leagueTableMap;
    }

    static Long add(Long x, Long y) {
        return x + y;
    }


    static Character processResult(String hPlayer, String pcPlayer) throws IllegalAccessException {
        Character c;

        if (hPlayer.equals(pcPlayer)) {
            return Result.DREW.getResult();
        }

        switch (hPlayer) {
            case "ROCK":
                c = pcPlayer.equals(HandSignal.PAP.getSignal()) ? Result.LOST.getResult() : Result.WON.getResult();
                break;
            case "PAPER":
                c = pcPlayer.equals(HandSignal.SCI.getSignal()) ? Result.LOST.getResult() : Result.WON.getResult();
                break;
            case "SCISSORS":
                c = pcPlayer.equals(HandSignal.ROC.getSignal()) ? Result.LOST.getResult() : Result.WON.getResult();
                break;
            default:
                LOGGER.error("Never supposed to happen...");
                throw new IllegalAccessException("Never supposed to happen");
        }

        return c;
    }
}
