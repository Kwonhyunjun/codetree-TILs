import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine());

        int answer = 0; 
        int cnt = 0; 
        int prev = -1;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(i == 0 || prev != num){
                answer = Math.max(answer, cnt);
                cnt = 0;
                prev = num; 
            }
            cnt++; 
        }

        answer = Math.max(answer, cnt);

        System.out.println(answer);
    }
}