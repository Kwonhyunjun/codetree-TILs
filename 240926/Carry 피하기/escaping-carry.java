import java.io.*;
import java.util.*; 

public class Main {

    static int N, answer, arr[]; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            arr[i] = num;     
        }

        // System.out.println(isCarry(171, 355)); 
        solve(0, 0 ,0);

        System.out.println(answer); 
    }

    public static void solve(int idx, int cnt, int hap){
        if(idx == N){
            answer = Math.max(answer, cnt); 
            return; 
        }

        if(!isCarry(hap, arr[idx])){
            solve(idx+1, cnt+1, hap + arr[idx]); 
        }

        solve(idx+1, cnt, hap); 
    }

    public static boolean isCarry(int num1, int num2){
        
        while(num1 > 0 && num2 > 0){
            int digit1 = num1 % 10; 
            int digit2 = num2 % 10; 

            if(digit1 + digit2 >= 10){
                return true; 
            }
            
            num1 /= 10;
            num2 /= 10;
        }

        return false; 
    }
    
}