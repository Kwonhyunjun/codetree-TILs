import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return -(o1[0]-o2[0]);
                }
                return -(o1[1] - o2[1]); 
            }
        });

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken()); 

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue(); 

            pq.offer(new int[]{key, value}); 
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++){
            sb.append(pq.poll()[0]).append(" ");
        }

        System.out.println(sb);
    }
}