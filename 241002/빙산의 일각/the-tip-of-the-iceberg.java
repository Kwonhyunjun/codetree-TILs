import java.io.*; 
import java.util.*;

public class Main {
    static int N;
    static List<Integer> heights, drown;
    static PriorityQueue<Data> icebergs; 

    static class Data{
        int num, height;

        public Data(int num, int height){
            this.num = num;
            this.height = height; 
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        heights = new ArrayList<>(); 
        drown = new ArrayList<>(); 
        icebergs = new PriorityQueue<>(new Comparator<Data>(){
            
            @Override
            public int compare(Data o1, Data o2){
                if(o1.height == o2.height){
                    return o1.num - o2.num;
                }
                return o1.height - o2.height; 
            }
        });

        for(int i=0; i<N; i++){
            int height = Integer.parseInt(br.readLine()); 

            icebergs.offer(new Data(i, height)); 

            if(!heights.contains(height)){
                heights.add(height); 
            }
        }

        Collections.sort(heights);
        int max = Integer.MIN_VALUE; 

        for(int i : heights){
            while (icebergs.peek() != null && icebergs.peek().height == i) {
                Data d = icebergs.poll();
                drown.add(d.num); 
            }

            int cnt = check();
            // System.out.printf("%d => %d\n",i, cnt);
            max = Math.max(max, cnt); 
        }

        System.out.println(max); 
    }

    static public int check(){
        int cnt = 0; 
        
        // 위치 조정
        Collections.sort(drown); 
        // System.out.println(drown);

        int prev = drown.get(0); 

        for(int i=1; i<drown.size(); i++){
            if(Math.abs(prev-drown.get(i)) > 1){
                // System.out.println(prev + " " + drown.get(i));
                cnt++; 
            }
            prev = drown.get(i);
        }

        if(drown.get(0) !=0) cnt++;
        if(drown.get(drown.size()-1) != N-1) cnt++; 

        return cnt; 
    }
}