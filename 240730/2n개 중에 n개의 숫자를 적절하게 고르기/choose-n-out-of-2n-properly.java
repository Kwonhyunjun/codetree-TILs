import java.io.*;
import java.util.*;

public class Main {

    static int N, answer, arr[], total; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 

        arr = new int[2*N]; 
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<2*N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            total += arr[i]; 
        }

        // System.out.println(total);

        answer = Integer.MAX_VALUE; 
        combi(0, 0, 0);
        System.out.println(answer); 
    }

    public static void combi(int idx, int cnt, int num){
        if(idx == 2*N){
            if(cnt == N){
                int res = Math.abs(total-num); 
                answer = Math.min(answer, Math.abs(num - res)); 
            }
            return; 
        }

        combi(idx+1, cnt+1, num+arr[idx]); 

        combi(idx+1, cnt, num); 
    }
}