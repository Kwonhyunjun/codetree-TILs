import java.io.*;
import java.util.*; 

public class Main {
    
    static int N, bomb[], map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 폭탄 터뜨릴 횟수

        map = new int[N][N];
        bomb = new int[N]; 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<M; i++){
            int col = Integer.parseInt(br.readLine())-1;             
            int row = -1; 
            for(int j=0; j<N; j++){
                if(map[j][col] != 0){
                    row = j;
                    break;
                }
            }
            // System.out.printf("폭발열 : %d %d\n", col, row);
            if(row == -1) continue; 
            splash(row, col); 
            bomb[col]++; 
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N ; j++){
                sb.append(map[i][j]).append(" "); 
            }
            sb.append("\n"); 
        }

        System.out.println(sb);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    static void splash(int row, int col){
        int r = row; 
        int c = col; 

        int power = map[r][c];
        map[r][c] = 0; 

        for(int i=0; i<power; i++){
            for(int d=0; d<4; d++){
                int nr = r + dr[d] * i; 
                int nc = c + dc[d] * i; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 

                map[nr][nc] = 0; 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println(); 
        move(); 
    }

    static void move(){
        int[][] temp = new int[N][N]; 

        for(int c=0; c<N; c++){
            int idx = N-1; 
            for(int r=N-1; r>=0; r--){
                if(map[r][c] == 0) continue; 
                temp[idx--][c] = map[r][c];
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(temp[i])); 
        // }
        // System.out.println(); 
        map = temp; 
    }
}