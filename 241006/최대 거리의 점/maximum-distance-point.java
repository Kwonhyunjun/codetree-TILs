import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, points[]; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 점의 개수
        M = Integer.parseInt(st.nextToken()); // 물건의 개수

        points = new int[N]; 

        for(int i=0; i<N; i++){
            points[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(points); 

        int left = 1; 
        int right = points[N-1]; 
        int answer = Integer.MIN_VALUE;

        while(left <= right){
            int mid = left + (right - left) / 2; 
            // System.out.printf("%d~%d => %d\n", left, right, mid);

            if(check(mid)){
                left = mid + 1; 
                answer = Math.max(answer, mid); 
            }else{
                right = mid - 1; 
            }

        }

        System.out.println(answer);
    }


    static boolean check(int mid){
        int cnt = 1;
        int start = points[0];

        for(int i=1; i<N; i++){
            int dist = Math.abs(start - points[i]);

            if(dist >= mid){
                cnt++; 
                start = points[i]; 
            }
        }

        return cnt >= M; 
    }



   
}