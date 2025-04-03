public class Katse {
    public static void main(String[] args) {
        int maxElud = 15;
        int upgrade = 3;
        maxElud += upgrade;

        //(int)(Math.random() * (max - min) + min)
        //peaks olema vahemik [3, 8]
        for (int i = 0; i < 20 ; i++) { //[0, 1) -> [0, 5+1)    [3, 9)->
            int number = (int) (Math.random()*(maxElud-upgrade+1)+upgrade);
            System.out.println(number);
        }

    }
}
