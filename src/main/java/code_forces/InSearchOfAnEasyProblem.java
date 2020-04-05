package code_forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InSearchOfAnEasyProblem {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String poll = br.readLine().trim();
        boolean foundHard = false;

        for (int i= 0; i < poll.length() && !foundHard;i++){
            if (poll.charAt(i) == '1'){
                foundHard = true;
            }
        }

        if (foundHard){
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
