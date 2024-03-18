import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        StringBuilder sb = new StringBuilder(); 

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=0; j<N; j++){
                if(i == j) continue;
                temp += (Math.abs(i-j) * arr[j]);
            }
            ans = Math.min(ans, temp); 
        }

        System.out.println(ans);

    }
}