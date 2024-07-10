import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 

        int[][] map = new int[N][N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0; 

        for(int r=0; r<N; r++){
            for(int c=0; c<=N-3; c++){
                // System.out.println(r + " " + c); 
                answer = Math.max(answer ,map[r][c] + map[r][c+1] + map[r][c+2]);
            }
        }

        System.out.println(answer); 
    }
}