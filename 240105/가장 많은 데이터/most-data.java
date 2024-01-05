import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        int N = Integer.parseInt(br.readLine()); 

        HashMap<String, Integer> map = new HashMap<>(); 

        for(int i=0; i<N; i++){
            String str = br.readLine(); 
            map.put(str, map.getOrDefault(str, 0)+1);     
        }

        int max = Integer.MIN_VALUE; 
        String s = ""; 
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            // if(max < entry.getValue()){
            //     System.out.println(entry.getValue() + " " + entry.getKey());
            //     s = entry.getKey(); 
            // }
            max = Math.max(max, entry.getValue()); 
        }

        System.out.println(max); 
    }
}