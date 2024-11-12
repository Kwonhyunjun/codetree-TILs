import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], answer; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        map = new int[4][N]; 

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine()); 

            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        solve(0, 0);

        System.out.println(answer);
    }

    static void solve(int idx, int hap){
        if(idx == 4){
            if(hap == 0) answer++; 
            return; 
        }

        for(int i=0; i<N; i++){
            solve(idx+1, hap + map[idx][i]);
        }
    }
}