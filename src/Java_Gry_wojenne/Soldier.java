package Java_Gry_wojenne;

public class Soldier {
    private int level;
    private int experience;
    private int combatPower;

    public Soldier(int level) {
        this.level = level;
        this.experience = 1;
        this.combatPower = level;
    }

    // Level
    public int getLevel() {   return level;   }

    public void setLevel(int level) {   this.level = level;   }

    // Experience
    public int getExperience() {   return experience;   }

    // CombatPower
    public  int getCombatPower() {   return  combatPower;   }

    public void ifDead() {
        if(this.experience <= 0) {
            //usun jednostke
        }
    }


}
