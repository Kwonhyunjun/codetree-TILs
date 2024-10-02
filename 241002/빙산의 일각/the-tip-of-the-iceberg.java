import java.io.*;
import java.util.*; 

public class Main {

    static int N, arr[], low, high; 
    static List<Integer> list; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; 
        int answer = 0; 

        low = Integer.MAX_VALUE;
        high = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.min(low, arr[i]); 
            high = Math.max(high, arr[i]); 
        }

        for(int i=low; i<high; i++){
            list = new ArrayList<>(); 
            for(int j=0; j<N; j++){
                if(arr[j] - i <= 0 ){
                    if(j==0 || j == N-1) continue; 
                    list.add(j); 
                }
            }

            if(list.isEmpty()) continue;

            int cnt = 2; 
            int prev = list.get(0); 
            for(int j=1; j<list.size(); j++){
                if(Math.abs(prev-list.get(j)) > 1){
                    cnt++; 
                }
                prev = list.get(j); 
            }
            // System.out.printf("해수면(%d) -> %d\n", i, cnt); 
            answer = Math.max(answer, cnt); 
        }

        System.out.println(answer); 
        
    }
}