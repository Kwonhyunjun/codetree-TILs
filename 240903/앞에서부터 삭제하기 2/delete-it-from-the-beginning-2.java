import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.order - o2.order);
        PriorityQueue<Data> copy;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(new Data(i, Integer.parseInt(st.nextToken()))); 
        }

        float answer = 0f; 

        for(int i=1; i<=N-2; i++){
            int remove = pq.poll().num;
            // System.out.printf("%d 삭제\n", remove); 

            copy = new PriorityQueue<>((o1, o2) -> o1.num - o2.num);
            copy.addAll(pq); 
            copy.poll(); 

            float sum = 0f; 
            for(Data data : copy){
                sum += data.num;
            }

            // System.out.printf("%f 나누기 %d = %f\n", sum, pq.size()-1, (sum / (pq.size()-1)));
            answer = Math.max(answer, (sum / (pq.size()-1)));

        }

        System.out.printf("%.2f", answer);


    }
}

class Data{
    int order, num;

    public Data(int order, int num){
        this.order = order;
        this.num = num; 
    }
}


// public class Main {
//     public static void main(String[] args) throws Exception{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine()); 

//         int N = Integer.parseInt(st.nextToken());
//         PriorityQueue<Integer> pq = new PriorityQueue<>(); 

//         st = new StringTokenizer(br.readLine());
//         for(int i=0; i<N; i++){
//             pq.offer(Integer.parseInt(st.nextToken())); 
//         }

//         float answer = 0f; 

//         int k = 1;
//         while(k <= N-2){
//             System.out.println(k); 
//             // 삭제
//             int remove = pq.poll(); 
//             // System.out.printf("삭제 : %d\n", remove);

//             float sum = 0f; 
//             for(int n : pq){
//                 sum += (float) n; 
//             }

//             sum -= pq.peek(); 
            
//             // System.out.printf("%f 나누기 %d = %f\n", sum, pq.size()-1, (sum / (pq.size()-1)));
//             answer = Math.max(answer , (sum / (pq.size()-1)));

//             k++; 
//         }

//         System.out.printf("%.2f", answer);

        
//     }
// }