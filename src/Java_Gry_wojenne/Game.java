package Java_Gry_wojenne;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<General> generals;
    public int actualTurn;
    public int actualPlayer;
    private transient BufferedReader reader;
    private transient Backup backup;

    public Game(int numberOfPlayers) {
        this.generals = new ArrayList<>();
        this.actualTurn = 0;
        this.actualPlayer = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            generals.add(new General("General " + (i + 1)));
        }
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.backup = new Backup();
    }

    public void launchGame() throws IOException, InterruptedException {
        while(!gameEnded()) {
            selectAction();
        }
        System.out.println("Zwycięstwo! Gracz: " + generals.getFirst() + " pokonał wszystkich swoich przeciwników!");
    }

    private void buySoldiers(General general) throws IOException {
        System.out.println("Wpisz jakie jednostki chcesz zakupić w formacie: <nazwa_stopnia> <ilość> ...");
        String[] inputs = reader.readLine().split(" ");
        List<Object> troops = new ArrayList<>();
        try {
            for (int i = 0; i < inputs.length; i += 2) {
                String unitName = inputs[i];
                int unitCount = Integer.parseInt(inputs[i + 1]);
                troops.add(unitName);
                troops.add(unitCount);
            }
            Object[] troopsArray = troops.toArray();
            if (general.buy.canApply(general, troopsArray)) {
                general.buy.apply(general, troopsArray);
                nextTurn();
            } else {
                System.out.println("Nie można zastosować zakupu. Sprawdź dostępne zasoby.");
                selectAction();
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | InterruptedException e) {
            System.out.println("Błędny format danych wejściowych.");
            buySoldiers(generals.get(actualPlayer));
        }
    }

    private void trainSoldiers(General general) throws IOException {
        System.out.println("Wpisz jakie jednostki chcesz trenować w formacie: <nazwa_stopnia>, <ilość>, ...");
        String[] inputs = reader.readLine().split(" ");
        List<Object> troops = new ArrayList<>();
        try {
            for (int i = 0; i < inputs.length; i += 2) {
                String unitName = inputs[i];
                int unitCount = Integer.parseInt(inputs[i + 1]);
                troops.add(unitName);
                troops.add(unitCount);
            }
            Object[] troopsArray = troops.toArray();
            if(general.train.canApply(general, troopsArray)) {
                general.train.apply(general, troopsArray);
                nextTurn();
            } else {
                System.out.println("Nie można zastosować trenowania. Sprawdź dostępne jednostki.");
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Błędny format danych wejściowych.");
            trainSoldiers(generals.get(actualPlayer));
        }
    }

    private void attackEnemy(General attackingGeneral) throws IOException {
        int beingAttackedGeneral = choseEnemy() - 1;
        if(attackingGeneral.attack.canApply(attackingGeneral, generals.get(beingAttackedGeneral))) {
            attackingGeneral.attack.apply(attackingGeneral, generals.get(beingAttackedGeneral));
            nextTurn();
        }
    }
    
    private int choseEnemy() {
        System.out.println("Podaj numer gracza, którego chcesz zaatakować: ");
        int beingAttackedGeneral = 0;
        while(beingAttackedGeneral == 0) {
            try {
                beingAttackedGeneral = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                System.out.println("Podaj liczbę z zakresu od 1 do " + (generals.size()+1));
            }
        }
        return beingAttackedGeneral;
    }

    private void showGold(General general) throws InterruptedException, IOException {
        System.out.println("Dostępne środki, to: " + general.getGold());
        TimeUnit.SECONDS.sleep(3);
        selectAction();
    }

    private void showArmy(General general) throws IOException, InterruptedException {
        System.out.println("Oto Twoja armia:");
        for(Soldier soldier : general.army.getArmy()) {
            System.out.println(soldier.toString());
        }
        TimeUnit.SECONDS.sleep(3);
        selectAction();
    }

    private void lose(General general) throws InterruptedException, IOException {
        System.out.println("Dziękujemy za grę!");
        generals.remove(general);
        actualPlayer--;
        TimeUnit.SECONDS.sleep(3);
        nextTurn();
    }

    private void selectAction() throws IOException, InterruptedException {
        String playerTurn;
        System.out.println("\n\nGra trwa: " + actualTurn);
        System.out.println("Tura gracza: " + generals.get(actualPlayer).getName());
        System.out.println("Wybierz ruch:\n" +
                "1) Aby kupić jednostki wpisz: kup\n" +
                "2) Jeśli chcesz trenować jednostki: trenuj\n" +
                "3) Do stoczenia walki: walcz\n" +
                "4) By zobaczyć dostępne środki: gold\n" +
                "5) Zobacz swoją armie wpisując: armia\n" +
                "6) Zawsze można opuścić grę: poddaj\n" +
                "7) Zapisz grę: save\n" +
                "8) Wczytaj grę: load\n");
        playerTurn = reader.readLine();
        switch (playerTurn) {
            case "kup" -> buySoldiers(generals.get(actualPlayer));
            case "trenuj" -> trainSoldiers(generals.get(actualPlayer));
            case "walcz" -> attackEnemy(generals.get(actualPlayer));
            case "gold" -> showGold(generals.get(actualPlayer));
            case "armia" -> showArmy(generals.get(actualPlayer));
            case "poddaj" -> lose(generals.get(actualPlayer));
            case "save" -> backup.save(this);
            case "load" -> loadGame();
            default -> {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
                selectAction();
            }
        }
    }

    private void nextTurn() {
        actualTurn++;
        actualPlayer++;
        actualPlayer = actualPlayer % generals.size();
        removeLosers();
    }

    public List<General> getGenerals() {
        return generals;
    }

    public void setGenerals(List<General> generals) {
        this.generals = generals;
    }

    public int getActualTurn() {
        return actualTurn;
    }

    public void setActualTurn(int actualTurn) {
        this.actualTurn = actualTurn;
    }

    public int getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(int actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public void loadGame() {
        if (this.backup == null) {
            this.backup = new Backup();
        }
        Game loadedGame = backup.load();
        if (loadedGame != null) {
            this.generals = loadedGame.getGenerals();
            this.actualTurn = loadedGame.getActualTurn();
            this.actualPlayer = loadedGame.getActualPlayer();
            System.out.println("Gra została wczytana pomyślnie.");
        }
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.backup = new Backup();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private boolean gameEnded() {
        return generals.size() < 2;
    }

    private void removeLosers() {
        for(General general : generals.stream().toList()) {
            general.hasLost();
            if(general.lost) {
                generals.remove(general);
            }
        }
    }
}
