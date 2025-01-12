package Java_Gry_wojenne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj liczbe graczy: ");
        int numberOfPlayers = Integer.parseInt(reader.readLine());
        Game game = new Game(numberOfPlayers);
        game.launchGame();
    }
}
