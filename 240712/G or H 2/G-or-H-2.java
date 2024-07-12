import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int answer = 0;
        int N = Integer.parseInt(br.readLine()); 

        char[] arr = new char[101]; 
        int min = 101;
        int max = -1; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            int n = Integer.parseInt(st.nextToken());
            arr[n] = st.nextToken().charAt(0); 
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
    
        for(int i=min; i<max+1; i++){
            int cntG = 0;
            int cntH = 0;
            for(int j=min+1; j<= max-i; j++){
                if(arr[i+j] == 'G'){
                    cntG++;
                }else if(arr[i+j] == 'H'){
                    cntH++; 
                }

                // System.out.printf("%d~%d H : %d, G : %d\n", i, i+j, cntH, cntG);
                if(cntG == cntH || cntG == (j-i+1) || cntH == (j-i+1)){
                    if((arr[i] == 'G' || arr[i] == 'H') && (arr[i+j] == 'G' || arr[i+j] == 'H')){
                        // System.out.printf("%d~%d H : %d, G : %d\n", i+1, i+j+1, cntH, cntG);
                        answer = Math.max(answer, j);
                    } 
                }
            }
        }
        System.out.println(answer);
    }
}