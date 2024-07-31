import java.io.*;
import java.util.*;

public class Main {
    
    static int N, map[][], people;
    static boolean[][] v; 
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        v = new boolean[N][N]; 

        map = new int[N][N]; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int village = 0; 

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 0) continue;
                if(v[i][j]) continue; 
                
                v[i][j] = true; 
                village++; 

                people = 1; 
                dfs(i, j);
                // System.out.println(people);
                list.add(people); 
            }
        }

        Collections.sort(list); 

        System.out.println(village);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1}; 
    public static void dfs(int r , int c){
        
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            if(map[nr][nc] == 0) continue; 
            if(v[nr][nc]) continue; 

            people++;
            v[nr][nc] = true;
            dfs(nr, nc);

        }
    }
}