import java.util.Scanner;

public class Mängija {
    private String nimi;
    private int maxElud;
    private int rünnak;
    private int maxKilp;

    int elud, kilp;

    public Mängija(String nimi, int maxElud, int rünnak, int maxKilp) {
        this.nimi = nimi;
        this.maxElud = maxElud;
        this.rünnak = rünnak;
        this.maxKilp = maxKilp;
        elud = maxElud;
        kilp = maxKilp;
    }



    public void uuendus(Scanner scanner){
        System.out.print("Oled teeninud uuenduse! \nUuenduse valimiseks sisetsa number \n1. Rünne +2 \n2. Elud + 5 \n3. Kilp +1");
        String uuendus = scanner.nextLine();
        switch (uuendus) {
            case "1":
                rünnak += 2;
                break;
            case "2":
                maxElud += 5;
                break;
            case "3":
                maxKilp += 1;
                break;
        }
        //alustame uut taset maxElude ja maxKilbiga
        elud = maxElud;
        kilp = maxKilp;

        System.out.println("Sinu andmed: " + toString());

    }

    @Override
    public String toString() {
        return nimi + ": Elud " + elud +
                ", Rünnak " + rünnak +
                ", Kilp " + kilp;
    }

    public int ründa(){
        //tagastab ründe tugevuse
        return suvalineNumber(rünnak, 2);
    }

    public int ravimine(){
        //lisab eludele random numbri elusid
        int tervenda = suvalineNumber(maxElud/2, 5);
        if (tervenda + elud > maxElud){
            tervenda = maxElud-elud;
        }
        return tervenda;
    }

    public int kaitse(){
        //lisab "punkte" kilbile
        return suvalineNumber(maxKilp, 1);
    }

    public int suvalineNumber(int max, int min){
        //genereerib suvalise numbri vahemikus [min, max]
        int number = (int) (Math.random()*(max-min+1)+min); //0->max
        return number;

    }

    public int getMaxElud() {
        return maxElud;
    }

    public void setMaxElud(int maxElud) {
        this.maxElud = maxElud;
    }

    public int getMaxKilp() {
        return maxKilp;
    }

    public void setMaxKilp(int maxKilp) {
        this.maxKilp = maxKilp;
    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        if (elud>maxElud){
            this.elud = maxElud;
        } else if (elud <= 0){
            this.elud = 0;
        } else {
            this.elud = elud;
        }
    }

    public int getKilp() {
        return kilp;
    }

    public void setKilp(int kilp) {
        if (kilp > maxKilp){
            this.kilp = maxKilp;
        } else {
        this.kilp = kilp;
        }
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
