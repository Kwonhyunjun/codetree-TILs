import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[N+1];

        int answer = -1; 

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine()); 

            arr[num]++; 

            if(arr[num] >= K){
                answer = num; 
                break; 
            }
        }

        System.out.println(answer);
    }
}