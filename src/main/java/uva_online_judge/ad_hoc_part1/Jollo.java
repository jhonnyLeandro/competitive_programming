package uva_online_judge.ad_hoc_part1;

import java.io.*;
import java.util.StringTokenizer;

public class Jollo {
    public static void main (String [] args) throws FileNotFoundException, IOException {

        //BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader( new FileReader("./src/main/java/input.txt"));
        StringTokenizer st;
        String input;

        while(!(input=br.readLine()).equals("0 0 0 0 0")){

            boolean isUsed [] = new boolean[53];

            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            isUsed[a] = true;
            isUsed[b] = true;
            isUsed[c] = true;
            isUsed[x] = true;
            isUsed[y] = true;
            int winningCard = -1;

            int cards [] = {a,b,c};
            boolean continueSearch = true;
            boolean areAllGamesWon = true;

            for (int i = 0;i < cards.length && continueSearch;i++){
                for (int j = 0;j < cards.length && continueSearch;j++){

                    // The indexes have to be different to pick the cards
                    if ( i != j) {
                        boolean picked [] = new boolean [3];

                        picked[i] = true;
                        picked[j] = true;

                        boolean found = false;

                        // this variable saves the index of the card left in this game
                        int leftCard = 0;

                        for(int m = 0;m < picked.length && !found;m++){
                            if (!picked[m]){
                                leftCard = m;
                                found = true;
                            }
                        }

                        if (cards[i] > x &&  cards[j] < y ) {

                            areAllGamesWon = false;

                            if (winningCard < cards[leftCard]) {
                                winningCard = giveWinningCard(cards[leftCard]+1, isUsed);
                            }
                            continueSearch = !(winningCard == -1) ;
                            //if the game is already won in the second round
                        } else if (cards[i] < x &&  cards[j] < y ) {


                            if (areAllGamesWon) {
                                winningCard = giveWinningCard(1, isUsed);
                            }

                            // if the prince wins first round and loses the second
                        } else if (cards[i] < x &&  cards[j] > y ) {

                            areAllGamesWon = false;
                            if (winningCard < cards[leftCard]) {
                                winningCard = giveWinningCard(cards[leftCard]+1, isUsed);
                            }
                            continueSearch = !(winningCard == -1);
                            // if the game is lost
                        } else if (cards[i] > x && cards[j] > y) {

                            continueSearch = false;
                            winningCard = -1;

                        } else if (cards[i] > y && cards[j] > x ) {

                            continueSearch = false;
                            winningCard = -1;

                        }
                    }
                }
            }
            System.out.println(winningCard);
        }
    }

    static int giveWinningCard(int minimumCard, boolean isUsed []) {
        for (int n = minimumCard; n < isUsed.length ; n++) {
            if (!isUsed[n]){
                return n;
            }
        }
        return -1;
    }
}
