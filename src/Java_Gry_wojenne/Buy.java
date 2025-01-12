package Java_Gry_wojenne;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Buy implements Action, Serializable {

    @Override
    public void apply(General general, Object... troops) {
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            for (int j = 0; j < amount; j++) {
                general.army.addSoldier(title);
                Soldier soldier = new Soldier(title);
                int soldierCost = 10 * soldier.getLevel();
                general.setGold(general.getGold()-soldierCost);
            }
        }
        System.out.println("Gracz zakupił nowe jednostki:");
        for(Object object : troops) {
            if(object instanceof String) {
                System.out.print(object + " ");
            } else {
                System.out.println(object);
            }
        }
    }

    @Override
    public boolean canApply(General general, Object... troops) {
        isInputInvalid(general, troops);
        String[] possibleTitles = new String[] {"szeregowy", "kapral", "kapitan", "major"};
        Set<String> possibleTitlesSet = new HashSet<String>(Arrays.asList(possibleTitles));
        int potentialCost = 0;
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            if (!possibleTitlesSet.contains(title)) {
                System.out.println("Niepoprawna nazwa stopnia wojskowego." +
                        " Wybierz jedną z: \"szeregowy\", \"kapral\", \"kapitan\", \"major\"");
                return false;
            }
            potentialCost =+ amount * 10 * new Soldier(title).getLevel();
        }
        return potentialCost <= general.getGold();
    }
}
