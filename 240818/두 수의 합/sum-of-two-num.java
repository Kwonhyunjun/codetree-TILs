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

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                map.put((long) arr[i] + (long) arr[j], map.getOrDefault((long) arr[i] + (long) arr[j], 0)+1); 
            }
        }

        System.out.println(map.get(K));
    }
}