import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int answer =0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        int[] num = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            num[0] = i;  
            for(int j=1; j<=N; j++){
                num[1] = j; 
                for(int k=1; k<=N; k++){
                    num[2] = k; 
                    boolean flag = false;
                    // System.out.println(Arrays.toString(num));
                    for(int l=0; l<3; l++){
                        if(Math.abs(arr[l] - num[l]) <= 2){
                            flag = true; 
                        }

                        if(flag){
                            answer++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}