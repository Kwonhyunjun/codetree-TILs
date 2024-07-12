import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                float sum = 0;
                for(int k=i; k<j+1; k++){
                    sum += arr[k];
                }

                float average = sum / (float)(j-i+1); 

                for(int k=i; k<j+1; k++){
                    if((float)arr[k] == average){
                        // System.out.printf("%d~%d sum(%f) average(%f)\n", i+1, j+1, sum, average); 
                        answer++;
                        break; 
                    }
                }
            }
        }

        System.out.println(answer);
    }
}