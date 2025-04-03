import java.util.Scanner;

public class Koobas {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        Mängija mängija = tervitus(scanner);
        int tase = 1;

        while (true) {
            paus(3000);
            System.out.println("Tase " + tase);
            paus(5000);
            boolean võitis = true;
            for (int i = 1; i <= 3; i++) {
                //võitleb vastasega
                Mängija koletis = genereeriKoletis(tase);
                võitis = võitlus(mängija, koletis, scanner);
                if (!võitis){
                    break;
                }
            }
            if (!võitis){
                break;
            }

            mängija.uuendus(scanner);
            //liigub uude tasemesse
            tase += 1;

        }
        paus(3000);
        System.out.println("Mäng on läbi!");
        scanner.close();

    }

    public static boolean võitlus(Mängija mängija, Mängija koletis, Scanner scanner){

            System.out.println("Sinu vastane on " +koletis.toString());
            while (mängija.getElud() > 0 && koletis.getElud() > 0) {
                paus(3000);
                System.out.println("Sinu käik");
                paus(3000);
                System.out.println("Tegevuse valimiseks sisesta number: \n1. Ründa \n2. Tervenda \n3. Kaitse");
                String tegevus = scanner.nextLine();
                paus(3000);
                switch (tegevus) {
                    case "1":
                        int mängijaRünnak = mängija.ründa();
                        System.out.println("Sinu rünnaku tugevus: " + mängijaRünnak);
                        if (koletis.getKilp()> 0){
                            System.out.println("Vastasel on kilp väärtusega " + koletis.getKilp());
                            if (koletis.getKilp() > mängijaRünnak){
                                koletis.setKilp(koletis.getKilp()-mängijaRünnak);
                                mängijaRünnak = 0;
                                System.out.println("Tegid kilpi nõrgemaks. Nüüd on ta kilbi väärtus " + koletis.getKilp());
                            } else {
                                mängijaRünnak = mängijaRünnak-koletis.getKilp();
                                koletis.setKilp(0);
                                System.out.println("Tegid vastase kilbi katki. Alles jäänud rünnaku tugevus on " + mängijaRünnak);
                            }
                        }
                        if (koletis.getElud() < mängijaRünnak){
                            mängijaRünnak = koletis.getElud();
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
                paus(3000);
                if (koletis.getElud()<=0){
                    break;
                }
                System.out.println("Vastase käik");
                paus(3000);
                int vastaseTegevus = (int) (Math.random()*3+1);
                switch (vastaseTegevus) {
                    case 1:
                        int koletiseRünnak = koletis.ründa();
                        if (mängija.getKilp() > 0){
                            if (mängija.getKilp() > koletiseRünnak){
                                System.out.println("Su kilp on tugev, kuid kaotab väärtust " + koletiseRünnak + " punkti võrra");
                                mängija.setKilp(mängija.getKilp()-koletiseRünnak);
                                koletiseRünnak = 0;

                            } else {
                                koletiseRünnak = koletiseRünnak-mängija.getKilp();
                                mängija.setKilp(0);
                                System.out.println("Vastane tegi su kilbi katki. Nüüd ründab ta tugevusega " + koletiseRünnak);
                            }
                        }
                        if (mängija.getElud() < koletiseRünnak){
                            koletiseRünnak = mängija.getElud();
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
                paus(3000);
                System.out.println("Sa võitsid! \n");
                return true;
            } else {
                paus(3000);
                System.out.println("Sa kaotasid! \n");
                return false;
            }

    }


    public static Mängija tervitus(Scanner scanner){

        System.out.print("Mis on sinu nimi? ");
        String nimi = scanner.nextLine(); // loeb terve rea sisendi
        System.out.println("Tere tulemast, " + nimi + "!" +
        "\nOled sisenemas vastaseid täis koopasse. Koobas koosndeb erinevatest tasemetest." +
                "\nIgas tasemes on 3 vastast. Võitled vastastega ükshaaval ning käike tehakse kordamööda." +
                "\nOma käigu ajal saad valida, kas soovid vastast rünnata, ennast ravida või oma kaitset suurendada." +
                "\nRündamine, ravitsemine ja kaitsmine on suvaliselt genereeritud." +
                "\nPärast igat taset saad valida uuenduse. Kui kaotad koopas, siis on mäng läbi." +
                "\nHead mängimist!");
        paus(20000);
        Mängija mängija = new Mängija(nimi, 20, 5, 1);
        return mängija;

    }

    public static Mängija genereeriKoletis(int tase){
        //vastavalt tasemele
        //koletise  elud / rünnak suureneb iga tasemega +2. Kilp suureneb iga 2 taseme tagant +1

        Mängija koletis = new Mängija("Troll", 5+2*(tase-1), 2+2*(tase-1), (int) 1+tase/2 );
        return koletis;
    }

    private static void paus(int millisekundid){
        try {
            Thread.sleep(millisekundid);
            System.out.println(" ");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Paus katkestati!");
        }
    }




}
