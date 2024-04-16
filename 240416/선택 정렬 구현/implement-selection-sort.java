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

        for(int i=0; i<N-1; i++){
            int min = i; 

            for(int j= i+1; j<N; j++){
                if(arr[j] < arr[min]){
                    min = j; 
                }
            }

            int tmp = arr[min]; 
            arr[min] = arr[i]; 
            arr[i] = tmp;  
        }

        for(int n : arr){
            sb.append(n).append(" "); 
        }

        System.out.println(sb);
    }
}