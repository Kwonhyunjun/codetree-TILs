import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            set1.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder(); 

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(set1.contains(num)){
                sb.append(1).append(" "); 
            }else{
                sb.append(0).append(" "); 
            }
        }

        System.out.println(sb); 
    }
}