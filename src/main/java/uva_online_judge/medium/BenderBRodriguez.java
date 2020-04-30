package uva_online_judge.medium;

/*
* 11507 uva problem
* Bender B Rodriguez
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BenderBRodriguez {
    public static void main (String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\competitive_programming\\src\\main\\java\\uva_online_judge\\medium\\benderRodriguezInput.txt"));
        int L;
        StringTokenizer st;
        String indications [];
        String wpoint;
        HashMap<String,HashMap<String,String>> norms = new HashMap<>();
        HashMap<String,String> zplus = new HashMap<>();
        HashMap<String,String> zminus = new HashMap<>();
        HashMap<String,String> yminus = new HashMap<>();
        HashMap<String,String> yplus = new HashMap<>();

        // rules for +z
        zplus.put("+x","+z");
        zplus.put("-x","-z");
        zplus.put("-y","-y");
        zplus.put("+y","+y");
        zplus.put("+z","-x");
        zplus.put("-z","+x");

        // rules for -z
        zminus.put("+x","-z");
        zminus.put("-x","+z");
        zminus.put("-y","-y");
        zminus.put("+y","+y");
        zminus.put("-z","-x");
        zminus.put("+z","+x");

        // rules for -y
        yminus.put("+x","-y");
        yminus.put("-x","+y");
        yminus.put("-z","-z");
        yminus.put("+z","+z");
        yminus.put("-y","-x");
        yminus.put("+y","+x");

        // rules for +y
        yplus.put("-y","+x");
        yplus.put("+y","-x");
        yplus.put("+x","+y");
        yplus.put("-x","-y");
        yplus.put("+z","+z");
        yplus.put("-z","-z");

        // general rules
        norms.put("+z", zplus);
        norms.put("-z", zminus);
        norms.put("-y", yminus);
        norms.put("+y",yplus);



        while ((L=Integer.parseInt(br.readLine())) > 0 ){
            wpoint = "+x";
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String ind = st.nextToken();
                if (!ind.equals("No")) {
                    wpoint = norms.get(ind).get(wpoint);
                }
            }
            System.out.println(wpoint);
        }
    }
}
