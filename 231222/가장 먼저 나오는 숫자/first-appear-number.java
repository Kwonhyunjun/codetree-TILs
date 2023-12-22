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

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
     
            int left = 0; 
            int right = N-1; 
            int minIdx = N;

            while(left <= right){
                int mid = left + (right - left) / 2; 

                if(arr[mid] >= target){ 
                    right = mid - 1; 
                    minIdx = Math.min(minIdx, mid); 
                }else{
                    left = mid + 1; 
                }
            }
            int ans = arr[minIdx] == target ? minIdx+1 : -1; 
            sb.append(ans).append("\n"); 
        }
        System.out.println(sb);
    }
}