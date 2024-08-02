/*
    0, 1, 2, 3 로만 이루어진 N*N 격자
    h명의 사람
    비를 피할 수 있는 공간의 위치 m개
    각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리를 구해라

    숫자 0 - 이동할 수 있음 
    숫자 1 - 이동 X
    숫자 2 - 사람이 서있음
    숫자 3 - 비를 피할 수 있는 공간
*/

import java.io.*;
import java.util.*;

public class Main {

    static int N, H, M, map[][], answer[][], temp; 
    static ArrayList<int[]> person = new ArrayList<>();
    static boolean[][] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        answer = new int[N][N];
        v = new boolean[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                int n = Integer.parseInt(st.nextToken()); 
                map[i][j] = n; 
                if(n == 2){
                    person.add(new int[]{i, j}); 
                }
            }
        }

        for(int i=0; i<person.size(); i++){
            int[] cur = person.get(i); 
            int r = cur[0];
            int c = cur[1]; 

            temp = 0;
            for(int j=0; j<N; j++){
                Arrays.fill(v[j], false); 
            } 

            if(bfs(r, c)){
                answer[r][c] = temp;
            }else{
                answer[r][c] = -1; 
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N ;i++){
            for(int j=0; j<N; j++){
                sb.append(answer[i][j]).append(" "); 
            }
            sb.append("\n");
        }

        System.out.println(sb); 
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; 

    public static boolean bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();

        v[sr][sc] = true;
        q.offer(new int[]{sr, sc, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(map[cur[0]][cur[1]] == 3){
                temp = cur[2]; 
                return true; 
            }

            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
                if(map[nr][nc] == 1) continue; 
                if(v[nr][nc]) continue; 

                v[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2]+1}); 
            }
        }

        return false; 
    }
}