package Java_Gry_wojenne;

public interface Action {

    default void apply(General general, Object... troops) {
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            // Make some applies here
        }
    }

    default boolean canApply(General general, Object... troops) {
        isInputInvalid(general, troops);
        int potentialCost = 0;
        for (int i = 0; i < troops.length; i += 2) {
            String title = (String) troops[i];
            int amount = (int) troops[i + 1];
            // Calculate potential cost up to used action
            // If needed add some modifications
        }
        return potentialCost <= general.getGold();
    }

    default void isInputInvalid(General general, Object... troops) {
        if (troops.length % 2 != 0) {
            throw new IllegalArgumentException("Arguments must be in pairs of title and amount.");
        }
    }
}
