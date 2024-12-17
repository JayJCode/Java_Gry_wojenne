package Java_Gry_wojenne;

import java.util.ArrayList;
import java.util.List;


public class Army {
    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(int level) {
        soldiers.add(new Soldier(level));
    }

    public void removeSoldier() {
        soldiers.removeIf(Soldier::isDead);
    }

    public List<Soldier> getArmy() {
        return soldiers;
    }
}
