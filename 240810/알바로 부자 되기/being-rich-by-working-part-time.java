import java.io.*;
import java.util.*; 

class Job implements Comparable<Job>{
    int start, end, pay;

    public Job(int start, int end, int pay){
        this.start = start;
        this.end = end; 
        this.pay = pay;
    }

    @Override
    public int compareTo(Job o1){
        if(this.end == o1.end){
            return this.start - o1.start;
        }

        return this.end - o1.end; 
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        ArrayList<Job> list = new ArrayList<>(); 
        int[] dp = new int[N+1]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            list.add(new Job(start, end, pay));            
        }

        list.add(new Job(0, 0, 0));

        Collections.sort(list); 
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; 

        for(int i=1; i<N+1; i++){
            Job cur = list.get(i); 

            for(int j=0; j<i; j++){
                Job prev = list.get(j); 

                if(prev.end < cur.start){
                    dp[i] = Math.max(dp[i], dp[j] + cur.pay);
                }
            }
        }

        // System.out.println(Arrays.toString(dp)); 

        int answer = 0; 
        for(int i=0; i<N+1; i++){
            answer = Math.max(answer, dp[i]); 
        }

        System.out.println(answer); 
    }
}