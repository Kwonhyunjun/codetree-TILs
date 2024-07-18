import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken()); 

        int[] upLeft = new int[N];
        int[] upRight = new int[N];
        int[] down = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            upLeft[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            upRight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            down[i] = Integer.parseInt(st.nextToken());
        }

        while(t > 0){
            int temp = upLeft[N-1];
            for(int i=N-1; i>0; i--){
                upLeft[i] = upLeft[i-1]; 
            }

            int temp2 = upRight[N-1];
            for(int i=N-1; i>0; i--){
                upRight[i] = upRight[i-1]; 
            }
            upRight[0] = temp; 

            int temp3 = down[N-1];
            for(int i=N-1; i>0; i--){
                down[i] = down[i-1]; 
            }
            down[0] = temp2; 
            upLeft[0] = temp3; 

            t--; 
        }

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<N; i++){
            sb.append(upLeft[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0; i<N; i++){
            sb.append(upRight[i]).append(" ");
        }
        sb.append("\n");

        for(int i=0; i<N; i++){
            sb.append(down[i]).append(" ");
        }

        System.out.println(sb);

    }
}