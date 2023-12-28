import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static HashMap<Integer, Integer> m; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); 
        m = new HashMap<>();

        int key = 0; int value = 0; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 

            switch(st.nextToken()){
                case "add" : 
                    key = Integer.parseInt(st.nextToken()); 
                    value = Integer.parseInt(st.nextToken());  
                    m.put(key, value); 
                    break;
                case "remove" :
                    key = Integer.parseInt(st.nextToken()); 
                    m.remove(key); 
                    break;
                case "find" : 
                    key = Integer.parseInt(st.nextToken()); 
                    int ans = m.getOrDefault(key, 0);
                    sb.append( ans == 0 ? "None" : ans ).append("\n"); 
                    break;
            }
        }

        System.out.println(sb); 
    }
}