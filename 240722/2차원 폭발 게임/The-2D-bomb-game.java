import java.io.*;
import java.util.*; 

public class Main {
    
    static int N, M, K, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 격자 크기
        M = Integer.parseInt(st.nextToken()); // 터지는 기준횟수
        K = Integer.parseInt(st.nextToken()); // 수행 횟수

        map = new int[N][N]; 

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<K; i++){
            // System.out.println(i);
            while(isBomb()){
                bomb();
                gravity(); 
            }
            rotate();
            gravity(); 
        }
        bomb();

        // StringBuilder sb = new StringBuilder();
        int cnt =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0) cnt++; 
                // sb.append(map[i][j]).append(" "); 
            }
            // sb.append("\n");
        }
        System.out.println(cnt); 
    }

    static void bomb(){
        for(int c=0; c<N; c++){
            int num = 0;
            int cnt = 1;
            // 시작행 찾기
            int start = -1; 
            for(int i=0; i<N; i++){
                if(map[i][c] != 0){
                    start = i; 
                    num = map[i][c]; 
                    break; 
                }
            }
            // System.out.printf("현재행 : %d 시작열 : %d \n", c, start); 
            if(start == -1) continue;
            for(int r=start+1; r<N; r++){
                // System.out.printf("r : %d, cnt : %d \n", r, cnt);
                if(num == map[r][c]){
                    // System.out.println("연속");
                    cnt++; 
                }else{
                    if(cnt >= M){
                        for(int i=1; i<=cnt; i++){
                            map[r-i][c] =0; 
                        }
                        // System.out.printf("현재행 : %d 폭발 \n", c); 
                        // for(int i=0; i<N; i++){
                        //     System.out.println(Arrays.toString(map[i])); 
                        // }
                        // System.out.println(); 
                    }
                    num = map[r][c]; 
                    cnt = 1; 
                }
            }
            // System.out.printf("현재행 : %d 카운트 : %d \n", c, cnt); 
            if(cnt >= M){
                for(int i=0; i<cnt; i++){
                    map[N-1-i][c] =0; 
                }
            }
        }
        // System.out.printf("폭발 후\n"); 
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println(); 
    }

    static void gravity(){ 
        int[][] temp = new int[N][N]; 

        for(int c=0; c<N; c++){
            int idx = N-1; 
            for(int r=N-1; r>=0; r--){
                if(map[r][c] == 0) continue;
                temp[idx--][c] = map[r][c]; 
            }
        }

        map = temp; 
        // System.out.printf("중력작용\n"); 
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println(); 
    }

    static void rotate(){
        int[][] temp = new int[N][N]; 

        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                temp[r][c] = map[N-c-1][r];
            }
        }

        map = temp; 
        // System.out.printf("회전\n"); 
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i])); 
        // }
        // System.out.println();
    }

    static boolean isBomb(){
         for(int c=0; c<N; c++){
            int num = 0;
            int cnt = 1;
            // 시작행 찾기
            int start = -1; 
            for(int i=0; i<N; i++){
                if(map[i][c] != 0){
                    start = i; 
                    num = map[i][c]; 
                    break; 
                }
            }
            // System.out.printf("현재행 : %d 시작열 : %d \n", c, start); 
            if(start == -1) continue;
            for(int r=start+1; r<N; r++){
                // System.out.printf("r : %d, cnt : %d \n", r, cnt);
                if(num == map[r][c]){
                    // System.out.println("연속");
                    cnt++; 
                }else{
                    if(cnt >= M){
                        return true; 
                    }
                    num = map[r][c]; 
                    cnt = 1; 
                }
            }
            // System.out.printf("현재행 : %d 카운트 : %d \n", c, cnt); 
            if(cnt >= M){
                return true; 
            }
        }
        return false;
    }
}