import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int[] arr = new int[10]; 

        for(int i=0; i<10; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        System.out.println(arr[2] + arr[4] + arr[9]); 
    }
}