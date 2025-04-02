import java.util.Scanner;

public class Koobas {
    public static void main(String[] args) {
        //küsi kasutaja inputi nime jaoks

        Mängija mängija = tervitus();
        int tase = 1;

        while (true) {
            System.out.println("Tase " + tase);
            boolean võitis = true;
            for (int i = 1; i <= 3; i++) {
                //võitleb kolliga
                Mängija koletis = genereeriKoletis(tase);
                võitis = võitlus(mängija, koletis);
                if (!võitis){
                    break;
                }
            }
            if (!võitis){
                break;
            }

            mängija.upgrade();
            //liigub uude tasemesse
            tase += 1;

        }
        System.out.println("Mäng on läbi!");




        //upgrade: eludel: 5p, rünnak: 2p, kilp: 1p


    }

    public static boolean võitlus(Mängija mängija, Mängija koletis){
        try(Scanner sisestus = new Scanner(System.in)) {
            System.out.println(koletis.getNimi() + ": " + koletis.toString());
            while (mängija.getElud() > 0 && koletis.getElud() > 0) {
                System.out.println("Sinu käik");
                System.out.println("Tegevuse valimiseks sisesta number: \n1. Ründa \n2. Tervenda \n3. Kaitse");
                String tegevus = sisestus.nextLine();
                switch (tegevus) {
                    case "1":
                        int mängijaRünnak = mängija.ründa();
                        if (koletis.getKilp() > 0){
                            if (koletis.getKilp() > mängijaRünnak){
                                koletis.setKilp(koletis.getKilp()-mängijaRünnak);
                                mängijaRünnak = 0;
                            } else {
                                mängijaRünnak = mängijaRünnak-koletis.getKilp();
                                koletis.setKilp(0);
                            }
                        }
                        koletis.setElud(koletis.getElud() - mängijaRünnak);
                        System.out.println(koletis.getNimi() + " kaotas " + mängijaRünnak + " elu. Tal on nüüd " + koletis.getElud() + " elu");
                        break;
                    case "2":
                        int ravi = mängija.ravimine();
                        mängija.setElud(mängija.getElud() + ravi);
                        System.out.println("Said " + ravi + " elu juurde. Nüüd on sul " + mängija.getElud() + " elu");
                        break;
                    case "3":
                        //kilp += 1;
                        int kaitse = mängija.kaitse();
                        mängija.setKilp(mängija.getKilp() + kaitse);
                        System.out.println("Suurendasid oma kaitset " + kaitse + " punkti võrra. Nüüd on su kaitse tase " + mängija.getKilp());
                        break;

                }
                if (koletis.getElud()<=0){
                    break;
                }
                System.out.println("Vastase käik");
                int vastaseTegevus = (int) (Math.random()*3+1);
                switch (vastaseTegevus) {
                    case 1:
                        int koletiseRünnak = koletis.ründa();
                        if (koletis.getKilp() > 0){
                            if (koletis.getKilp() > koletiseRünnak){
                                koletis.setKilp(koletis.getKilp()-koletiseRünnak);
                                koletiseRünnak = 0;
                            } else {
                                koletiseRünnak = koletiseRünnak-koletis.getKilp();
                                koletis.setKilp(0);
                            }
                        }
                        mängija.setElud(mängija.getElud() - koletiseRünnak);
                        System.out.println(koletis.getNimi()+" ründas sind. Kaotasid " + koletiseRünnak + " elu. Sul on nüüd " + mängija.getElud() + " elu");
                        break;
                    case 2:
                        int ravi = koletis.ravimine();
                        koletis.setElud(koletis.getElud() + ravi);
                        System.out.println(koletis.getNimi()+" ravis end. Ta sai " + ravi + " elu juurde. Nüüd on tal " + koletis.getElud() + " elu");
                        break;
                    case 3:
                        int kaitse = koletis.kaitse();
                        koletis.setKilp(koletis.getKilp() + kaitse);
                        System.out.println(koletis.getNimi()+" suurendas oma kaitset " + kaitse + " punkti võrra. Nüüd on ta kaitse tase " + koletis.getKilp());
                        break;

                }
            } if (koletis.getElud()<=0){
                System.out.println("Sa võitsid!");
                return true;
            } else {
                System.out.println("Sa kaotasid!");
                return false;
            }

        }

    }
    /*
    public static void tegevuseValik(String tegevus, Mängija ründaja, Mängija vastane){
        switch (tegevus) {
            case "1":
                int mängijaRünnak = ründaja.ründa();
                vastane.setElud(vastane.getElud() - mängijaRünnak);
                System.out.println("Koletis kaotas " + mängijaRünnak + " elu. Koletisel on nüüd " + vastane.getElud() + " elu");
                break;
            case "2":
                int ravi = ründaja.ravimine();
                ründaja.setElud(ründaja.getElud() + ravi);
                System.out.println("Said " + ravi + " elu juurde. Nüüd on sul " + ründaja.getElud() + " elu");
                break;
            case "3":
                //kilp += 1;
                int kaitse = ründaja.kaitse();
                ründaja.setKilp(ründaja.getElud() + kaitse);
                System.out.println("Suurendasid oma kaitset " + kaitse + " punkti võrra. Nüüd on su kaitse tase " + ründaja.getKilp());
                break;

        }
    }

     */

    public static Mängija tervitus(){
        try(Scanner scanner = new Scanner(System.in)){ // loome skanneri objekt

            System.out.print("Tere tulemast. Ja muu pikk tekst \nMis on sinu nimi? ");
            String nimi = scanner.nextLine(); // loeb terve rea sisendi
            System.out.println("Tere tulemast, " + nimi + "!");
            Mängija mängija = new Mängija(nimi, 20, 5, 1);
            return mängija;
        }
    }
    /*
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

     */



    public static Mängija genereeriKoletis(int tase){
        //vastavalt tasemele
        //Math.random() ja switch case abil loosida erinevaid koletisi
        Mängija koletis = new Mängija("Koletis", 15, 3, 1);

        return koletis;
    }




}
