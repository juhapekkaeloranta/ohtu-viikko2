/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author juhapekm
 */

public class StatisticsTest {

    Statistics stats;
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void olemattomanEtsiminenPalauttaaNull() {
        assertEquals(null, stats.search("foo"));
    }
    
    @Test
    public void SemenkoLoytyy() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    }
    
    @Test
    public void joukkueenPITpelaajatOikein() {
        assertEquals("Lemieux", stats.team("PIT").get(0).getName());
    }
    
    @Test
    public void topScorerOikeinYhdella() {
        assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
    }

    // ...
}
