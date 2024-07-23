import java.io.*;
import java.util.*; 

public class Main {
    
    static int N;
    static char[][] map;  
    static int[] dr = {0, 1, 0, -1}; // +시계방향 - 반시계방향
    static int[] dc = {1, 0, -1, 0}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N][N]; 

        st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1; 

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray(); 
        }

        int d = 0; // 우측을 바라보고 있음
        int nr = sr;
        int nc = sc; 
        int cnt = 0; 
        
        while(!isOut(nr, nc)){
            int tempR = nr + dr[d];
            int tempC = nc + dc[d]; 
            // System.out.printf("%d %d \n", tempR, tempC);

            // char[][] temp = new char[N][N];
            // for(int i=0; i<N; i++){
            //     for(int j=0; j<N; j++){
            //         temp[i][j] = map[i][j]; 
            //     }
            // }
            // temp[nr][nc] = '*'; 
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(temp[i]));
            // }
            
            if(cnt != 0 && nr == sr && nc == sc){
                System.out.println(-1);
                return; 
            }

            if(!isOut(tempR,tempC) && map[tempR][tempC] == '#'){
                d = rotate(d, 1);
                nr += dr[d];
                nc += dc[d];
                cnt++ ;
            }else{
                if(hasWall(nr, nc, d)){
                    nr += dr[d];
                    nc += dc[d];
                    cnt++;
                }else{
                    d= rotate(d, 0); 
                    nr += dr[d];
                    nc += dc[d];
                    cnt++; 
                }
            }
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