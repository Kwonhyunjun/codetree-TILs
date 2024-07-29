import java.io.*;
import java.util.*;

public class Main {
    
    static int N, arr[], answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 
        
        N = Integer.parseInt(br.readLine()); 

        arr = new int[N];
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        answer = Integer.MAX_VALUE; 
        solve(0, 0); 
        answer = (answer == Integer.MAX_VALUE) ? -1 : answer; 
        System.out.println(answer); 
    }

    static void solve(int pos, int cnt){
        if(pos < N-1 && arr[pos] == 0) return;

        if(pos == N-1){
            answer = Math.min(answer, cnt);
            return; 
        }

        int jumpCnt = arr[pos];
        
        for(int i=1; i<=jumpCnt; i++){
            if((pos + i) >= N) continue;
            solve(pos+i, cnt+1); 
        }

    }
}