import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        arr = new int[M];

        comb(0, 0); 

        System.out.println(sb); 
    }

    static void comb(int idx, int start){
        if(idx == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return; 
        }

        for(int i=start+1; i<=N; i++){
            arr[idx] = i;
            comb(idx+1, i); 
        }
    }
}