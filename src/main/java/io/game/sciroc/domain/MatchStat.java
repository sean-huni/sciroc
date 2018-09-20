package io.game.sciroc.domain;

import java.sql.Timestamp;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.domain
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 21:54
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public class MatchStat {
    private Long round;       // Match-No (on current-active session)
    private String me;     // Human-Choice
    private String pc;    // PC-Choice
    private Character result;   // Won/Drew/Lost
    private Timestamp timestamp;// Audit of the match

    public Long getRound() {
        return round;
    }

    public void setRound(Long round) {
        this.round = round;
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public Character getResult() {
        return result;
    }

    public void setResult(Character result) {
        this.result = result;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MatchStat{" +
                "round=" + round +
                ", me='" + me + '\'' +
                ", pc='" + pc + '\'' +
                ", result=" + result +
                ", timestamp=" + timestamp +
                '}';
    }
}
