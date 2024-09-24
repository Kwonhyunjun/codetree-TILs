import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, arr[], max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N]; 
        max = Integer.MIN_VALUE; 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            max = Math.max(max, num); 
            arr[i] = num;
        }

        int left = 1;
        int right = max; 
        int answer = Integer.MIN_VALUE; 

        // System.out.printf("%d %d\n", left, right);

        while(left <= right){
            
            int mid = (left + right) / 2; 

            if(isPossible(mid)){ // 더 키워도 됨
                answer = Math.max(answer, mid); 
                left = mid + 1; 
            }else{
                right = mid - 1; 
            }

        }

        answer = (answer == Integer.MIN_VALUE) ? 0 : answer ;
        System.out.println(answer); 
        
    }

    static public boolean isPossible(int divide){
        int res = 0; 

        for(int n : arr){
            res += (n / divide); 
        }

        // System.out.printf("%d -> %d\n", divide, res); 

        return res >= M; 
    }
}