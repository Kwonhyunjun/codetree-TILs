import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int temp = 0;

            for(int j=i+1; j<N+i; j++){
                if(i==j) continue;
                // System.out.printf("%d -> %d, 차이 %d 인원 %d -> 총 거리 %d \n", i, j, Math.abs(i-j) , arr[j], Math.abs(i-j) * arr[j] );
                // System.out.printf("%d -> %d\n", i+1, j+1);
                temp += Math.abs(i-j) * arr[j%N]; 
            }  

            answer = Math.min(temp, answer);
        }

        System.out.println(answer); 
    }
}