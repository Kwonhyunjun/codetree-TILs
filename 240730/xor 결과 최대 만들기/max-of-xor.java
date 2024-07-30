import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, answer, arr[];
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        arr = new int[N]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }

        comb(0, -1); 

        System.out.println(answer); 
    }

    static void comb(int idx, int start){
        if(idx == M){
            // System.out.println(list); 
            answer = Math.max(answer, calc()); 
            return; 
        }

        for(int i=start+1; i<N; i++){
            list.add(i);
            comb(idx+1, i);
            list.remove(list.size()-1); 
        }
    }
    
    static int calc(){
        int res = arr[list.get(0)]; 

        for(int i=1; i<M; i++){
            res ^= arr[list.get(i)];
        }
        
        return res; 
    }
}