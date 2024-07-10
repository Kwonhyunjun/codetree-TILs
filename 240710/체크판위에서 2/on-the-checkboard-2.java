import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, answer; 
    static String map[][]; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer =0; 
        map = new String[N][M];

        for(int i=0; i<N ;i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = st.nextToken();
            }
        }

        solve(0, 0, map[0][0], 0); 
        System.out.println(answer); 
    }

    static void solve(int r, int c, String type, int cnt){
        // System.out.printf("map[%d][%d] %d번\n", r+1, c+1, cnt);
        if(r >= N || c >= M) return; 

        if(r == N-1 && c == M-1 && cnt == 3){
            // System.out.println("도착");
            answer++; 
            return;
        }

        for(int i=r+1; i<N; i++){
            for(int j=c+1; j<M; j++){
                if(!map[r][c].equals(map[i][j])){
                    // System.out.printf("map[%d][%d] -> map[%d][%d] %d번\n", r+1, c+1, i+1, j+1, cnt);
                    solve(i, j, map[i][j], cnt+1); 
                }
            }
        }

    }
}