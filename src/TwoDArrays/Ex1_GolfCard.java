package TwoDArrays;

public class Ex1_GolfCard {


    public static void run() {

        String[] names = {"Bob", "Serena", "Gill", "Steve"};
        int[][] scorecard = new int[4][18];

        System.out.println(scorecard.length);

        scorecard[0][0] = 4;
        scorecard[1][0] = 3;
        scorecard[2][0] = 5;
        scorecard[3][0] = 4;

        scorecard[0][1] = 6;
        scorecard[1][1] = 3;
        scorecard[2][1] = 4;
        scorecard[3][1] = 4;

        scorecard[0][2] = 6;
        scorecard[1][2] = 2;
        scorecard[2][2] = 4;
        scorecard[3][2] = 3;


        System.out.println("Name       Scores");
        for (int row = 0; row < scorecard.length; row++) {
            int playerScore = 0;

            for (int col = 0; col < scorecard[row].length; col++) {
                System.out.print(scorecard[row][col] + "  ");
                playerScore += scorecard[row][col];
            }

            System.out.print(names[row] + "   ");

            System.out.print("Score:  " + playerScore);

            System.out.println();

        }


        //Total and print each person's score
        //Separately from the above for loops, average the score for hole 1.
        for (int row = 0; row < 18; row++) {
            int holeTotal = 0;
            for (int col = 0; col < 4; col++) {
                holeTotal += scorecard[col][row];
            }
            System.out.print(holeTotal + "  ");
        }

    }


}
