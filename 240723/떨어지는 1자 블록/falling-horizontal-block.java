import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 블록의 크기
        int K = Integer.parseInt(st.nextToken())-1; // 블록이 떨어질 위치에 대한 정보

        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 초기 블록 세팅
        for(int c=K; c<K+M; c++){
            map[0][c] = 1;
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        for(int r=1; r<N; r++){
            boolean flag = true; 
            
            for(int c=K; c<K+M; c++){
                if(map[r][c] == 1) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(int c=K; c<K+M; c++){
                    map[r-1][c] = 0;
                    map[r][c] = 1;
                }
            }else{
                break;
            }
        }
        // System.out.println("블럭이 떨어진 후 "); 
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        
        StringBuilder sb = new StringBuilder(); 
         for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb); 
    }
}