import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 

        System.out.println(solve(N));

    }

    public static int solve(int N){
        int res = 0;

        for(int i=1; i<=N; i++){
            res += i;
        }

        res /= 10;

        return res; 
    }
}