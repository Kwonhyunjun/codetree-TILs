import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] map = new int[N][N]; 
        map[r][c] = 1; 

        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1}; 

        for(int t=1; t<=M; t++){
            int dist = (int) Math.pow(2, (t-1));
            
            int[][] temp = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 0) continue; 
                    temp[i][j] = 1; 
                    for(int d=0; d<4; d++){
                        int nr = i + dr[d] * dist; 
                        int nc = j + dc[d] * dist; 

                        if(nr < 0 || nc < 0 || nr >=N || nc >= N) continue; 
                        temp[nr][nc] = 1; 
                    }
                }
            }

            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(temp[i])); 
            // }
            // System.out.println(); 
            map = temp; 
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1) answer++;
            }
        }

        System.out.println(answer); 
    }
}