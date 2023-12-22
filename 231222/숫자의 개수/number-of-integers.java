import java.io.*;
import java.util.*; 

public class Main {
    static int N, M, arr[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 

        st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(br.readLine());

            int diff = upperBound(0, N-1, target) - lowerBound(0, N-1, target); 
            sb.append(diff).append("\n"); 
        }
        System.out.println(sb);
    }

    static int upperBound(int left, int right, int target){
        int minIdx = N;
        while(left <= right){
            int mid = left + (right-left) / 2; 

            if(arr[mid] > target){
                right = mid - 1; 
                minIdx = Math.min(minIdx, mid); 
            }else{
                left = mid + 1; 
            }
        } 
        return minIdx; 
    }

    static int lowerBound(int left, int right, int target){
        int minIdx = N; 
        while(left <= right){
            int mid = left + (right - left) / 2 ; 

            if(arr[mid] >= target){
                right = mid - 1; 
                minIdx = Math.min(minIdx, mid);
            }else{
                left = mid + 1; 
            }
        }
        return minIdx; 
    }
}