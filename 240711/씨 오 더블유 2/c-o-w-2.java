import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine(); 
        int answer = 0;

        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    if(str.charAt(i) == 'C' && str.charAt(j) == 'O' && str.charAt(k) == 'W' ){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer); 
    }
}