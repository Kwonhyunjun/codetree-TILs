import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        HashMap<Integer, Integer> map = new HashMap<>(); 

        st = new StringTokenizer(br.readLine()); 
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        // Input End

        int answer = 0;

        for(int i=0; i<N; i++){
            int num = arr[i];
            int k = K - num;

            int pair = 0; 
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int key = entry.getKey();
                int value = entry.getValue(); 

                if(key == (k-key)){
                    pair += value * (value-1);
                }
                else if(map.containsKey(k-key)){
                    pair += (map.get(k-key) * value);
                }
            }

            answer += (pair/2);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        System.out.println(answer);
    }
}