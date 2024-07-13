import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solve(N); 

        
    }
    static void solve(int n){
        for(int i=0; i<n; i++){
            System.out.println("12345^&*()_"); 
        }
    }
}