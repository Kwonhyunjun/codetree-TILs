import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        int[] dist = new int[N-1]; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());

            // dist[i-1] = Math.abs(points[i-1][0] - points[i][0]) + Math.abs(points[i-1][0] - points[i][0]); 
        }

        int total = 0;

        for(int i=0; i<N-1; i++){
            dist[i] = Math.abs(points[i+1][0] - points[i][0]) + Math.abs(points[i+1][1] - points[i][1]); 
            total += dist[i];
        }

        int answer = Integer.MAX_VALUE;

        int temp = 0;
        for(int i=1; i<N-1; i++){
            temp = total; 
            temp -= dist[i-1]; 
            temp -= dist[i]; 
            temp += Math.abs(points[i+1][0] - points[i-1][0]) + Math.abs(points[i+1][1] - points[i-1][1]); 

            answer = Math.min(answer, temp);
        }

        System.out.println(answer); 
        
        
        
    }
}