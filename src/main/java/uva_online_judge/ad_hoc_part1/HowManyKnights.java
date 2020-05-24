package uva_online_judge.ad_hoc_part1;

import java.io.*;
import java.util.StringTokenizer;

public class HowManyKnights {
    public static void main(String args []) throws FileNotFoundException, IOException {

        //BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer tokenizer;

        while(!(input=reader.readLine()).equals("0 0")){
            tokenizer = new StringTokenizer(input);
            double M = Double.parseDouble(tokenizer.nextToken());
            double N = Double.parseDouble(tokenizer.nextToken());
            int numberOfKnightsPlaced = 0;
            if (M == 0 || N == 0){
                numberOfKnightsPlaced = 0;
            } else if (M == 1 ){
                numberOfKnightsPlaced = (int)N;
            } else if (N == 1) {
                numberOfKnightsPlaced = (int) M;
            }else if (M == 2 || N == 2){
                if (M == N) {
                   numberOfKnightsPlaced = (int) (N * M) ;
                } else if (M == 2 ) {
                    double value = Math.ceil((N / M));
                    if (value % 2 == 0) {
                        numberOfKnightsPlaced = (int) value * 2;
                    } else {
                        numberOfKnightsPlaced = (int)((N/M)+1) * 2;
                    }
                } else if (N == 2) {
                    double value = Math.ceil((M / N));
                    if (value % 2 == 0) {
                        numberOfKnightsPlaced = (int) value * 2;
                    } else {
                        numberOfKnightsPlaced = (int)((M/N)+1) * 2;
                    }
                }
            } else {
                if (M % 2 == 1 || N % 2 == 1) {
                    numberOfKnightsPlaced = (int)(M * N +1)/2;
                } else {
                    numberOfKnightsPlaced = (int)(M * N )/2;
                }
            }
            System.out.println(numberOfKnightsPlaced + " knights may be placed on a " + ((int) M) + " row " +( (int) N) + " column board.");
        }
    }
}
