package pk;

public class Game {
    //2 Players play the game
    public int game(){
        Strategy firstStrategy = new Strategy();
        Player player1 = new Player();
        Player player2 = new Player();

        int round = 1;
        while (round <43){
            System.out.println("ROUND " + round);
            System.out.println("Player 1 turn:");
            player1.points(firstStrategy.randomStrategy());

            System.out.println("Player 2 turn:");
            player2.points(firstStrategy.randomStrategy());

            round++;
        }
        return player1.goldDiamond;
    }
}
