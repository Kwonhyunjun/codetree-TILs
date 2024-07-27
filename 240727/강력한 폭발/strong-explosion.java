import java.io.*;
import java.util.*;

public class Main {

    static int N, answer,  map[][];
    static ArrayList<int[]> bombs = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];  

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
                if(map[i][j] == 1) bombs.add(new int[]{i, j}); 
            }
        }

        solve(0); 

        System.out.println(answer); 
    }

    static void solve(int cnt){
        if(cnt== bombs.size()){
            int area = 0; 

            for(int i=0; i<N; i++){
                // System.out.println(Arrays.toString(map[i])); 
                for(int j=0; j<N; j++){
                    if(map[i][j] <= -1 || map[i][j] > 0) area++; 
                }
            }
            
            // System.out.println("area : " + area);
            answer = Math.max(answer, area); 
            return; 
        }

        bomb1(cnt, -1);
        solve(cnt+1);
        bomb1(cnt, 0);

        bomb2(cnt, -1);
        solve(cnt+1);
        bomb2(cnt, 0);

        bomb3(cnt, -1);
        solve(cnt+1);
        bomb3(cnt, 0);
    }

    static int[] dr = 
    {
        -2, -1, 1, 2, 
        -1, 0, 1, 0, 
        -1, -1, 1, 1
    }; 
    static int[] dc = 
    {
        0, 0, 0, 0, 
        0, 1, 0, -1,
        -1, 1, 1, -1
    };

    static void bomb1(int cnt, int type){
        int r = bombs.get(cnt)[0];
        int c = bombs.get(cnt)[1]; 
        // System.out.printf("bomb 1 : map[%d][%d] %d\n", r, c, type);

        for(int d=0; d<4; d++){
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] > 0) continue;

            if(type == 0){
                map[nr][nc]++; 
            }else{
                map[nr][nc]--; 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println();
    }

    static void bomb2(int cnt, int type){
        int r = bombs.get(cnt)[0];
        int c = bombs.get(cnt)[1]; 
        // System.out.printf("bomb 2 : map[%d][%d] %d\n", r, c, type);

        for(int d=4; d<8; d++){
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] > 0) continue;

            if(type == 0){
                map[nr][nc]++; 
            }else{
                map[nr][nc]--; 
            }
        }
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println();
    }

    static void bomb3(int cnt, int type){
        int r = bombs.get(cnt)[0];
        int c = bombs.get(cnt)[1]; 
        // System.out.printf("bomb 3 : map[%d][%d] %d\n", r, c, type);

        for(int d=8; d<12; d++){
            int nr = r + dr[d]; 
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] > 0) continue;

            if(type == 0){
                map[nr][nc]++; 
            }else{
                map[nr][nc]--; 
            }
        }
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println();
    }
}