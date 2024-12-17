package Java_Gry_wojenne;

public class Soldier {
    private int level;
    private int experience;
    private String title;

    public Soldier(int level) {
        if (level < 1 || level > 4) {   throw new IllegalArgumentException("Level must be between 1 and 4.");   }
        this.level = level;
        this.experience = 1;
        this.title = assignTitle(level);
    }



    // Assign title based on level
    private String assignTitle(int level) {
        return switch (level) {
            case 1 -> "szeregowy";
            case 2 -> "kapral";
            case 3 -> "kapitan";
            case 4 -> "major";
            default -> throw new IllegalArgumentException("Invalid level.");
        };
    }

    // Level
    public int getLevel() {   return level;   }

    public void setLevel(int level) {
        if (level < 1 || level > 4) {   throw new IllegalArgumentException("Level must be between 1 and 4.");   }
        this.level = level;
        this.title = assignTitle(level);
    }

    // Title
    public String getTitle() {   return title;   }

    // Experience
    public int getExperience() {   return experience;   }

    public void setExperience(int experience) {   this.experience = experience;   }

    // CombatPower
    public  int getCombatPower() {   return  this.level * this.experience;   }

    // Soldier dies after their experience goes down to 0
    public boolean isDead() {
        return this.experience <= 0;
    }

    // Soldier gets promoted after reaching experience of 5x his level
    public void isPromoted() {
        if(this.experience >= 5 * this.level && this.level < 5) {
            this.level++;

        }
    }
}
