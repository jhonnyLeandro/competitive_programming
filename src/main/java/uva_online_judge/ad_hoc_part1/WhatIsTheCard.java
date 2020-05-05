package uva_online_judge.ad_hoc_part1;


import com.sun.org.apache.xerces.internal.parsers.XPointerParserConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * uva exercise
 * 10646 - What is the Card?
 */

public class WhatIsTheCard {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        while(input-- > 0){
            String cards = br.readLine();
            String array[] = cards.split(" ");
            int y = 0;
            int counter = (array.length -1) -25;
            for(int i=0;i<3;i++){
                int x = 0;
                String c = array[counter];
                if ( c.contains("A") || c.contains("K") || c.contains("Q") || c.contains("J") || c.contains("T" )){
                    x=10;
                } else {
                    x = Integer.parseInt(c.charAt(0)+"");
                    int removedCards = 10 - x;
                    int limit = counter - removedCards;
                    for(int j=(counter-1);j >= limit;j--){

                    }
                }
            }
        }
    }
}
