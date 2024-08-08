import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N]; 

        ArrayList<Line> lines = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lines.add(new Line(s, e)); 
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(lines.get(i));
        // }

        Collections.sort(lines);
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 1; 

        for(int i=1; i<N; i++){ 
            Line l1 = lines.get(i); 
            for(int j=0; j<i; j++){
                Line l2 = lines.get(j); 
                if(l2.end < l1.start){
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                } 
            }
        }

        // System.out.println(Arrays.toString(dp)); 

        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(answer, dp[i]); 
        }

        System.out.println(answer);

    }
}

class Line implements Comparable<Line>{
    int start, end; 

    public Line(int start, int end){
        this.start = start;
        this.end = end; 
    }

    @Override
    public int compareTo(Line o1){
        if(this.end == o1.end){
            return this.start - o1.start; 
        }

        return this.end - o1.end; 
    }

    @Override
    public String toString(){
        return "[start : " + this.start + " end : " + this.end + "]";
    }
}