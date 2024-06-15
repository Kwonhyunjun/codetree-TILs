import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        int subMax = Integer.MIN_VALUE; 

        int section = (arr[0] > 0) ? arr[0] : 0; 

        for(int i=1; i<n; i++){
            section += arr[i]; 
            
            if(section < 0){
                section = 0; 
                continue;
            }

            subMax = Math.max(subMax, section);
        }

        System.out.println(subMax); 

    }
}