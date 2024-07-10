import java.util.*; 
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        int answer = Integer.MAX_VALUE;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        
        for(int i=0; i<N; i++){ // 집 선택
            int temp = 0;
            for(int j=0; j<N; j++){
                if(i == j) continue; 
                int dist = Math.abs(j-i);
                temp += dist * arr[j]; 
            }
            answer = Math.min(temp, answer); 
        }

        System.out.println(answer);
    }
}