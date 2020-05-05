package uva_online_judge.ad_hoc_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * uva exercise
 * 10646 - What is the Card?
 */

public class WhatIsTheCard {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader( new FileReader("./src/main/java/uva_online_judge/ad_hoc_part1/input.txt"));
        int input = Integer.parseInt(br.readLine());
        int casecounter = 0;
        while(input-- > 0){
            casecounter++;
            String cards = br.readLine();
            String array[] = cards.split(" ");
            int y = 0;
            int counter = (array.length -1) -25;
            for(int i=0;i<3;i++){
                int x = 0;
                String c = array[counter];
                if ( c.contains("A") || c.contains("K") || c.contains("Q") || c.contains("J") || c.contains("T" )){
                    x=10;
                    array[counter]="*";
                    counter--;
                } else {
                    x = Integer.parseInt(c.charAt(0)+"");
                    int removedCards = 10 - x;
                    int limit = counter - removedCards;
                    for(int j=counter;j >= limit;j--){
                        array[j]="*";
                    }
                    counter = limit -1;
                }
                y+=x;
            }
            String card= "";
            for (int i=0;i<array.length && y > 0;i++){
                if(!array[i].equals("*")){
                    y--;
                    card=array[i];
                }
            }
            System.out.println("Case " + casecounter +": " + card);
        }
    }
}
