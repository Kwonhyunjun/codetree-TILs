import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(br.readLine());

        solve(N);
    }
    
    public static void solve(int n){
        int num = 1; 
        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                System.out.print(num++ + " ");
                if(num >= 10) num = 1; 
            }
            System.out.println();
        }
    }
}