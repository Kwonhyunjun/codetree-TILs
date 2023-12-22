import java.io.*;
import java.util.*;

public class Main {
    static int N, M, hole[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        hole = new int[N];
        for(int i=0; i<N; i++){
            hole[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hole);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            
            long cnt = upperBound(n2) - lowerBound(n1);  
            System.out.println(cnt);           
        }
    }

    static int upperBound(int target){
        int left = 0; 
        int right = N-1; 
        int minIdx = N; 

        while(left <= right){
            int mid = left + (right - left)/2;

            if(hole[mid] > target){
                right = mid - 1; 
                minIdx = Math.min(minIdx, mid); 
            }else{
                left = mid + 1; 
            }
        }
        return minIdx; 
    }

    static int lowerBound(int target){
        int left = 0; 
        int right = N-1; 
        int minIdx = N; 

        while(left <= right){
            int mid = left + (right - left)/2;

            if(hole[mid] >= target){
                right = mid - 1; 
                minIdx = Math.min(minIdx, mid); 
            }else{
                left = mid + 1; 
            }
        }
        return minIdx; 
    }
}