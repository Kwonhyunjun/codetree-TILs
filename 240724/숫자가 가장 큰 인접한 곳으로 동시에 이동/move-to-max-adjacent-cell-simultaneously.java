import java.io.*;
import java.util.*; 

public class Main {

    static int N, map[][], biz[][], temp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int T = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];
        biz = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            biz[r][c] = 1; 
        }
        // System.out.println("초기상태"); 
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(biz[i]));
        // }

        for(int t=1; t<=T; t++){

            temp = new int[N][N]; 
            
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(biz[r][c] == 0) continue;
                    move(r, c); 
                }
            }

            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(temp[r][c] >= 2) {
                        // System.out.printf("%d %d 충돌\n", r, c);
                        temp[r][c] = 0; 
                    }
                }
            }

            biz = temp;
            // System.out.printf("t : %d\n", t); 
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(biz[i]));
            // }
            
        }

        int cnt = 0;

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(biz[r][c] == 1) cnt++; 
            }
        }
        System.out.println(cnt);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 
    static void move(int r, int c){
        int num = -1; 
        int dir = -1; 

        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            
            if(map[nr][nc] > num){
                num = map[nr][nc];
                dir = d;  
            }
        }

        if(dir == -1){
            temp[r][c]++;
        }else{
            temp[r+dr[dir]][c+dc[dir]]++; 
        }
    }
}