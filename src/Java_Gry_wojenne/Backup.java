package Java_Gry_wojenne;

import java.io.*;
import java.util.List;

public class Backup implements Serializable {

    public void save(Game game) {
        try (ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("game_save.ser")))) {
            output.writeObject(game);
            System.out.println("Gra została zapisana pomyślnie.");
        } catch (IOException ex) {
            System.err.println("Błąd podczas zapisu gry: " + ex.getMessage());
        }
    }

    public Game load() {
        try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("game_save.ser")))) {
            Game loadedGame = (Game) input.readObject();
            System.out.println("Gra została wczytana pomyślnie.");
            return loadedGame;
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Błąd podczas wczytywania gry: " + ex.getMessage());
            return null;
        }
    }
}
