package Java_Gry_wojenne;

public class Shop {

    public void buySoldiers(Army army, Object... troops) {
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            for (int j = 0; j < amount; j++) {
                army.addSoldier(title);
            }
        }
    }

    public void canAfford(General general) {


    }
}
