import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int total = 0; 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            total += arr[i]; 
        }

        boolean[] dp = new boolean[total+1];
        dp[0] = true;

        // for(int i=0; i<=total; i++){
        //     if(!dp[i]) continue;
        //     for(int j=0; j<N; j++){
        //         if(i + arr[j] >= total+1) continue;
                
        //         dp[i + arr[j]] = true;
        //     }
        // }

        ArrayList<Integer> list; 
        for(int i=0; i<N; i++){
            int num = arr[i]; 
            list = new ArrayList<>(); 
            for(int j=num; j<=total; j++){
                if(dp[j-num] && !dp[j]){
                    list.add(j); 
                }
            }

            for(int idx : list){
                dp[idx] = true; 
            }

        }

        // System.out.println(Arrays.toString(dp)); 

        int answer = Integer.MAX_VALUE; 

        for(int i=1; i<=total; i++){
            if(!dp[i]) continue; 

            answer = Math.min(answer, Math.abs(i - (total-i))); 
        }

        System.out.println(answer); 
        
    }
}