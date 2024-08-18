import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()); 

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N]; 
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken()); 
        }

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                map.put(arr[i] + arr[j], map.getOrDefault(arr[i] + arr[j], 0)+1); 
            }
        }

        System.out.println(map.get(K));
    }
}