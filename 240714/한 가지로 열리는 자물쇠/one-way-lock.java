import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        int answer =0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr= new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            sb.append(i);
            for(int j=1; j<=N; j++){
                sb.append(j);
                for(int k=1; k<=N; k++){
                    sb.append(k);
                    // System.out.println(sb);
                    boolean flag = false; 
                    for(int l=0; l<3; l++){
                        int lock = arr[l]; 
                        int digit = sb.charAt(l) - 48; 
                        // System.out.printf("%d %d\n", lock, digit);

                        if(Math.abs(lock - digit) <= 2){
                            flag = true; 
                        }
                        // System.out.println(flag);
                        if(flag){
                            answer++;
                            break;
                        }
                    }
                    sb.setLength(sb.length()-1);
                }
                sb.setLength(sb.length()-1);
            }
            sb.setLength(sb.length()-1);
        }

        System.out.println(answer);
    }
}