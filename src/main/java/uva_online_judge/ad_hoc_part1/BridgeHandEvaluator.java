package uva_online_judge.ad_hoc_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class BrideHandEvaluator {


    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader( new FileReader("./src/main/java/uva_online_judge/ad_hoc_part1/input.txt"));
        String input;
        StringTokenizer st;
        String suitname [] = {"S","H","D","C"};
        HashMap<String,Integer> suitnames = new HashMap<>();
        suitnames.put("S",0);
        suitnames.put("H",1);
        suitnames.put("D",2);
        suitnames.put("C",3);
        while((input=br.readLine()) != null){

            st = new StringTokenizer(input);
            int points = 0;
            int [] suits = new int[4];
            boolean [] aces = new boolean [4];
            boolean [] kings = new boolean [4];
            boolean [] queens  = new boolean [4];
            boolean [] jacks  = new boolean [4];
            boolean [] isSuitStopped = new boolean[4];

            while(st.hasMoreTokens()){

                String card = st.nextToken();
                String suit = card.charAt(1)+"";

                if (card.contains("A")) {
                    points+=4;
                    aces[ suitnames.get(suit)] = true;
                    suits[suitnames.get(suit)]++;
                    isSuitStopped[suitnames.get(suit)] = true;
                } else if (card.contains("K")) {
                    points+=3;
                    kings[suitnames.get(suit)] = true;
                    suits[suitnames.get(suit)]++;
                } else if (card.contains("Q")) {
                    points+=2;
                    queens[suitnames.get(suit)]= true;
                    suits[suitnames.get(suit)]++;
                } else if (card.contains("J")){
                    points++;
                    jacks[suitnames.get(suit)]= true;
                    suits[suitnames.get(suit)]++;
                } else {
                    suits[suitnames.get(suit)]++;
                }
            }

            // check if there is a king of any suit with no other cards
            for (int i=0;i<kings.length;i++) {
                if (kings[i]  && suits[i] == 1) {
                    points--;
                } else if (kings[i]  && suits[i] > 1) {
                    isSuitStopped[i] = true;
                }
            }

            // check if there is a queen of any suite with <= 1 other cards
            for (int i=0;i<queens.length;i++) {
                if ( queens[i] && suits[i] <= 2) {
                    points--;
                } else if ( queens[i] && suits[i] > 2) {
                    isSuitStopped[i] = true;
                }
            }

            // check if there is a suite with a jack with <= 2 cards
            for (int i=0;i<jacks.length;i++) {
                if (jacks[i] && suits[i] <= 3) {
                    points--;
                }
            }

            int maxIndex=0;
            int maxValue=0;
            for(int i=0;i<suits.length;i++){
                if (suits[i]>maxValue){
                    maxValue=suits[i];
                    maxIndex=i;
                }
            }

            String bidsuit = suitname[maxIndex];


            if (points >= 16 && (isSuitStopped[0]&&isSuitStopped[1]&&isSuitStopped[2]&&isSuitStopped[3])) {
                System.out.println("BID NO-TRUMP");
            } else {

                // check if any suit has exactly 2 cards
                for(int i=0;i<suits.length;i++){
                    if (suits[i] == 2) {
                        points++;
                    } else if (suits[i] == 1) {
                        points+= 2;
                    } else if (suits[i] == 0) {
                        points+= 2;
                    }
                }

                if(points < 14){
                    System.out.println("PASS");
                } else {
                    System.out.println("BID " + bidsuit);
                }

            }
        }
    }
}