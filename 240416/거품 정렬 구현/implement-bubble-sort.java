import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; 

        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }


        boolean sorted = true;

        do{
            sorted = true;

            for(int i=0; i<N-1; i++){
                if(arr[i] > arr[i+1]){
                    int tmp = arr[i+1]; 
                    arr[i+1] = arr[i]; 
                    arr[i] = tmp;  
                    sorted = false; 
                }
            }

        }while(sorted == false);

        for(int num : arr){
            sb.append(num).append(" "); 
        }

        System.out.println(sb); 
        
    }
}