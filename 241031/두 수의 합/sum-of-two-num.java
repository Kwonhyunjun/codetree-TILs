import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 

        HashMap<Integer, int[]> map = new HashMap<>(); 

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken()); 

            map.putIfAbsent(num, new int[2]); 

            map.get(num)[1]++; 
        }

        int answer = 0;
        
        for(Map.Entry<Integer, int[]> entry : map.entrySet()){
            int key = entry.getKey();
            int[] value = entry.getValue(); 

            if(value[0] == -1) continue; 

            if(map.containsKey(K-key)){
                answer += (map.get(K-key)[1] * value[1]);
                map.get(K-key)[0] = -1;
                value[0] = -1; 
            }
        }
        
        System.out.println(answer); 
    }
}