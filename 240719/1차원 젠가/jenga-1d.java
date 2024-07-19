import java.io.*;
import java.util.*; 

public class Main {

    static int N, arr[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        arr = new int[N]; 

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        }
        int totalCnt = N; 

        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            for(int j=start; j<=end; j++){
                arr[j] = 0;
            }
            // System.out.println(Arrays.toString(arr));
            totalCnt -= (end - start +1);  
            move(); 
            
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(totalCnt).append("\n"); 
        for(int i=0; i<totalCnt; i++){
            sb.append(arr[i]).append("\n");
        }
        
        System.out.println(sb); 
    }

    static void move(){
        int[] temp = new int[N];
        int idx = 0; 

        for(int i=0; i<N; i++){
            if(arr[i] != 0){
                temp[idx++] = arr[i];  
            }
        }
        // System.out.println(Arrays.toString(temp));
        arr = temp;
    }
}