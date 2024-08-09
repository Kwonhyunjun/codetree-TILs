import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st ; 

        int N = Integer.parseInt(br.readLine()); 
        ArrayList<Integer> up = new ArrayList<>(); 
        ArrayList<Integer> down = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            up.add(num);
            down.add(num);
        }

        StringBuilder sb = new StringBuilder();

        Collections.sort(up);
        Collections.sort(down, Collections.reverseOrder());
        

        for(int i=0; i<N; i++){
            sb.append(up.get(i)).append(" ");
        }

        sb.append("\n"); 

        for(int i=0; i<N; i++){
            sb.append(down.get(i)).append(" ");
        }

        System.out.println(sb); 
    }
}