import java.io.*;
import java.util.*; 

public class Main {
    
    static int N;
    static char[][] map; 
    static boolean[][] v; 
    static int[] dr = {0, 1, 0, -1}; // +시계방향 - 반시계방향
    static int[] dc = {1, 0, -1, 0}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N]; 
        v = new boolean[N][N]; 

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1; 

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray(); 
        }

        int d = 0; // 우측을 바라보고 있음
        int r = sr;
        int c = sc; 
        int cnt = 0; 
        
        while(!isOut(r, c)){
            if(v[r][c]){
                System.out.println(-1);
                return; 
            }
            v[r][c] = true; 
            int nr = r + dr[d];
            int nc = c + dc[d]; 
            // String cur = (d == 0) ? "우" : (d == 1)? "하" : (d==2)? "좌" : "상";
            // System.out.printf("%d %d %s \n", nr, nc, cur);

            // char[][] temp = new char[N][N];
            // for(int i=0; i<N; i++){
            //     for(int j=0; j<N; j++){
            //         temp[i][j] = map[i][j]; 
            //     }
            // }
            // temp[r][c] = '*'; 
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(temp[i]));
            // }
            
            // if(cnt != 0 && r == sr && c == sc){
            //     System.out.println(-1);
            //     return; 
            // }
            if(map[r][c] == '#'){
                System.out.println(-1);
                return; 
            }

            if(isOut(nr, nc)){
                cnt++;
                break;
            }

            if(map[nr][nc] == '#'){
                d = rotate(d, 1);
                r += dr[d];
                c += dc[d]; 
                cnt++; 
            }else{
                if(hasWall(nr, nc, d)){
                    r += dr[d];
                    c += dc[d];
                    cnt++;
                }else{
                    d = rotate(d, 0); 
                    r = nr + dr[d];
                    c = nc + dc[d]; 
                    cnt += 2; 
                }
            }
            // System.out.println("cnt : "+cnt); 
            
        }

        System.out.println(cnt); 
    }

    static boolean isOut(int r , int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return true; 
        }
        return false; 
    }

    static boolean hasWall(int r, int c, int d){
        int right = (d + 1) % 4;
        r += dr[right];
        c += dc[right]; 

        if(map[r][c] == '#'){
            return true;
        }
        return false; 
    }

    static int rotate(int curD, int direction){
        int result = 0;
        if(direction == 0) // 시계방향
            result = (curD + 1) % 4; 
        else // 반시계방향
            result = (curD-1 == -1)? 3 : curD-1; 

        // String cur = (curD == 0) ? "우" : (curD == 1)? "하" : (curD==2)? "좌" : "상";
        // String res = (result == 0) ? "우" : (result == 1)? "하" : (result==2)? "좌" : "상";
        // System.out.println("방향전환 "+ cur +" -> "+res); 
        return result; 
    }
}