package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    public void testCanApply() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 2)) {
            player1.buy.apply(player1, "szeregowy", 2);
        }
        assertTrue(player1.train.canApply(player1, "szeregowy", 2));
    }

    @Test
    public void testCanApplyInvalidOperation() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 1)) {
            player1.buy.apply(player1, "szeregowy", 1);
        }
        assertThrows(IllegalArgumentException.class, () -> {
            player1.train.canApply(player1, "szeregowy", 2);
        });
    }

    @Test
    public void testApply() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 2)) {
            player1.buy.apply(player1, "szeregowy", 2);
        }
        if(player1.train.canApply(player1, "szeregowy", 2)) {
            player1.train.apply(player1, "szeregowy", 2);
        }
        assertEquals(2, player1.army.getArmy().getFirst().getExperience());
    }

    @Test
    public void testApplyWithPromotion() {
        General player1 = new General("player1");
        if(player1.buy.canApply(player1, "szeregowy", 1)) {
            player1.buy.apply(player1, "szeregowy", 1);
        }
        player1.army.getArmy().getFirst().setExperience(4);
        if(player1.train.canApply(player1, "szeregowy", 1)) {
            player1.train.apply(player1, "szeregowy", 1);
        }
        assertEquals(2, player1.army.getArmy().getFirst().getLevel());
    }
}