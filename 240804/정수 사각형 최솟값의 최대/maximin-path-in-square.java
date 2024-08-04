import java.io.*;
import java.util.*; 

public class Main {

    static int N, answer, map[][];


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); 
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MIN_VALUE;

        solve(0, 0, map[0][0]); 

        System.out.println(answer); 
    }

    public static void solve(int r, int c, int num){
        if(r == N-1 && c == N-1){
            answer = Math.max(num,answer); 
            return;
        }

        if(r+1 < N){
            solve(r+1, c, Math.min(num, map[r+1][c])); 
        }
        if(c+1 < N){
            solve(r, c+1, Math.min(num, map[r][c+1])); 
        }
        
    }
}