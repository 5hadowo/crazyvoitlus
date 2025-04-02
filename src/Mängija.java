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



    public int ründa(){
        //tagastab ründe tugevuse (arvestades algset tugevust ja kasutades Math.random)
        //upgrade -> "baas" rünnak suureneb
        return suvalineNumber(rünnak);
    }

    public int ravimine(){
        //lisab eludele random numbri elusid
        return suvalineNumber(elud);
    }

    public int kaitse(){
        //lisab "punkte" kilbile
        return suvalineNumber(kilp);
    }

    public int suvalineNumber(int tegevus){
        //genereerib suvalise numbri
        int number = (int) (Math.random()*tegevus+1); //0->tegevus
        return number;

    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        //upgrade -> setElud + upgrade
        this.elud = elud;
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
}
