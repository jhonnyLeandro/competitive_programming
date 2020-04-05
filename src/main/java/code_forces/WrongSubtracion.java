package code_forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WrongSubtracion {
    public static void main  (String args []) throws IOException {
        //Initialize the reader of console or file
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int k = Integer.parseInt(tokens.nextToken());

        while (k-- > 0){
            if (n%10 == 0){
                n /=10;
            } else {
                n-=1;
            }
        }
        System.out.println(n);
    }
}
