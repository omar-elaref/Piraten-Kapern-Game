import pk.Dice;
import pk.Game;
import pk.Player;
import pk.Strategy;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");

        Game firstTry = new Game();
        firstTry.game();


        /*Strategy strat = new Strategy();

        Player player1 = new Player();
        while (player1.goldDiamond < 60){
            player1.points(strat.randomStrategy());
        }*/



    }
    
}
