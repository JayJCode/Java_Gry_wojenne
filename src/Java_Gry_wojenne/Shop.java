package Java_Gry_wojenne;

public class Shop {

    // 1 kind of troops
    public void buySoldiers(Army army, String title, int amount) {
        for(int i=0; i<amount; i++) {
            army.addSoldier(title);
        }
    }

    // 2 kinds of troops
    public void buySoldiers(Army army, String title1, int amount1, String title2, int amount2) {
        for(int i=0; i<amount1; i++) {
            army.addSoldier(title1);
        }
        for(int i=0; i<amount2; i++) {
            army.addSoldier(title2);
        }
    }

    // 3 kind of troops
    public void buySoldiers(Army army, String title1, int amount1, String title2, int amount2,
                            String title3, int amount3) {
        for(int i=0; i<amount1; i++) {
            army.addSoldier(title1);
        }
        for(int i=0; i<amount2; i++) {
            army.addSoldier(title2);
        }
        for(int i=0; i<amount3; i++) {
            army.addSoldier(title3);
        }
    }

    // 4 kind of troops
    public void buySoldiers(Army army, String title1, int amount1, String title2,
                            int amount2, String title3, int amount3, String title4, int amount4) {
        for(int i=0; i<amount1; i++) {
            army.addSoldier(title1);
        }
        for(int i=0; i<amount2; i++) {
            army.addSoldier(title2);
        }
        for(int i=0; i<amount3; i++) {
            army.addSoldier(title3);
        }
        for(int i=0; i<amount4; i++) {
            army.addSoldier(title4);
        }
    }
}
