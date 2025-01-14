package Java_Gry_wojenne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Witaj w grze wojennej.\n" +
                "Jesli chcesz utworzyc nowa gre wybierz: 1\n" +
                "Aby kontynuowac ostatnia gre wpisz: 2");
        int choice = Integer.parseInt(reader.readLine());

        Game game = null;
        Backup backup = new Backup();

        switch (choice) {
            case 1 -> {
                System.out.println("Podaj liczbe graczy: ");
                int numberOfPlayers = Integer.parseInt(reader.readLine());
                game = new Game(numberOfPlayers);
                System.out.println("Witajcie generałowie!\n" +
                        "Każdy z Was zaczyna z 50 monetami, za które macie werbować jednostki do waszych armii.\n" +
                        "Możecie je również szkolić i nawzajem się atakować.\n" +
                        "Waszym celem jest posiadanie największej armii!\n" +
                        "Gra kończy się, jak wszystkim graczom skończy się złoto.\n" +
                        "Gracz, który nie posiada już żadnych możliwości ruchu lub nie chce dalej grać - poddaje się.\n");
                game.launchGame();
            }
            case 2 -> {
                game = backup.load();
                if (game != null) {
                    game.loadGame();
                    game.launchGame();
                } else {
                    System.out.println("Nie udało się wczytać gry.");
                }
            }
            default -> System.out.println("Nieprawidłowy wybór. Zakończono program.");
        }
    }
}