import java.io.*;
import java.util.*;

public class Main {
    static class Data{
        int num, arrive, duration; 

        public Data(int num, int arrive, int duration){
            this.num = num;
            this.arrive = arrive; 
            this.duration = duration; 
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Data> pq1 = new PriorityQueue<>(new Comparator<Data>(){
            @Override
            public int compare(Data o1, Data o2){
                return o1.arrive - o2.arrive; 
            }
        });

        PriorityQueue<Data> pq2 = new PriorityQueue<>(new Comparator<Data>(){
            @Override
            public int compare(Data o1, Data o2){
                return o1.num - o2.num; 
            }
        });

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            pq1.offer(new Data(i, arrive, duration));
        }

        int answer = 0;

        int t = pq1.peek().arrive; 
        while(!pq1.isEmpty() || !pq2.isEmpty()){ // 다 관람할 때까지 반복
            while(!pq1.isEmpty() && pq1.peek().arrive <= t){
                pq2.offer(pq1.poll()); 
            }

            Data cur = pq2.poll();
            if(cur == null){
                cur = pq1.poll(); 
                t = cur.arrive; 
            }
            answer = Math.max(answer, Math.abs(cur.arrive - t)); 
            // System.out.printf("%d번 입장(기다린 시간 %d) -> 나온시간 %d\n", cur.num,  Math.abs(cur.arrive - t), t+cur.duration);
            t += cur.duration; 

        }

        System.out.println(answer); 
    }
}