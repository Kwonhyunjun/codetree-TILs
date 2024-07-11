import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 
        int answer = 0; 

        int[][] map = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N-2; j++){
                // System.out.printf("1 : %d %d\n", i, j);

                int coin = map[i][j] + map[i][j+1] + map[i][j+2];
                
                for(int k=i; k<N; k++){
                    for(int l=0; l<N-2; l++){
                        if(k==i && l < j+3) continue;
                        // System.out.printf("2 : %d %d\n", k, l);
                        int coin2 = map[k][l] + map[k][l+1] + map[k][l+2];

                        answer = Math.max(answer, coin + coin2); 
                    }    
                }

            }
        }

        System.out.println(answer);         
    }
}