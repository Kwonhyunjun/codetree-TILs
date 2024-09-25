import java.io.*;
import java.util.*; 

public class Main {

    static int N, arr[], maxCount;
    static boolean[] check;  

    static HashMap<Integer, List<Integer>> map; 

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        check = new boolean[N];
        arr = new int[N];

        map = new HashMap<>(); 
        maxCount = Integer.MIN_VALUE; 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            arr[i] = num; 

            if(map.containsKey(num)){
                map.get(num).add(i); 
            }else{
                map.put(num, new ArrayList<>()); 
                map.get(num).add(i); 
            }
        }

        Arrays.fill(check, true);

        int answer = 0; 

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Arrays.fill(check, true); 
            
            int key = entry.getKey(); 
            
            // 제외시키기
            for(int idx : entry.getValue()){
                check[idx] = false; 
            }

            // System.out.println(key + " " + Arrays.toString(check));
            // System.out.println(key); 

            int cur = count(); 
            
            if(cur > maxCount){
                answer = cur;
                maxCount = cur; 
            }

        }

        System.out.println(answer); 
    }

    public static int count(){
        int res = 0; 
        int prev = -1;
        int cnt = 0; 

        for(int i=0; i<N; i++){
            if(!check[i]) continue;


            if(prev == arr[i]){
                cnt++; 
            }else{
                res = Math.max(res, cnt); 
                prev = arr[i];
                cnt = 1; 
            }

            // if(i > 90)
            //     System.out.println(i + " " + prev + " " + cnt); 

        }

        res = Math.max(res, cnt); // 중요!

        // System.out.println(prev + " " + res); 
        

        return res; 
    }
}