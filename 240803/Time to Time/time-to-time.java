import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sh = Integer.parseInt(st.nextToken());
        int sm = Integer.parseInt(st.nextToken());

        int eh = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());

        int answer = 0; 
        
        while(true){
            answer++; 
            sm++; 
            if(sm >= 60){
                sh++;
                sm = 0; 
            }

            if(sh == eh && sm == em) break; 
        }

        System.out.println(answer);
    }
}