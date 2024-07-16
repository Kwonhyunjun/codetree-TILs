import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int answer = -1; 
        
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                int up = (r-1 < 0)? -1 : map[r-1][c];
                int down = (r+1 >= N)? -1 : map[r+1][c];
                int down2 = (r+2 >= N)? -1 : map[r+2][c];
                int left = (c-1 < 0)? -1 : map[r][c-1]; 
                int right = (c+1 >= M)? -1 : map[r][c+1];
                int right2 = (c+2 >= M)? -1 : map[r][c+2];

                if(up > 0 && left > 0){
                    answer = Math.max(answer, (map[r][c] + up + left));
                }

                if(up > 0 && right > 0){
                    answer = Math.max(answer, (map[r][c] + up + right));
                }

                if(down > 0 && left > 0){
                    answer = Math.max(answer, (map[r][c] + down + left));
                }

                if(down > 0 && right > 0){
                    answer = Math.max(answer, (map[r][c] + down + right));
                }

                
                if(right > 0 && right2 > 0){
                    answer = Math.max(answer, (map[r][c] + right + right2));
                }

                if(down > 0 && down2 > 0){
                    answer = Math.max(answer, (map[r][c] + down + down2));
                }
            }
        }

        System.out.println(answer);
    }
}