package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttackTest {

    @Test
    public void testApplyPlayer1Wins() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 2)) {
            player1.buy.apply(player1, "szeregowy", 2);
        }
        General player2 = new General("player2");
        if(player2.buy.canApply(player2, "szeregowy", 1)) {
            player2.buy.apply(player2, "szeregowy", 1);
        }

        assertEquals(30, player1.getGold());
        assertEquals(40, player2.getGold());

        if(player1.attack.canApply(player1, player2)) {
            player1.attack.apply(player1, player2);
        }

        assertEquals(34, player1.getGold());
        assertEquals(36, player2.getGold());
        assertEquals(2, player1.army.getArmy().size());
        assertEquals(0, player2.army.getArmy().size());
    }

    @Test
    public void testApplyPlayer2Wins() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 1)) {
            player1.buy.apply(player1, "szeregowy", 1);
        }
        General player2 = new General("player2");
        if(player2.buy.canApply(player2, "szeregowy", 3)) {
            player2.buy.apply(player2, "szeregowy", 3);
        }
        if(player1.train.canApply(player1, "szeregowy", 1)) {
            player1.train.apply(player1, "szeregowy", 1);
        }

        assertEquals(39, player1.getGold());
        assertEquals(20, player2.getGold());

        if(player1.attack.canApply(player1, player2)) {
            player1.attack.apply(player1, player2);
        }

        assertEquals(36, player1.getGold());
        assertEquals(23, player2.getGold());
        assertEquals(1, player1.army.getArmy().size());
        assertEquals(3, player2.army.getArmy().size());
    }

    @Test
    public void testApplyDraw() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 2)) {
            player1.buy.apply(player1, "szeregowy", 2);
        }
        General player2 = new General("player2");
        if(player2.buy.canApply(player2, "szeregowy", 2)) {
            player2.buy.apply(player2, "szeregowy", 2);
        }

        assertEquals(30, player1.getGold());
        assertEquals(30, player2.getGold());

        if(player1.attack.canApply(player1, player2)) {
            player1.attack.apply(player1, player2);
        }

        assertEquals(30, player1.getGold());
        assertEquals(30, player2.getGold());
        assertEquals(1, player1.army.getArmy().size());
        assertEquals(1, player2.army.getArmy().size());
    }

}