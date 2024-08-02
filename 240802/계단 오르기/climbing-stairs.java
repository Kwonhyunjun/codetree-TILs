import java.io.*;
import java.util.*;

public class Main {
    
    static int N, memo[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); 
        memo = new int[N+1]; 

        Arrays.fill(memo, -1); 

        System.out.println(fibbo(N));

    }

    public static int fibbo(int n){
        if(n <= 0){
            return (n == 0)? 1 : 0; 
        }

        if(memo[n] != -1) return memo[n]; 

        int res = (fibbo(n-2) + fibbo(n-3)) % 10007; 
        memo[n] = res; 
        return res;  
    }
}