package Java_Gry_wojenne;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Attack implements Action, Serializable {

    public void apply(General general, General general2) {
        int generalCombatPower = calculateCombatPower(general.army);
        int general2CombatPower = calculateCombatPower(general2.army);

        System.out.println("Gracz: " + general.name + " atakuje gracza: " + general2.name);

        if(generalCombatPower > general2CombatPower) {
            winnerScenario(general, general2);
        } else if (general2CombatPower > generalCombatPower) {
            winnerScenario(general2, general);
        } else {
            noWinnerScenario(general, general2);
        }
    }

    public boolean canApply(General general, General general2) {
        return !(general.army.getArmy().isEmpty()) && !(general2.army.getArmy().isEmpty());
    }

    private int calculateCombatPower(Army army) {
        int combatPower = 0;
        for (Soldier soldier : army.getArmy()) {
            combatPower += soldier.getCombatPower();
        }
        return combatPower;
    }

    private void winnerScenario(General winner, General loser) {
        int charge = loser.getGold()/10;
        winner.setGold(winner.getGold() + charge);
        loser.setGold(loser.getGold() - charge);

        for (Soldier soldier : winner.army.getArmy()) {
            soldier.setExperience(soldier.getExperience() + 1);
            soldier.promote();
        }
        for (Soldier soldier : loser.army.getArmy()) {
            soldier.setExperience(soldier.getExperience() - 1);
        }
        System.out.println("Generał: " + loser.name + " traci:");
        loser.army.removeSoldiers();

        System.out.println("Wygrywa gracz: " + winner.name + ", który zabiera przegranemu " + charge + " złota!");
    }

    private void noWinnerScenario(General general, General general2) {
        int randomSoldier = ThreadLocalRandom.current().nextInt(0, general.army.getArmy().size());
        int randomSoldier2 = ThreadLocalRandom.current().nextInt(0, general2.army.getArmy().size());

        System.out.println("Remis, oboje generałowie tracą jedną losową jednostkę.");
        System.out.println("Generał: " + general.name + " traci:");
        general.army.getArmy().remove(randomSoldier);
        System.out.println("Generał: " + general2.name + " traci:");
        general2.army.getArmy().remove(randomSoldier2);
    }
}
