import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Long, Integer> map = new HashMap<>();
        long count = 0;

        for(int i=0; i<N; i++){
            if(map.containsKey(K-arr[i])){
                count += map.get(K - arr[i]); 
            }
            map.put((long) arr[i], map.getOrDefault((long) arr[i], 0)+1); 
        }

        System.out.println(count);
    }
}