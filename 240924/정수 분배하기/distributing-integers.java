import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, arr[], min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N]; 
        min = Integer.MAX_VALUE; 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            min = Math.min(min, num); 
            arr[i] = num;
        }

        int left = 1;
        int right = min; 
        int answer = Integer.MIN_VALUE; 

        while(left <= right){
            
            int mid = (left + right) / 2; 
            // System.out.println(mid); 

            if(isPossible(mid)){ // 더 키워도 됨
                answer = Math.max(answer, mid); 
                left = mid + 1; 
            }else{
                right = mid - 1; 
            }

        }

        System.out.println(answer); 
        
    }

    static public boolean isPossible(int divide){
        int res = 0; 

        for(int n : arr){
            res += (n / divide); 
        }

        return res >= 11; 
    }
}