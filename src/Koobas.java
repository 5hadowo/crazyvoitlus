import java.util.Scanner;

public class Koobas {
    public static void main(String[] args) {
        //küsi kasutaja inputi nime jaoks

        Mängija mängija = tervitus();
        int tase = 1;

        while (mängija.getElud() > 0) {
            System.out.println("Tase " + tase);
            for (int i = 1; i <= 3; i++) {
                //võitleb kolliga
                võitlus();
            }
            upgrade(mängija);
            //liigub uude tasemesse
            tase += 1;

        }
        System.out.println("Mäng läbi!");




        //upgrade: eludel: 5p, rünnak: 2p, kilp: 1p


    }

    public static void võitlus(){

    }

    public static Mängija tervitus(){
        try(Scanner scanner = new Scanner(System.in)){ // loome skanneri objekt

            System.out.print("Tere tulemast. Ja muu pikk tekst");
            System.out.println("Mis on sinu nimi? ");
            String nimi = scanner.nextLine(); // loeb terve rea sisendi
            Mängija mängija = new Mängija(nimi, 20, 5, 1);
            return mängija;
        }
    }

    public static void upgrade(Mängija mängija){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Oled teeninud uuenduse!");
            System.out.println("Uuenduse valimiseks sisetsa number \n1. Rünne +2 \n2. Elud + 5 \n3. Kilp +1");
            String uuendus = scanner.nextLine();
            switch (uuendus) {
                case "1":
                    mängija.setRünnak(mängija.getRünnak()+2);
                    break;
                case "2":
                    mängija.setElud(mängija.getElud()+5);
                    break;
                case "3":
                    mängija.setKilp(mängija.getKilp()+1);
                    break;
            }
            System.out.println("Sinu andmed: \nRünnaku tugevus: " + mängija.getRünnak() +
                    "\nElud: " + mängija.getElud()+ "\nKaitse: " + mängija.getKilp());
        }
    }



    public static void genereeriKoletis(int tase){
        //vastavalt tasemele
        //Math.random() ja switch case abil loosida erinevaid koletisi



    }




}
