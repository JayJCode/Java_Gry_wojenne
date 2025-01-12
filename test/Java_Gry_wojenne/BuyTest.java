package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyTest {

    @Test
    public void testCanApply() {
        General player1 = new General("player1");
        Boolean result = player1.buy.canApply(player1, "szeregowy", 5);
        assertEquals(true, result);

        Boolean result2 = player1.buy.canApply(player1, "szeregowy", 6);
        assertEquals(false, result2);
    }

    @Test
    public void  testBuySoldiers() {
        General testPlayer = new General("testPlayer");
        if(testPlayer.buy.canApply(testPlayer, "kapitan", 1)) {
            testPlayer.buy.apply(testPlayer, "kapitan", 1);
        }
        assertNotEquals(50, testPlayer.getGold());
        assertEquals(20, testPlayer.getGold());

        if(testPlayer.buy.canApply(testPlayer, "szeregowy", 2)) {
            testPlayer.buy.apply(testPlayer, "szeregowy", 2);
        }
        assertEquals(0, testPlayer.getGold());
    }
}