import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); 
        int[] work = new int[3];
        for(int i=0; i<3; i++){
            work[i] = Integer.parseInt(st.nextToken()); 
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] temp = new int[N][2]; 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            min = Math.min(min, start);
            max = Math.max(max, end); 

            temp[i][0] = start;
            temp[i][1] = end; 
        }


        int answer = Integer.MIN_VALUE;
        for(int i = min; i<=max; i++){
            int cur =0;
            for(int j=0; j<N; j++){
                if(i < temp[j][0]){
                    cur += work[0]; 
                }else if(i > temp[j][1]){
                    cur += work[2];
                }else{
                    cur+= work[1];
                }
            }

            answer = Math.max(cur, answer);
        }

        System.out.println(answer);


    }
}