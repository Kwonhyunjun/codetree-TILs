import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); 

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        HashMap<Integer, Integer> map = new HashMap<>();

        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            // arr2[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0)+1); 
        }

        HashMap<Integer, Integer> temp; 
        for(int i=0; i<=N-M; i++){
            temp = new HashMap<>(); 
            
            for(int j=i; j<i+M; j++){
                int num = arr1[j];
                if(map.get(num) == null){
                    break;
                }
                temp.put(num, temp.getOrDefault(num, 0)+1); 
            }

            if(map.size() != temp.size()) continue; 
            boolean isBeautiful = true;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(temp.get(entry.getKey()) != entry.getValue()){
                    isBeautiful = false;
                    break;
                }
            }

            if(isBeautiful) answer++; 
        }
        System.out.println(answer);
    }
}