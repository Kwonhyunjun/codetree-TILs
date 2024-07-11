import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        char[][] map = new char[N][M];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray(); 
        }

        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){
                if(map[r][c] != 'L') continue;
                // System.out.printf("%d %d\n", r, c);
                
                for(int d=0; d<8; d++){
                    String str = "L"; 

                    int nr = r + dr[d];
                    int nc = c + dc[d]; 

                    while(str.length() < 3){
                        if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;

                        str += map[nr][nc];

                        nr += dr[d];
                        nc += dc[d];                        
                    }

                    // System.out.println(str); 

                    if(str.equals("LEE")) {
                        // System.out.printf("map[%d][%d] 방향 : %d\n", r, c, d); 
                        answer++; 
                    }
                }

            }
        }

        System.out.println(answer); 
        
    }
}