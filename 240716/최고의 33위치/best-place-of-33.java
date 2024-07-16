import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int answer = 0; 
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<=N-3; i++){
            for(int j=0; j<=N-3; j++){
                // System.out.println(i+" "+j); 

                int temp = 0;

                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        temp += map[i+k][j+l];
                        // System.out.printf("map[%d][%d] ", i+k, j+l); 
                    }
                }
                // System.out.println(); 
                answer = Math.max(answer, temp);
            }
        }

        System.out.println(answer); 
        
    }
}