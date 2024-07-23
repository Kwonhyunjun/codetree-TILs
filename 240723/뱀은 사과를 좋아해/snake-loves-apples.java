import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 사과의 개수
        int K = Integer.parseInt(st.nextToken()); // 방향 변환 횟수

        int[][] map = new int[N][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 
            int r = Integer.parseInt(st.nextToken()) -1; 
            int c = Integer.parseInt(st.nextToken()) -1; 
            map[r][c] = 1; 
        }

        Deque<int[]> snack = new ArrayDeque<>();
        snack.addFirst(new int[]{0, 0}); 
        int time = 0; 

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine()); 
            char c = st.nextToken().charAt(0);
            int d = (c == 'U')? 0 : (c == 'D')? 1 : (c=='L')? 2 : 3;   
            int dist = Integer.parseInt(st.nextToken());

            boolean isDone = false; 

            for(int j=0; j<dist; j++){
                // 출력을 위한 코드
                // char[][] temp = new char[N][N]; 
                // for(int r=0; r<N; r++){
                //     for(int l=0; l<N; l++){
                //         temp[r][l] = String.valueOf(map[r][l]).charAt(0); 
                //     }
                // }
                // for(int[] s : snack){
                //     temp[s[0]][s[1]] = '*'; 
                // }
                // for(int r=0; r<N; r++){
                //     System.out.println(Arrays.toString(temp[r]));
                // }
                // 출력을 위한 코드

                int nr = snack.peekFirst()[0] + dr[d]; 
                int nc = snack.peekFirst()[1] + dc[d]; 
                // System.out.printf("%d %d \n", nr, nc);

                if(nr < 0 || nc < 0 || nr >= N || nc >= N){
                    // System.out.println("나감"); 
                    System.out.println(time+1);
                    return; 
                }

                if(map[nr][nc] == 1){ // 사과가 있다면
                    map[nr][nc] = 0; 
                }else{
                    snack.pollLast(); 
                }

                for(int[] s : snack){
                    if(s[0] == nr && s[1] == nc){
                        // System.out.println("겹침"); 
                        System.out.println(time+1);
                        return; 
                    }
                }

                snack.addFirst(new int[]{nr, nc}); 

                time++; 
            }
        }
        System.out.println(time); 
    }  
}