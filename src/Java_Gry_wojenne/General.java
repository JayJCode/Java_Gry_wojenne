package Java_Gry_wojenne;

import java.util.ArrayList;
import java.util.List;

public class General {
    private int gold;
    public Army army;
    public Shop shop;
    public Trainer trainer;

    public General() {
        this.gold = 50;
        this.army = new Army();
        this.shop = new Shop();
        this.trainer = new Trainer();
    }

    public int getGold() {   return gold;   }

    public void setGold(int gold) {   this.gold = gold;   }

}
