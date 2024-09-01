import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); // 점 개수
        int M = Integer.parseInt(st.nextToken()); // 작업 개수

        PriorityQueue<Data> pq = new PriorityQueue<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Data(x, y));
        }

        for(int i=0; i<M; i++){
            Data cur = pq.poll();

            cur.x += 2; 
            cur.y += 2; 

            pq.add(cur); 
        }

        System.out.printf("%d %d", pq.peek().x, pq.peek().y); 

    }
}

class Data implements Comparable<Data>{
    int x, y; 

    public Data(int x, int y){
        this.x = x; 
        this.y = y; 
    }

    @Override
    public int compareTo(Data o1){
        int n1 = Math.abs(this.x) + Math.abs(this.y); 
        int n2 = Math.abs(o1.x) + Math.abs(o1.y); 

        if(n1 == n2){
            if(this.x == o1.x){
                return this.y - o1.y; 
            }
            return this.x - o1.x; 
        }

        return n1 - n2; 
    }
}