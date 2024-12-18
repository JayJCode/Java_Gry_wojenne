package Java_Gry_wojenne;

import java.util.ArrayList;
import java.util.List;

public class General {
    private int gold;
    private Army army;
    private Shop shop;

    public General() {
        this.gold = 50;
        this.army = new Army();
        this.shop = new Shop();
    }

    public int getGold() {   return gold;   }

    public void setGold(int gold) {   this.gold = gold;   }

}
