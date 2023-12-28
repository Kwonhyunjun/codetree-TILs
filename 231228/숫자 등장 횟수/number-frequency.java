import java.util.*; 
import java.io.*; 

public class Main {
    static int N, M; 
    static HashMap<Integer, Integer> m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()); 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new HashMap<>();

        st = new StringTokenizer(br.readLine());  
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(m.containsKey(num)){ // 있다면
                m.put(num, m.get(num)+1);  
            }else{
                m.put(num, 1); 
            }
        }

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            sb.append(m.getOrDefault(target, 0)).append(" "); 
        }

        System.out.println(sb); 
    }
}