package Java_Gry_wojenne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Army implements Serializable {
    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(String title) {
        soldiers.add(new Soldier(title));
    }

    public void removeSoldiers() {
        soldiers.removeIf(Soldier::isDead);
    }

    public List<Soldier> getArmy() {
        return soldiers;
    }


}
