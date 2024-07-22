import java.io.*;
import java.util.*; 

public class Main {
    
    static int N, map[][], temp[][];

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

        int answer = Integer.MIN_VALUE; 

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                bomb(r, c);
                gravity();
                answer = Math.max(answer, countPair());
            }
        }

        System.out.println(answer);
    }

    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 
    static void bomb(int r, int c){
        temp = new int[N][N]; 
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                temp[i][j] = map[i][j]; 
            }
        }
        
        int power = temp[r][c];

        temp[r][c] = 0; 
        for(int i=0; i<power; i++){
            for(int d=0; d<4; d++){
                int nr = r + dr[d] * i;
                int nc = c + dc[d] * i;

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                temp[nr][nc] = 0; 
            }
        }
        // System.out.println("폭발");
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(temp[i]));
        // }
    }

    static void gravity(){
        int[][] temp2 = new int[N][N];

        for(int c=0; c<N; c++){
            int idx = N -1; 
            for(int r=N-1; r>=0; r--){
                if(temp[r][c] != 0){
                    temp2[idx--][c] = temp[r][c]; 
                }
            }
        }

        temp = temp2; 
        // System.out.println("중력");
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(temp[i]));
        // }
    }

    static int countPair(){
        int cnt = 0;

        // 행
        for(int r=0; r<N; r++){
            for(int c=0; c<N-1; c++){
                if(temp[r][c] == 0) continue; 
                if(temp[r][c] == temp[r][c+1]){
                    cnt++;
                    c++; 
                }
            }
        }

        for(int c=0; c<N; c++){
            for(int r=0; r<N-1; r++){
                if(temp[r][c] == 0) continue; 
                if(temp[r][c] == temp[r+1][c]){
                    cnt++;
                    r++; 
                }
            }
        }

        return cnt; 
    }
}