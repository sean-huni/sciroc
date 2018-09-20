package io.game.sciroc.domain;

/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.domain
 * USER      : sean
 * DATE      : 16-Sun-Sep-2018
 * TIME      : 21:17
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
public class LeagueEntries {
    private Long id;            // Fixture-No. (Total-Matches Played By All Players)
    private String codeName;    // Player's name.
    private Long played;        // Matches-Played
    private Long won;           // Matches-Won
    private Long drew;          // Matches-Drawn
    private Long lost;          // Matches-Lost
    private Long points;        // Total-Points

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Long getPlayed() {
        return played;
    }

    public void setPlayed(Long played) {
        this.played = played;
    }

    public Long getWon() {
        return won;
    }

    public void setWon(Long won) {
        this.won = won;
    }

    public Long getDrew() {
        return drew;
    }

    public void setDrew(Long drew) {
        this.drew = drew;
    }

    public Long getLost() {
        return lost;
    }

    public void setLost(Long lost) {
        this.lost = lost;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
