package Java_Gry_wojenne;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    public void testTrain() {
        General player1 = new General();
        if(player1.shop.canApply(player1, "szeregowy", 2)) {
            player1.shop.buySoldiers(player1, "szeregowy", 2);
        }
        player1.trainer.train(player1, "szeregowy", 2);
        assertEquals(2, player1.army.getArmy().getFirst().getExperience());
    }

    @Test
    public void testCanApply() {
        General player1 = new General();
        if(player1.shop.canApply(player1, "szeregowy", 2)) {
            player1.shop.buySoldiers(player1, "szeregowy", 2);
        }
        assertTrue(player1.trainer.canApply(player1, "szeregowy", 2));
    }
}