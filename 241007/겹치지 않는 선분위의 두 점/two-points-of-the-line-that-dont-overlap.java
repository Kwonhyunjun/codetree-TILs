import java.io.*;
import java.util.*; 

public class Main {

    static int N, M; 
    static Data[] lines; 
    static HashSet<Long> set; 

    static class Data implements Comparable<Data>{
        long start, end; 

        public Data(long start, long end){
            this.start = start; 
            this.end = end; 
        }

        @Override
        public int compareTo(Data o1){
            if(this.start > o1.start) return 1; 
            if(this.start < o1.start) return -1; 

            if(end > o1.end) return 1; 
            return -1; 
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 점의 개수
        M = Integer.parseInt(st.nextToken()); // 선분 개수

        lines = new Data[M]; 
        set = new HashSet<>(); 

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            lines[i] = new Data(start, end);
            
            for(long j=start; j<=end; j++){
                set.add(j);
            }
        }

        Arrays.sort(lines, 0, M); 
        long answer = Long.MIN_VALUE; 

        long left = 1L; 
        long right = lines[M-1].end; 

        while(left <= right){
            long mid = left + (right - left) / 2;

            if(isPossible(mid)){
                left = mid + 1; 
                answer = Math.max(answer, mid); 
            }else{
                right = mid - 1; 
            }
        }

        System.out.println(answer); 
    }

    public static boolean isPossible(long dist){
        int cnt = 0; 
        long lastX = (long) -1e18;

        for(int i=0; i<M; i++){
            long a = lines[i].start; 
            long b = lines[i].end; 

            while(lastX + dist <= b){
                cnt++; 
                lastX = Math.max(a, lastX + dist); 
            }

            if(cnt >= N){
                break; 
            }
        }

        return cnt >= N; 
    }

}