import java.util.*; 
import java.io.*; 

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

        for(int i=1; i<N; i++){
            int j = i-1; 
            int key = arr[i]; 

            while( j >= 0 &&  arr[j] > key ){
                arr[j+1] = arr[j];
                j--; 
            }

            arr[j+1] = key; 
        }        

        for(int n : arr){
            sb.append(n).append(" "); 
        }

        System.out.println(sb);
    }
}