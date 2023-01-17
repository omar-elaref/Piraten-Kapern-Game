package pk;

public class Player {
    static Dice dice = new Dice();
    public static String rolledDice = dice.numberOfRolls();

    public static String getDice(){
        return rolledDice;
    }


    public void setDice(String rolledDice){
        this.rolledDice = rolledDice;
    }

    public int skullCount(String array[]){
        int skull2 = 0;
        for (int j = 0; j < array.length; j++){
            if (array[j] == "SKULL"){
                skull2 += 1;
            }
        }
        return skull2;
    }

    
    /*
    public static String play() {
        String[] outputs = new String[8];
        Dice die = new Dice();

        boolean run = true;
        int skull = 0;
        int round = 0;
        while (run) {
            String ans = String.valueOf(die.roll());
            if (ans == "SKULL") {
                skull += 1;
            }
            outputs[round] = ans;
            if (round >= 7) {
                run = false;
            }
            if (skull == 3) {
                run = false;
            }
            round++;
        }
        System.out.println(Arrays.toString(outputs));
        System.out.println(skull);
        boolean run2 = true;

        while (run2) {
            int random = (int) Math.round(Math.random() * 6);

            if (skullCount(outputs) >= 3){
                run2 = false;
                continue;
            }

            int change = 8 - random;

            for (int i = random; i < outputs.length; i++) {
                if (skullCount(outputs) >= 3){
                    run2 = false;
                    continue;
                }

                if (outputs[i] == "SKULL") {
                    continue;
                } else {
                    String newRoll = String.valueOf(die.roll());
                    outputs[i] = newRoll;
                }
            }
            System.out.println(Arrays.toString(outputs));
            System.out.println(skullCount(outputs));
        }
        return Arrays.toString(outputs);
    }*/

}
