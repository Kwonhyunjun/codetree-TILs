import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[N];
        boolean[] dp = new boolean[M+1]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        dp[0] = true; 

        ArrayList<Integer> list;

        for(int i=0; i<N; i++){
            int num = arr[i]; 
            list = new ArrayList<>(); 

            for(int j=num; j<=M; j++){
                if(dp[j-num]) list.add(j); 
            }

            for(int j=0; j<list.size(); j++){
                dp[list.get(j)] = true;
            }

            // System.out.println(Arrays.toString(dp)); 
        }

        

        String answer = (dp[M])? "Yes" : "No"; 
        System.out.println(answer);
    }
}