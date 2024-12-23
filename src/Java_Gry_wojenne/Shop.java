package Java_Gry_wojenne;

public class Shop {

    public void buySoldiers(General general, Object... troops) {
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
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
    }

    public boolean canApply(General general, Object... troops) {
        int potentialCost = 0;
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            Soldier soldier = new Soldier(title);   // Create temporary soldier obj to reach level corresponding to its title
            int amount = (int) troops[i + 1];
            potentialCost =+ amount * 10 * soldier.getLevel();
        }
        return potentialCost <= general.getGold();
    }
}
