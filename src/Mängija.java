import java.util.Scanner;

public class Mängija {
    private String nimi;
    private int elud;
    private int rünnak;
    private int kilp;

    public Mängija(String nimi, int elud, int rünnak, int kilp) {
        this.nimi = nimi;
        this.elud = elud;
        this.rünnak = rünnak;
        this.kilp = kilp;
    }

    public void upgrade(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Oled teeninud uuenduse!");
            System.out.println("Uuenduse valimiseks sisetsa number \n1. Rünne +2 \n2. Elud + 5 \n3. Kilp +1");
            String uuendus = scanner.nextLine();
            switch (uuendus) {
                case "1":
                    rünnak += 2;
                    break;
                case "2":
                    elud += 5;
                    break;
                case "3":
                    kilp += 1;
                    break;
            }
            System.out.println("Sinu andmed: " + toString());
        }
    }

    @Override
    public String toString() {
        return nimi +
                "\nElud " + elud +
                "\nRünnak " + rünnak +
                "\nKilp " + kilp;
    }

    public int ründa(){
        //tagastab ründe tugevuse (arvestades algset tugevust ja kasutades Math.random)
        //upgrade -> "baas" rünnak suureneb
        return suvalineNumber(rünnak, 2);
    }

    public int ravimine(){
        //lisab eludele random numbri elusid
        return suvalineNumber(elud, 5);
    }

    public int kaitse(){
        //lisab "punkte" kilbile
        return suvalineNumber(kilp, 1);
    }

    public int suvalineNumber(int tegevus, int upgrade){
        //genereerib suvalise numbri
        int number = (int) (Math.random()*(tegevus-upgrade+1)+upgrade); //0->tegevus
        return number;

    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        //upgrade -> setElud + upgrade
        if (elud <=0){
            this.elud = 0;
        } else {
        this.elud = elud;
        }
    }

    public int getKilp() {
        return kilp;
    }

    public void setKilp(int kilp) {
        this.kilp = kilp;
    }

    public int getRünnak() {
        return rünnak;
    }

    public void setRünnak(int rünnak) {
        this.rünnak = rünnak;
    }

    public String getNimi() {
        return nimi;
    }
}
