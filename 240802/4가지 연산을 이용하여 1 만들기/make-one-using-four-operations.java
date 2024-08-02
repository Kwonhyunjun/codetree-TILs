import java.io.*;
import java.util.*; 

public class Main {

    static int N, answer;
    // static boolean[] v = new boolean[1000001]; 
    static HashSet<Integer> v = new HashSet<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        N = Integer.parseInt(br.readLine()); 

        bfs(N);

        System.out.println(answer); 
    }

    public static void bfs(int n){
        Queue<int[]> q = new ArrayDeque<>(); 

        // v[n] = true; 
        v.add(n); 
        q.offer(new int[]{n, 0}); 

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == 1){
                answer = cur[1];  
                return; 
            }

            int[] res = calc(cur[0]); 

            for(int i=0; i<4; i++){
                if(res[i] == Integer.MIN_VALUE) continue;
                // if(v[res[i]]) continue; 
                if(v.contains(res[i])) continue; 

                // v[res[i]] = true; 
                v.add(res[i]); 
                q.offer(new int[]{res[i], cur[1]+1}); 
            }
        }
    }

    public static int[] calc(int n){
        int[] res = new int[4]; 
        
        res[0] = n-1;
        res[1] = n+1; 
        res[2] = (n%2 == 0) ? n/2 : Integer.MIN_VALUE;
        res[3] = (n%3 == 0) ? n/3 : Integer.MIN_VALUE;
        
        return res; 
    }
    
}