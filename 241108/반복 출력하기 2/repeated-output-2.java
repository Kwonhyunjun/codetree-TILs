mport java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
        solve(n);
    }

    static void solve(int N){
        if(N == 0){
            return; 
        }
        System.out.println("Hello World"); 
        solve(N-1);
    }
}