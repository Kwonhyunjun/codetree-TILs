import java.io.*;
import java.util.*;

public class Main {

    static int N, map[][], answer; 
    static boolean[] v;
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; 
        v = new boolean[N]; 
        answer = Integer.MIN_VALUE; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        solve(0);

        System.out.println(answer); 
    }

    public static void solve(int row){
        if(row == N){
            // System.out.println(list);
            // System.out.println(getMinValue());
            answer = Math.max(answer, getMinValue()); 
            return; 
        }

        for(int i=0; i<N; i++){
            if(v[i]) continue; 

            v[i] = true; 
            list.add(i);

            solve(row+1);

            v[i] = false;
            list.remove(list.size()-1); 
        }
    }

    public static int getMinValue(){
        int res = Integer.MAX_VALUE;

        for(int i=0; i<list.size(); i++){
            res = Math.min(res, map[i][list.get(i)]); 
        }

        return res; 
    }
}