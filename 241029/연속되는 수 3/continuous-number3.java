import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 

        int answer = 0; 

        int cnt = 0; 
        int prev = 0; 
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(i==0 || (num < 0 && prev == -1) || (num > 0 && prev == 1)){
                cnt++; 
            }else{
                cnt = 1; 
            }

            prev = (num < 0) ? -1 : 1; 
            answer = Math.max(answer, cnt); 
            // System.out.printf("i(%d) => cnt(%d)\n", i, cnt); 
        }

        answer = Math.max(answer, cnt); 

        System.out.println(answer); 
    }
}