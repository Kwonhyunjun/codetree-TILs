/*
    특정 위치에서 시작하여 현재 위치에 적혀있는 방향에 있는 숫자들 중 현재 숫자보다 더 큰 숫자가 적혀있는 곳으로 이동하는 것을 최대한 반복
*/
import java.io.*;
import java.util.*;

public class Main {

    static int N, answer, map[][][]; 

    static int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1}; 

    static ArrayList<int[]> nextPos; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        map = new int[N][N][2]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j][0] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j][1] = Integer.parseInt(st.nextToken()); 
            }
        }

        st = new StringTokenizer(br.readLine()); 
        int sr = Integer.parseInt(st.nextToken())-1;
        int sc = Integer.parseInt(st.nextToken())-1;
        
        solve(sr, sc, 0); 

        System.out.println(answer); 
    }

    static void solve(int r, int c, int cnt){
        // System.out.printf("현재 위치 : map[%d][%d] = %d\n", r, c, map[r][c][0]);
        answer = Math.max(answer, cnt);

        int num = map[r][c][0]; 
        int d = map[r][c][1]; 
        int nr = r + dr[d];
        int nc = c + dc[d]; 

        while(isRange(nr, nc)){
            if(map[nr][nc][0] > num){
                // System.out.printf("다음 위치 : map[%d][%d] = %d\n", nr, nc, map[nr][nc][0]);
                solve(nr, nc, cnt+1); 
            }
            nr += dr[d];
            nc += dc[d]; 
        }

        // if(nextPos.size() == 0){
        //     answer = Math.max(answer, cnt); 
        //     return; 
        // }

        // for(int i=0; i<nextPos.size(); i++){
        //     int[] next = nextPos.get(i); 
        //     solve(next[0], next[1], cnt+1, new ArrayList<>()); 
        // }
    }

    static boolean isRange(int r , int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return false; 
        }

        return true;
    }
}