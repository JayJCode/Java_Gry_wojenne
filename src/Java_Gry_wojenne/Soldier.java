package Java_Gry_wojenne;

public class Soldier {
    private int level;
    private int experience;
    private String title;


    public Soldier(String title) {
        this.level = assignTitle(title);
        this.experience = 1;
        this.title = title;
    }



    // Assign level based on title
    private int assignTitle(String title) {
        return switch (title) {
            case "szeregowy" -> 1;
            case "kapral" -> 2;
            case "kapitan" -> 3;
            case "major" -> 4;
            default -> throw new IllegalArgumentException("Invalid level.");
        };
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
    public void promote() {
        if(this.experience >= 5 * this.level && this.level < 5) {
            this.experience = 1;
            this.level++;
            this.title = assignTitle(this.level);
        }
    }
}
