import java.io.*; 
import java.util.*;

public class Main {

    static int K, N; 
    static ArrayList<Integer> list = new ArrayList<>(); 
    static StringBuilder sb = new StringBuilder(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        K = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        solve(0); 

        System.out.println(sb); 
    }

    public static void solve(int cnt){
        // 종료조건
        if(cnt == N){
            for(int elem : list){
                sb.append(elem).append(" "); 
            }
            sb.append("\n");
            return; 
        }

        for(int i=1; i<=K; i++){
            list.add(i); 
            solve(cnt+1);
            list.remove(list.size()-1);
        }
    }
}