import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        System.out.println(solve(n1, n2, n3)); 

    }

    public static int solve(int n1, int n2, int n3){
        int res = 0 ;

        res = Math.min(n1, Math.min(n2, n3)); 
        
        return res; 
    }
}