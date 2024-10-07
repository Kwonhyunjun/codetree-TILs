import java.io.*;
import java.util.*; 

public class Main {

    static int N, M; 
    static Data[] lines; 
    static HashSet<Long> set; 

    static class Data{
        long start, end; 

        public Data(long start, long end){
            this.start = start; 
            this.end = end; 
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

        long answer = Long.MIN_VALUE; 

        long left = 1L; 
        long right = lines[M-1].end; 

        while(left <= right){
            long mid = left + (right - left) / 2; 
            // System.out.printf("%d %d -> %d\n", left, right, mid);

            if(isPossible(mid)){
                // System.out.println("통과");
                left = mid + 1; 
                answer = Math.max(answer, mid); 
            }else{
                // System.out.println("통과X");
                right = mid - 1; 
            }
        }

        System.out.println(answer); 
    }

    // static boolean isPossible(long mid){
    //     long cnt = 1; 
    //     long prev = lines[0].start; 

    //     for(int i=0; i<M; i++){
    //         long next = prev + mid; 
    //         // System.out.printf("i(%d) cnt(%d), prev(%d)+mid(%d) => %d \n", i, cnt, prev, mid, next); 

    //         if(next <= lines[i].start){
    //             // System.out.println("!!");
    //             prev = lines[i].start;
    //             cnt++; 
    //         }
            
    //         if(isBetween(lines[i], next)){
    //             // System.out.println("포함");
    //             while(true){
    //                 if(prev + mid > lines[i].end) break; 
    //                 prev += mid;
    //                 cnt++;  
    //             }
    //         }
            
    //     }

    //     // System.out.printf("cnt : %d\n", cnt); 

    //     return cnt >= N; 
    // }


    // static boolean isBetween(Data line, long num){
    //     return num >= line.start && num <= line.end; 
    // }

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