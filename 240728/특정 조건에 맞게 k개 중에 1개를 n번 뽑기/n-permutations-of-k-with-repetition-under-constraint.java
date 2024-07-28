import java.io.*;
import java.util.*;

public class Main {

    static int K, N, arr[];
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); 

        arr = new int[N]; 
        solve(0, 0, 0);

        System.out.println(sb); 
    }

    static void solve(int cnt, int num, int count){
        if(cnt >= N){
            for(int i=0; i<N; i++){
                sb.append(arr[i]).append(" "); 
            }
            sb.append("\n"); 
            return; 
        }
        // System.out.printf("%d %d %d\n", cnt, num, count);
        for(int i=1; i<=K; i++){
            if(num == i){
                if((count+1) >= 3) continue; 
                arr[cnt] = i; 
                solve(cnt+1, num, count+1);
            }else{
                arr[cnt] = i; 
                solve(cnt+1, i, 1); 
            }
        }
    }


}