package Java_Gry_wojenne;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    public void train(General general, Object... troops) {
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            int selected = 0;
            for (Soldier soldier : general.army.getArmy()) {
                if(soldier.getTitle()==title && selected<amount) {
                    selected++;
                    soldier.setExperience(soldier.getExperience() + 1);
                    general.setGold(general.getGold() - soldier.getLevel());
                }
            }
        }
    }

    public boolean canApply(General general, Object... troops) {
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
        int potentialCost = 0;
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            int selected = 0;
            for (Soldier soldier : general.army.getArmy()) {
                if(soldier.getTitle()==title && selected<amount) {
                    selected++;
                    potentialCost =+ soldier.getLevel();
                }
            }
            if(selected < amount) {
                return false;
            }
        }
        return potentialCost <= general.getGold();
    }
}
