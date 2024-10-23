import java.io.*;
import java.util.*; 

public class Main {
    static class Data{
        int idx1, idx2, hap; 

        public Data(int idx1, int idx2, int hap){
            this.idx1 = idx1;
            this.idx2 = idx2; 
            this.hap = hap; 
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o1.hap - o2.hap);

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0; i<N; i++){
            pq.add(new Data(i, 0, arr1[i]+arr2[0]));
            
        }

        Data cur = null; 
        while(K > 0){
            cur = pq.poll(); 

            // System.out.println(cur.idx1 + " " + cur.idx2 + " " + cur.hap);
            
            if(cur.idx2+1 >= M) continue;

            pq.offer(new Data(cur.idx1, cur.idx2+1, arr1[cur.idx1]+arr2[cur.idx2+1])); 
            K--;     
        }

        System.out.println(cur.hap);
    }
}