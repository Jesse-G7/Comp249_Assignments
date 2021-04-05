/**
 * Name(s) and ID(s): Tian Gao 40110068, Yitong Zhang 40066756
 * COMP249
 * Assignment # 1
 * Due Date: Feb 8th
 */

//-----------------------------
//Assignment#1
//Question part1
//Written by: Tian Gao 40110068, Yitong Zhang 40066756
//-----------------------------


/**
 * this class
 * @author Tian Gao and Yitong Zhang
 */
public class LadderAndSnake {

    private int numPlayers;
    private int[] players_position;    //store every players position in an array based on the index, each index+1 means represents the player number
    private int[] dice_value;  //recording and updating dice value for each player
    private int[] order;     //playing order
    private int[] rank;  //store the player number in the order of first to last
    private String[] player;

    public LadderAndSnake(int numPlayers, String playerNames) {

        this.numPlayers = numPlayers;
        System.out.println("Game is Played by " + numPlayers + " players");
        players_position = new int[numPlayers];
        dice_value = new int[numPlayers];
        order = new int[numPlayers];
        rank = new int[numPlayers];
        player = new String[numPlayers];
        splitPlayerNames(playerNames);  //call the method and feed element to the player[]

    }

    /**
     * split the names input by the user
     * @param playerNames
     */
    private void splitPlayerNames(String playerNames){
        int count =0;
        for(String name:playerNames.split(" ")){            //loop through the names and store in the player[]
            player[count] = name;
            count++;
        }
    }


    private void decideTurns() {
        System.out.println("Now deciding which player will start playing");
        flipDice();     //flip all

        //print each player's dice value
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + ": " +player[i] + " got a dice value of " + dice_value[i]);
        }

        for (int i = 0; i < numPlayers; i++) {
            for (int j = i + 1; j < numPlayers; j++) {
                //if the same values, flip the pair
                if (dice_value[i] == dice_value[j]) {
                    System.out.println("A tie was achieved between Player " + (i + 1) + ": " +player[i] + " and Player " + (j + 1)
                            + ": " +player[j] + ". Attempting to break the tie");
                    flipDice(i, j);      //flip same value pairs
                    //recheck the values in the dice_value array again, to avoid position i have the same value with the element before position j
                    i = 0;
                    j = i +1;
                }

            }
        }

        //compare dice values and order them
        for (int i=0; i<numPlayers;i++){
            for(int j= i+1;j<numPlayers;j++){
                if (dice_value[i] < dice_value[j]) {
                    order[i] += 1;          //if dice value is smaller than the other one, then increase the order number
                } else {
                    order[j] += 1;          //if dice value larger than the other one, increase the the other order number by one
                }
            }
        }
        //store the bigger value in order[] in rank[] first, in order to print player number by order
        for (int i = 0; i < numPlayers; i++) {
            rank[order[i]] = i;
        }
        System.out.print("Reached final decision on order of playing: ");

        //print players by order
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (rank[i] + 1)+ ": " +player[rank[i]] + ((i == numPlayers - 1) ? "\n" : ", "));
        }


    }


    private void flipDice()   //flip dice for all players
    {
        for (int i = 0; i < numPlayers; i++) {
            dice_value[i] = (int) (Math.random() * 6) + 1;   //get a random number between 1~6
        }
    }

    //flip dice for the pairs that have the same value
    private void flipDice(int i, int j) {
        //keep flipping till different values
        while (dice_value[i] == dice_value[j]) {
            dice_value[i] = (int) (Math.random() * 6) + 1;
            dice_value[j] = (int) (Math.random() * 6) + 1;
        }
        System.out.println("Player " + (i + 1) + ": " +player[i] + " got a dice value of " + dice_value[i]);
        System.out.println("Player " + (j + 1)+ ": " +player[j] + " got a dice value of " + dice_value[j]);
    }


    public void play() {
        decideTurns();
        while (true) {
            flipDice();
            for (int i = 0; i < numPlayers; i++) {

                //players_position uses indexes as the number of the player
                players_position[rank[i]] += dice_value[i];         //update the position base on play order, dice values are not relate to the order of player now

                //check if anyone win first
                if(winCheck(players_position[rank[i]]) == 0) {
                    System.out.print("Player "+ (rank[i]+1) + ": " +player[rank[i]]+ " got dice value of " + dice_value[i] +" ;"
                            +" now in square "+ players_position[rank[i]]+ " \nPlayer " + (rank[i]+1) + ": " +player[rank[i]]
                            +" wins!!! Game Over!");
                    System.exit(0);
                }else if(winCheck(players_position[rank[i]]) == 1){
                    players_position[rank[i]] = 100-(players_position[rank[i]]-100);
                    System.out.println("You've passed position 100 !! Going back "+ (players_position[rank[i]]-100) + " steps");
                }

                System.out.print("Player "+ (rank[i]+1) + ": " +player[rank[i]]+ " got dice value of " + dice_value[i] +" ;");

                //store the current position
                int temp = players_position[rank[i]];
                //check if meet ladder or snake
                players_position[rank[i]] = checkLadderSnake(players_position[rank[i]]);
                //if does not meet a snake or a ladder, print the current position
                if(temp == players_position[rank[i]])
                    System.out.println(" now in square "+ players_position[rank[i]]);

            }
            System.out.println("Game not over; flipping again");
        }
    }


    private int checkLadderSnake(int position) {
        switch (position) {
            case 1:
                System.out.println(" gone to square 1 then up to square 38. Congrats!");
                return 38;
            case 4:
                System.out.println(" gone to square 4 then up to square 14. Congrats!");
                return 14;
            case 9:
                System.out.println(" gone to square 9 then up to square 31. Congrats!");
                return 31;
            case 16:
                System.out.println(" gone to square 16 then down to square 6. Congrats!");
                return 6;
            case 21:
                System.out.println(" gone to square 21 then up to square 42. Congrats!");
                return 42;
            case 28:
                System.out.println(" gone to square 28 then up to square 84. Congrats!");
                return 84;
            case 36:
                System.out.println(" gone to square 36 then up to square 44. Congrats!");
                return 44;
            case 48:
                System.out.println(" gone to square 48 then down to square 30. Congrats!");
                return 30;
            case 51:
                System.out.println(" gone to square 51 then up to square 67. Congrats!");
                return 67;
            case 71:
                System.out.println(" gone to square 71 then up to square 91. Congrats!");
                return 91;
            case 80:
                System.out.println(" gone to square 80 then up to square 100. Congrats!");
                return 100;
            case 93:
                System.out.println(" gone to square 93 then down to square 68. Congrats!");
                return 68;
            case 97:
                System.out.println(" gone to square 97 then down to square 76. Congrats!");
                return 76;
            case 98:
                System.out.println(" gone to square 98 then down to square 78. Congrats!");
                return 78;

        }

        if (position == 62) {
            System.out.println(" gone to square 62 then down to square 19");
            return 19;
        } else if (position == 79) {
            System.out.println(" gone to square 79 then down to square 19");
            return 19;
        } else if (position == 63) {
            System.out.println(" gone to square 63 then down to square 60");
            return 60;
        } else if (position == 64) {
            System.out.println(" gone to square 63 then down to square 60");
            return 60;
        } else if (position == 86) {
            System.out.println(" gone to square 86 then down to square 24");
            return 60;
        } else if (position == 87) {
            System.out.println(" gone to square 87 then down to square 24");
            return 60;
        } else if (position == 94) {
            System.out.println(" gone to square 94 then down to square 24");
            return 60;
        } else if (position == 95) {
            System.out.println(" gone to square 95 then down to square 24");
            return 60;
        }


        return position;
    }


    //check if the position reaches 100, then that player wins, return 0
    private int winCheck(int position){
        if(position == 100){
            return 0;
        }else if (position > 100){
            return 1;
        }else{
            return -1;
        }

    }


}
