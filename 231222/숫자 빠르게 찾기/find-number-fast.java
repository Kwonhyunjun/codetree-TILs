import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        StringTokenizer st; 

        st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // Input End 

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(br.readLine());
            int idx = -1;

            int left = 0;   // 시작
            int right = N-1;  // 끝

            while(left <= right){ // 등호를 꼭 넣어야 단 하나의 숫자만 남았을 경우에도 올바르게 찾아짐
                int mid = left + (right - left) / 2; // Overflow 방지

                if(target == arr[mid]){
                    idx = mid + 1; // 인덱스는 1부터 시작!!
                    break; 
                }

                if(target > arr[mid]){ // 찾는 숫자가 클경우 
                    left = mid + 1; 
                }else{
                    right = mid - 1; 
                }
            }

            sb.append(idx +"\n");
        }
        System.out.println(sb);
    }
}