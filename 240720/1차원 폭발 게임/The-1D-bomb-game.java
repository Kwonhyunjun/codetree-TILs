import java.io.*;
import java.util.*; 

public class Main {

    static int N, lastIdx, arr[]; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N]; 
        
       
        for(int i=N-1; i>=0; i--){
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        lastIdx = N;
        while(true){
            // System.out.printf("전 : %s  / lastIdx = %d \n", Arrays.toString(arr), lastIdx); 
            boolean flag = false; 
            int num = arr[0];
            int cnt = 1;
            for(int i=1;i<lastIdx;i++){
                if(num == arr[i]){
                    cnt++; 
                }else{
                    if(cnt >= M){
                        for(int j=1; j<=cnt; j++){
                            arr[i-j] = 0; 
                        }
                        flag = true; 
                    }

                    num = arr[i]; 
                    cnt = 1; 
                }
            }

            if(cnt >= M){
                for(int j=1; j<=cnt; j++){
                    arr[lastIdx-j] = 0; 
                }
                flag = true; 
            } 

            // System.out.printf("후 : %s  / lastIdx = %d \n", Arrays.toString(arr), lastIdx); 

            if(!flag) break; 
            move();
        }

        // System.out.printf("최종 : %s  / lastIdx = %d \n", Arrays.toString(arr), lastIdx); 
        StringBuilder sb = new StringBuilder(); 

        sb.append(lastIdx).append("\n"); 
        for(int i=0; i<lastIdx; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void move(){
        int[] temp = new int[N];
        
        int idx = 0;

        for(int i=0; i<lastIdx; i++){
            if(arr[i] != 0){
                temp[idx++] = arr[i]; 
            }
        }

        lastIdx = idx; 
        arr = temp; 
    }
}

// 3 
// 2(3) cnt = 3 
// 1(2)
// 1(1)
// 1(0)