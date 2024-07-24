import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], cnt[][];
    static List<Biz> list; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int T = Integer.parseInt(br.readLine()); 
        
        for(int t=0; t<T; t++){
            // System.out.printf("t : %d\n", t);
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 격자의 크기
            int M = Integer.parseInt(st.nextToken()); // 구슬 개수
            
            map = new int[N][N]; 
            cnt = new int[N][N];

            list = new ArrayList<>();
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine()); 

                int r = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1; 
                char dir = st.nextToken().charAt(0); 
                int d = (dir == 'U') ? 0 : (dir == 'D') ? 2 : (dir == 'L')? 3 : 1;
                list.add(new Biz(r, c, d)); 
                map[r][c] = 1;
                // cnt[r][c]++; 
            }


            for(int i=0; i<2*N; i++){
                move(); 
                // System.out.println(i);
                // for(Biz b : list){
                //     System.out.printf("[%d][%d] %d %b\n", b.r, b.c, b.d, b.isAlive);
                // }
            }
            int res = 0;
            // 구슬 갯수 출력
            for(Biz b : list){
                if(b.isAlive) res++;
            }

            System.out.println(res);
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1}; 
    
    static void move(){
        // 움직이기
        for(Biz b : list){
            // System.out.printf("전 : [%d][%d] %d %b\n", b.r, b.c, b.d, b.isAlive);
            if(!b.isAlive) continue; 
            int nr = b.r + dr[b.d];
            int nc = b.c + dc[b.d]; 

            // System.out.printf("nr : %d, nc : %d\n", nr, nc);

            if(nr < 0 || nc < 0 || nr >= N || nc >= N){
                b.d = (b.d + 2) % 4; 
                continue; 
            }

            map[b.r][b.c]--;
            map[nr][nc]++; 
            b.r = nr;
            b.c = nc; 

            // System.out.printf("후 : [%d][%d] %d %b\n", b.r, b.c, b.d, b.isAlive);
        }
        
        // 충돌여부 확인
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(map[r][c] >= 2){
                    // System.out.println("충돌");
                    for(Biz b : list){
                        if(b.r == r && b.c == c){
                            b.isAlive = false; 
                        }
                    }
                    map[r][c] = 0; 
                }
            }
        }
    }
    

    static class Biz{
        int r;
        int c; 
        int d; 
        boolean isAlive = true; 

        public Biz(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}