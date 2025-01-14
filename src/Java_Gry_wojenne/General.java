package Java_Gry_wojenne;

import java.io.Serializable;

public class General implements Serializable {
    private int gold;
    final String name;
    public Army army;
    public Buy buy;
    public Train train;
    public Attack attack;
    public boolean lost;

    public General(String name) {
        this.gold = 100;
        this.army = new Army();
        this.buy = new Buy();
        this.train = new Train();
        this.name = name;
        this.attack = new Attack();
        this.lost = false;
    }

    public int getGold() {   return this.gold;   }

    public void setGold(int gold) {   this.gold = gold;   }

    public String getName() {   return this.name;   }

    public void hasLost() {
        if(army.getArmy().isEmpty() && gold<10) {
            lost = true;
            System.out.println("Generał: " + this.name + " stracił całe złoto i armie - przegrywe gre.");
        }
    }
}
