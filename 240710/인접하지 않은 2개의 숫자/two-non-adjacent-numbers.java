import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0; 

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j == i-1 || j == i+1 || j == i) continue; 
                // System.out.println(i +" " +j); 
                answer = Math.max(answer, arr[i]+arr[j]);
            }
        }

        System.out.println(answer); 
    }
}