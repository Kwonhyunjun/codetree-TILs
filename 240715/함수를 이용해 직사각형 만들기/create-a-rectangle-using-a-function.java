import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        solve(N, M);
    }
    
    public static void solve(int n , int m){
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                System.out.print("1");
            }
            System.out.println();
        }
    }
}