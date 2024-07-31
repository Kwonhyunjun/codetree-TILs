import java.io.*;
import java.util.*;

public class Main {

    static int N, answer, map[][];
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 
        answer = -1; 

        map = new int[N][N]; 
        v = new boolean[N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        solve(0);

        System.out.println(answer);
    }

    static boolean[] v; 

    public static void solve(int row){
        if(row == N){
            answer = Math.max(answer, calc()); 
            return; 
        }

        for(int c=0; c<N; c++){
            if(v[c]) continue; 

            list.add(c); 
            v[c] = true; 

            solve(row+1);

            v[c] = false;
            list.remove(list.size()-1); 
        }   
    }

    public static int calc(){
        int res = 0;
        for(int i=0; i<N; i++){
            res += map[i][list.get(i)]; 
        }
        return res; 
    }
}