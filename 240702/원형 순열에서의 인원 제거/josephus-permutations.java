import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            q.add(i+1); 
        }

        while(q.size() > 1){
            for(int i=0; i<K-1; i++){
                q.add(q.poll());
            }
            sb.append(q.poll()).append(" ");
        }

        sb.append(q.poll());

        System.out.printf("%s", sb);

    }
}