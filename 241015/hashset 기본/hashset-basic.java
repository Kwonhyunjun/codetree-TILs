import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); 

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); 
            int num = Integer.parseInt(st.nextToken()); 

            switch(command){
                case "find" :
                    sb.append(set.contains(num)).append("\n"); 
                    break;
                case "add" : 
                    set.add(num);
                    break;
                case "remove" : 
                    set.remove(num);
                    break;
            }
        }

        System.out.println(sb);
    }
}