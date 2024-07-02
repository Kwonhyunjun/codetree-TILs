import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push" :
                    q.add(Integer.parseInt(st.nextToken()));
                break;
                case "pop" :
                    sb.append(q.poll()).append("\n");
                break;
                case "size" :
                    sb.append(q.size()).append("\n");
                break;
                case "empty" :
                    int n = (q.isEmpty()) ? 1 : 0;
                    sb.append(n).append("\n");
                break;
                case "front" :
                    sb.append(q.peek()).append("\n");
                break;
            }
        }

        System.out.printf("%s", sb);
    }
}