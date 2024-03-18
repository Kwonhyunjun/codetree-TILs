import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0; 
        for(int i=0; i<N; i++){
            if( (i+2) > N ) continue;
            for(int j=0; j<N; j++){
                int cnt = 0;
                for(int k=0; k<3; k++){
                    // System.out.println(k + " " + j); 
                    if(map[i][k] == 1) cnt++; 
                }
                // System.out.println(); 
                ans = Math.max(ans, cnt); 
            }
        }

        System.out.println(ans);
    }
}