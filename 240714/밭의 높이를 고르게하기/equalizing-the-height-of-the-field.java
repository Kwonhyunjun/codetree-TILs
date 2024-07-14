import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.MAX_VALUE;
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken()); // H 높이
        int T = Integer.parseInt(st.nextToken()); // 최소 T번 이상

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<= N-T; i++){
            int cost = 0;
            for(int j=0; j<T; j++){
                cost += Math.abs(arr[i+j]- H); 
            }
            answer = Math.min(answer, cost); 
        }

        System.out.println(answer); 
    }
}