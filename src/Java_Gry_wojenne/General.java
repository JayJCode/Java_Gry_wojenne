package Java_Gry_wojenne;

import java.io.Serializable;

public class General implements Serializable {
    private int gold;
    final String name;
    public Army army;
    public Buy buy;
    public Train train;
    public Attack attack;

    public General(String name) {
        this.gold = 50;
        this.army = new Army();
        this.buy = new Buy();
        this.train = new Train();
        this.name = name;
        this.attack = new Attack();
    }

    public int getGold() {   return this.gold;   }

    public void setGold(int gold) {   this.gold = gold;   }

    public String getName() {   return this.name;   }

}
