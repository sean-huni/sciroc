package io.game.sciroc.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


/**
 * PROJECT   : sciroc
 * PACKAGE   : io.game.sciroc.domain
 * USER      : sean
 * DATE      : 19-Wed-Sep-2018
 * TIME      : 23:07
 * E-MAIL    : kudzai@bcs.org
 * CELL      : +27-64-906-8809
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LeagueEntriesTest {
    LeagueEntries leagueEntries;

    @Before
    public void setup() {
        leagueEntries = new LeagueEntries();
    }

    @After
    public void teardown() {
        leagueEntries = null;
    }

    @Test
    public void verify_leagueEntries_integrity() {
        leagueEntries.setId(100L);
        leagueEntries.setCodeName("code-name");
        leagueEntries.setDrew(200L);
        leagueEntries.setLost(300L);
        leagueEntries.setWon(400L);
        leagueEntries.setPlayed(500L);
        leagueEntries.setPoints(600L);

        assertTrue(100L == leagueEntries.getId());
        assertTrue("code-name".equals(leagueEntries.getCodeName()));
        assertTrue(200L == leagueEntries.getDrew());
        assertTrue(300L == leagueEntries.getLost());
        assertTrue(400L == leagueEntries.getWon());
        assertTrue(500L == leagueEntries.getPlayed());
        assertTrue(600L == leagueEntries.getPoints());
    }
}