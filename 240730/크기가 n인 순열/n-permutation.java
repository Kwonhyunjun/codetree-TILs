import java.io.*;
import java.util.*;

public class Main {

    static int N, arr[]; 
    static boolean[] v; 
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        
        arr = new int[N+1]; 
        v = new boolean[N+1];

        perm(0); 

        System.out.println(sb); 
    }

    public static void perm(int idx){
        if(idx == N){
            for(int i=0; i<N; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n"); 
            return; 
        }

        for(int i=1; i<=N; i++){
            if(v[i]) continue; 

            arr[idx] = i; 
            v[i] = true; 

            perm(idx+1);

            v[i] =false; 
        }
    }
}