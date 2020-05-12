package uva_online_judge.ad_hoc_part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess {
    public static void main(String [] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader ("./src/main/java/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine ());
        StringTokenizer st;
        String testcase;
        while (numberOfTestCases > 0 ) {
            if (!(testcase=br.readLine()).equals("")){
                st = new StringTokenizer(testcase);

                String piece = st.nextToken();

                int rows = Integer.parseInt(st.nextToken());

                int columns = Integer.parseInt(st.nextToken());

                if (piece.equals("r") || piece.equals("Q")){
                    System.out.println(Math.min(rows,columns));
                } else if (piece.equals("K")){
                    System.out.println(((rows + 1) / 2) * ((columns + 1) / 2));
                } else if (piece.equals("k")){
                    if (rows % 2 == 1 && columns % 2 == 1) {
                        System.out.println((rows * columns + 1)/2);
                    } else {
                        System.out.println((rows * columns)/2);
                    }
                }
                numberOfTestCases--;
            }

        }
    }
}
