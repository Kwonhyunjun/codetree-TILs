import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int T = Integer.parseInt(st.nextToken()); 

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        while(T > 0){
            int temp1 = arr1[N-1]; 
            int temp2 = arr2[N-1]; 
            for(int i=N-1; i>0; i--){
                arr1[i] = arr1[i-1]; 
            }
            arr1[0] = temp2;

            for(int i=N-1; i>0; i--){
                arr2[i] = arr2[i-1];
            }
            arr2[0] = temp1; 

            // System.out.println(T);
            // System.out.println(Arrays.toString(arr1));
            // System.out.println(Arrays.toString(arr2));

            T--; 
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++){
            sb.append(arr1[i]).append(" "); 
        }
        sb.append("\n"); 
        for(int i=0; i<N; i++){
            sb.append(arr2[i]).append(" "); 
        }

        System.out.println(sb); 

    }
}