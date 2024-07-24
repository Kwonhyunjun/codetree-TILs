import java.io.*;
import java.util.*;

public class Main {

    static int N, max[][]; 
    static List<Integer>[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 움직임의 횟수

        map = new ArrayList[N][N];
        max = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = new ArrayList<>();
                int num = Integer.parseInt(st.nextToken());
                map[i][j].add(num);
                max[i][j] = num; 
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            // System.out.printf("num 이동 : %d\n", num);

            for(int r=0; r<N; r++){
                boolean flag = false;
                for(int c=0; c<N; c++){
                    if(map[r][c].contains(num)){
                        // System.out.println(r + " " + c); 
                        move(r, c, num);
                        flag = true; 
                        break;
                    }
                }
                if(flag) break; 
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
          for(int j=0; j<N; j++){
            if(map[i][j].size() == 0){
                sb.append("None").append("\n");
                continue; 
            }
            for(int k=map[i][j].size()-1; k>=0; k--){
                sb.append(map[i][j].get(k)).append(" "); 
            }
            sb.append("\n");
          }  
        }

        System.out.println(sb);
    }

    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static void move(int r, int c, int n){
        // 넘길 위치 확인
        int num = -1; 
        int dir = -1; 
        for(int d=0; d<8; d++){
            int nr = r + dr[d];
            int nc = c + dc[d]; 

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue; 
            if(max[nr][nc] > num){
                dir = d;
                num = max[nr][nc];
            }
        }

        // System.out.printf("d : %d \n", dir); 

        if(dir == -1){
            return;
        }

        // 인덱스 확인
        int idx = 0;
        for(int i=map[r][c].size()-1; i>=0; i--){
            if(map[r][c].get(i) == n){
                idx = i;
                break; 
            }
        }

        // 추가
        for(int i=idx; i<map[r][c].size(); i++){
            int cur = map[r][c].get(i); 
            map[r+dr[dir]][c+dc[dir]].add(cur);
            max[r+dr[dir]][c+dc[dir]] = Math.max(max[r+dr[dir]][c+dc[dir]], cur);
        }

        // 삭제
        for(int i=map[r][c].size()-1; i>=idx; i--){
            map[r][c].remove(i); 
        }
        
        int temp = -1;
        for(int i=0; i<map[r][c].size(); i++){
            temp = Math.max(temp, map[r][c].get(i)); 
        }
        max[r][c] = temp; 
        // System.out.printf("max\n");
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(max[i])); 
        // }

        // System.out.println("map");
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.printf("map[%d][%d] -> %s\n", i, j, map[i][j]); 
        //     }
        // }
    }
}

// 움직일 때는 해당 숫자와 그 위에 있는 숫자들이 다 움직임
// 같이 있어도 해당 칸의 제일 큰 숫자가 대표함
// 만약 선택된 숫자의 인접한 여덟 방향에 아무숫자도 없다면, 그때는 움직이지 않음