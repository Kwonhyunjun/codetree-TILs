import java.io.*;
import java.util.*;

public class Main {

    static int N, answer, costs[][]; 
    static boolean[] v;
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); 
        costs = new int[N][N]; 
        answer = Integer.MAX_VALUE; 
        v = new boolean[N]; 

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine()); 
            for(int c=0; c<N; c++){
                costs[r][c] = Integer.parseInt(st.nextToken()); 
            }
        }

        solve(0); 

        System.out.println(answer);
    }

    public static void solve(int idx){
        if(idx == N-1){
            // System.out.println(list); 
            answer = Math.min(answer, getTotalCost()); 
            return; 
        }

        for(int i=1; i<N; i++){
            if(v[i]) continue; 

            v[i] = true; 
            list.add(i);

            solve(idx+1); 

            v[i] = false; 
            list.remove(list.size()-1); 
        }   
    }

    public static int getTotalCost(){
        int res = 0;
        int curPos = 0; 

        for(int i=0; i<list.size(); i++){
            int next = list.get(i); 

            // System.out.println(costs[curPos][next]);
            res += costs[curPos][next]; 
            curPos = next; 
        }
        res += costs[curPos][0];

        // System.out.println("res : " + res); 
        return res;
    }
}