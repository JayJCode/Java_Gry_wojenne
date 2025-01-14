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
                if(Objects.equals(soldier.getTitle(), title) && selected<amount) {
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
                if(Objects.equals(soldier.getTitle(), title) && selected<amount) {
                    selected++;
                    potentialCost =+ soldier.getLevel();
                }
            }
            if(selected < amount) {
                System.out.println("Chcesz wyszkolić więcej jednostek niż posiadasz!");
                return false;
            }
        }
        return potentialCost <= general.getGold();
    }
}
