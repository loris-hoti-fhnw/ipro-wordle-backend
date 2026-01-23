import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String solution = "SKATE";

        System.out.println("Willkommen zu Wordle (Skateboard-Version)");
        System.out.println("Bitte gib ein Wort mit 5 Buchstaben ein:");

        String input = scanner.nextLine().toUpperCase();

        if (input.equals(solution)) {
            System.out.println("Richtig, du hast das Wort erraten.");
        } else {
            System.out.println("Falsch, das gesuchte Wort war: " + solution);
        }

        System.out.println("Spiel beendet");
        scanner.close();
    }
}
