import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            
            for(int n=1; n<=N*N; n++){
                // System.out.println(n);
                for(int r=0; r<N; r++){
                    boolean flag = false;
                    for(int c=0; c<N; c++){
                        if(map[r][c] == n){
                            // System.out.printf("%d %d\n", r, c);
                            move(r, c); 
                            flag = true;
                            break; 
                        }
                    }
                    if(flag) break; 
                }

                // for(int l=0; l<N; l++){
                //     System.out.println(Arrays.toString(map[l]));
                // }
                // System.out.println();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" "); 
            }
            sb.append("\n"); 
        }
        System.out.println(sb);
    }

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1}; 
    static void move(int r, int c){
        int num = -1;
        int dir = -1; 

        for(int d=0; d<8; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            
            if(num < map[nr][nc]){
                num = map[nr][nc]; 
                dir = d; 
            }
        }
        // System.out.printf("%d %d %d\n", r, c, dir);
        int temp = map[r][c];
        map[r][c] = num;
        map[r+dr[dir]][c+dc[dir]] = temp;
    }
}