import java.util.*; 
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        HashMap<String, String> map1 = new HashMap<>(); 
        HashMap<String, String> map2 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        for(int i=0; i<N; i++){
            String str = br.readLine(); 
            map1.put(str, i+1+""); 
            map2.put(i+1+"", str); 
        }

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<M; i++){
            String str = br.readLine(); 
            if(map1.get(str) == null){
                sb.append(map2.get(str)).append("\n");
                continue; 
            } 

            sb.append(map1.get(str)).append("\n");
        }

        System.out.println(sb); 
    }
}