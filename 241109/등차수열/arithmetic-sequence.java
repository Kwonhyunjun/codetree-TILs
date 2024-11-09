import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st ; 

        int N = Integer.parseInt(br.readLine()); 
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int min = 0; 
        int max = 101; 

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
            min = Math.min(min, arr[i]); 
            max = Math.max(max, arr[i]); 
        }

        Arrays.sort(arr);

        int cnt = 0; 
        for(int i=min+1; i<max; i++){
            int temp = 0; 
            for(int j=0; j<N; j++){
                for(int k=j+1; k<N; k++){
                    if(Math.abs(arr[j]- i) == Math.abs(arr[k]-i)){
                   	// System.out.printf("%d %d %d\n", arr[j], i, arr[k]);
                        temp++; 
                    }
                }
            }
            cnt = Math.max(cnt, temp);
        }

        System.out.println(cnt);
        
    }
}