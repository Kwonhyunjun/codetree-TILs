import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        int answer = 0; 
        int cnt = 0; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken()); 

            if(num > K){
                cnt++; 
            }else{
                cnt = 0; 
            }

            answer = Math.max(answer, cnt); 

        }

        System.out.println(answer); 
    }
}