package io.game.sciroc.utils;

import java.sql.Timestamp;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.utils
 * USER      : sean
 * DATE      : 17-Mon-Sep-2018
 * TIME      : 00:14
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public class StaticMatchStat {
    private String codeName;    // Code-Name
    private Long matchNo;       // Match-No (on current-active session)
    private String hChoice;     // Human-Choice
    private String pcChoice;    // PC-Choice
    private Character result;   // Won/Drew/Lost
    private Timestamp timestamp;// Audit of the match

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Long getMatchNo() {
        return matchNo;
    }

    public void setMatchNo(Long matchNo) {
        this.matchNo = matchNo;
    }

    public String gethChoice() {
        return hChoice;
    }

    public void sethChoice(String hChoice) {
        this.hChoice = hChoice;
    }

    public String getPcChoice() {
        return pcChoice;
    }

    public void setPcChoice(String pcChoice) {
        this.pcChoice = pcChoice;
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
}
