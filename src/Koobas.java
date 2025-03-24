import java.util.Scanner;

public class Koobas {
    public static void main(String[] args) {
        //küsi kasutaja inputi nime jaoks

        Mängija mängija = new Mängija("essa", 20, 5, 1);
        //upgrade: eludel: 5p, rünnak: 2p, kilp: 1p

        //
        try(Scanner scanner = new Scanner(System.in)){ // loome skanneri objekt

        System.out.print("Sisesta oma nimi: ");
        String nimi = scanner.nextLine(); // loeb terve rea sisendi

        System.out.print("Sisesta oma vanus: ");
        int vanus = scanner.nextInt(); // loeb täisarvu

        System.out.println("Tere, " + nimi + "! Sa oled " + vanus + " aastat vana.");
        };
        //scanner.close();
    }
}
