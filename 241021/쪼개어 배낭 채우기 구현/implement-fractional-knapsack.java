import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main {

    static class Data{
        int weight, value; 
        double perWeight; 

        public Data(int weight, int value, double perWeight){
            this.weight = weight; 
            this.value = value; 
            this.perWeight = perWeight; 
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석
        int M = Integer.parseInt(st.nextToken()); // 가방의 크기

        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> -Double.compare(o1.perWeight, o2.perWeight));

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            double perWeight = (double) value / weight; 

            // System.out.printf("cur : %d %d\n", weight, value);
            // System.out.println(perWeight);

            pq.offer(new Data(weight, value, perWeight)); 
        }     

        double total = 0; 

        while(M > 0 && !pq.isEmpty()){
            // 가방에 공간이 있고 담을 보석이 있다면
            Data cur = pq.poll();

            int weight = cur.weight;
            int value = cur.value;

            // System.out.printf("cur : %d %d\n", weight, value);

            if(weight <= M){
                total += value;
                M -= weight; 
            }else{
                total += cur.perWeight * M; 
                break;
            }
        }

        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(total));
    }
}