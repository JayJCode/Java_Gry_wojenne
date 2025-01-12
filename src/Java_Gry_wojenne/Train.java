package Java_Gry_wojenne;

import java.io.Serializable;
import java.util.Objects;

public class Train implements Action, Serializable {

    @Override
    public void apply(General general, Object... troops) {
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            int selected = 0;
            for (Soldier soldier : general.army.getArmy()) {
                if(soldier.getTitle()==title && selected<amount) {
                    selected++;
                    soldier.setExperience(soldier.getExperience() + 1);
                    soldier.promote();
                    general.setGold(general.getGold() - soldier.getLevel());
                }
            }
        }
    }

    @Override
    public boolean canApply(General general, Object... troops) {
        isInputInvalid(general, troops);
        int potentialCost = 0;
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            int selected = 0;
            for (Soldier soldier : general.army.getArmy()) {
                System.out.println("soldier title: " + soldier.getTitle() + "\ttitle: " + title + "\tselected: " + selected + "\tamount: " + amount);
                if(Objects.equals(soldier.getTitle(), title) && selected<amount) {
                    System.out.println("wywołuje się");
                    selected++;
                    potentialCost =+ soldier.getLevel();
                }
            }
            System.out.println("selected: " + selected + "\tamount: " + amount);
            if(selected < amount) {
                throw new IllegalArgumentException("Selected more soldiers, than currently having.");
            }
        }
        return potentialCost <= general.getGold();
    }
}
