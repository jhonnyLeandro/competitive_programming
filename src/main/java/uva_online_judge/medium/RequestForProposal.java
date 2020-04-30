package uva_online_judge.medium;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  10141 uva problem
*  Request for proposal
**/

public class RequestForProposal {
    public static void main (String args[]) throws IOException {
        //initialize the bufferedReader to read the console
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\competitive_programming\\src\\main\\java\\uva_online_judge\\medium\\requestForProposalInput.txt"));
        // declare string tokenizer
        StringTokenizer st;
        String input;
        // number of request for proposal
        int rfpNumber =0;
        // loop of the algorithm
        while (!(input=br.readLine()).equals("0 0")) {
            // add 1 to the number of request for proposal
            rfpNumber++;
            //initialize the tokenizer
            st = new StringTokenizer(input);
            // save the values for the number of requirements and the number of proposals
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            // variable to save the current proposal name
            String proposalName;
            //declare variables for the proposal price and met requirements
            float proposalPrice;
            int proposalMetRequirements;
            // variable to save the best proposal
            String bestProposal = "";
            //initialize the price in max value
            float price = Float.MAX_VALUE;
            // initialize the met requirements in 0
            int metRequiments = 0;

            //loop until the requirements finished
            while (n-->0){
                // read the requirements
                br.readLine();
            }

            // loop through proposals
            while (p-- > 0) {

                //save the proposal name
                proposalName = br.readLine();
                // Initialize the tokenizer
                st = new StringTokenizer(br.readLine());
                // save the proposal price
                proposalPrice = Float.parseFloat(st.nextToken());
                // save the proposal met requirements
                proposalMetRequirements = Integer.parseInt(st.nextToken());
                // if current proposal is better than the best proposal so far
                // make current proposal the best proposal

                if (proposalMetRequirements > metRequiments ) {
                    // make current proposal the best proposal
                    bestProposal = proposalName;
                    // make the price to beat of the current proposal
                    price = proposalPrice;
                    // make the metRequirements to beat the current met requirements
                    metRequiments = proposalMetRequirements;
                } else if (proposalMetRequirements >= metRequiments && proposalPrice < price){
                    // make current proposal the best proposal
                    bestProposal = proposalName;
                    // make the price to beat of the current proposal
                    price = proposalPrice;
                    // make the metRequirements to beat the current met requirements
                    metRequiments = proposalMetRequirements;
                }

                while (proposalMetRequirements-- > 0) {
                    br.readLine();
                }
            }
            if (rfpNumber > 1) {
                System.out.println();
            }
            //print the results
            System.out.println("RFP #" +rfpNumber );
            System.out.println(bestProposal);
        }
    }
}
