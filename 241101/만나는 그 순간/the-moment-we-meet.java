import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_LENGTH = 2 * 1000 * 1000 + 2; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[MAX_LENGTH];
        
        for(int i=0; i<MAX_LENGTH; i++){
            arr[i] = new ArrayList<>(); 
        }

        int idx = 1000000;  
        int time = 1; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int dir = (st.nextToken().equals("R")) ? 1 : -1; 
            int cnt = Integer.parseInt(st.nextToken()); 

            for(int j=0; j<cnt; j++){
                idx += dir; 
                arr[idx].add(time++); 
            }
        }

        int answer = 0; 
        int idx2 = 1000000; 
        int time2 = 1; 
        boolean flag = false; 

        for(int i=0; i<M; i++){
            if(flag) break; 
            st = new StringTokenizer(br.readLine());

            int dir = (st.nextToken().equals("R")) ? 1 : -1; 
            int cnt = Integer.parseInt(st.nextToken()); 

            for(int j=0; j<cnt; j++){
                idx2 += dir;
                if(arr[idx2].contains(time2++)){
                    answer = time2 - 1; 
                    flag = true; 
                    break; 
                }
            }
        }
        
        System.out.println(answer);
    }
}