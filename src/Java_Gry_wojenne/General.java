package Java_Gry_wojenne;

import java.util.ArrayList;
import java.util.List;

public class General {
    private int gold;
    private Army army;

    public General() {
        this.gold = 50;
        this.army = new Army();
    }

    public int getGold() {   return gold;   }

    public void setGold(int gold) {   this.gold = gold;   }


}
