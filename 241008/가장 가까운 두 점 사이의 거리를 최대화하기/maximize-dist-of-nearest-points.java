import java.io.*;
import java.util.*; 

public class Main {

    static int N;
    static Data[] lines; 

    static class Data implements Comparable<Data>{
        int start, end; 

        public Data(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Data o1){
            if(this.start == o1.start){
                return this.end - o1.end;
            }
            return this.start - o1.start; 
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());

        lines = new Data[N]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()); 

            lines[i] = new Data(start, end); 
        }

        Arrays.sort(lines); 

        int answer = Integer.MIN_VALUE; 

        int left = 1; 
        int right = lines[N-1].end - lines[0].start;

        // System.out.printf("left(%d) ~ right(%d)\n", left, right);

        while(left <= right){
            int mid = left + (right - left) /2; 

            if(isPossible(mid)){
                left = mid + 1; 
                answer = Math.max(answer, mid); 
            }else{
                right = mid - 1; 
            }
        }

        System.out.println(answer); 
    }

    static boolean isPossible(int mid){
        int prev = lines[0].start; 

        for(int i=1; i<N; i++){
            int next = prev + mid; 

            if(next > lines[i].end) return false; 

            while(next < lines[i].start) next++; 

            prev = next; 
        }

        return true; 
    }
}