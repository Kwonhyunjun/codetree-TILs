import java.io.*; 
import java.util.*; 

public class Main {
    
    static int N, total, ans, target, arr[];
    static boolean[] v; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        total = 0;
        ans = Integer.MAX_VALUE;  

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        v = new boolean[N]; 

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            total += num;
            arr[i] = num; 
            
        }

        solve(0, 0, 0); 
        System.out.println(ans); 
    }

    // static void solve(int num, int sum, int cnt){
    //     if(cnt > 2) return;

    //     if(num == N-1){
    //         if(cnt == 2)
    //             ans = Math.min(ans, Math.abs( target - (total - sum) )); 
    //         return; 
    //     }

    //     System.out.println(num +" "+ sum +" "+ cnt); 
    //     solve(num+1, sum+arr[num], cnt+1);

    //     solve(num, sum, cnt); 
    // }

    static void combi(int cnt, int start, int sum){
        if(cnt == 2){
            ans = Math.min(ans, Math.abs( target - (total - sum) ));
            return; 
        }

        for(int i=start; i<N; i++){
            combi(cnt+1, i+1, sum+arr[i]);  
        }
    }
}