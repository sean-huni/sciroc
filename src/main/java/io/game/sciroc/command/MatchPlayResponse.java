package io.game.sciroc.command;

import io.game.sciroc.domain.MatchStat;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.command
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 21:38
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public class MatchPlayResponse {
    private String codeName;
    private MatchStat matchStats;


    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setMatchStats(MatchStat matchStats) {
        this.matchStats = matchStats;
    }

    @Override
    public String toString() {
        return "MatchPlayResponse{" +
                "codeName='" + codeName + '\'' +
                ", matchStats=" + matchStats +
                '}';
    }
}
