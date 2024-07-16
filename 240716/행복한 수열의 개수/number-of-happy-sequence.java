import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 연속해야 하는 숫자

        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int answer = 0;

        for(int i=0; i<N; i++){
            // 행
            boolean rIsHappy = false; 
            int lastR = map[i][0]; 
            int longR = 1;
            for(int j=1; j<N; j++){
                // System.out.printf("j(%d) lastR(%d) longR(%d)\n", j, lastR, longR);
                if(longR >= M){
                    rIsHappy = true;
                    break;
                }

                if(lastR != map[i][j]){
                    longR = 1;
                    lastR = map[i][j];
                }else{
                    longR++; 
                }
            }

            // 열
            boolean cIsHappy = false; 
            int lastC = map[0][i]; 
            int longC = 1;
            for(int j=1; j<N; j++){
                if(longC >= M){
                    cIsHappy = true;
                    break;
                }

                if(lastC != map[j][i]){
                    longC = 1;
                    lastC = map[j][i];
                }else{
                    longC++; 
                }
            }

            if(rIsHappy || longR >= M) {
                // System.out.printf("%d행 행복한 수열\n", i);
                answer++; 
            }
            if(cIsHappy || longC >= M){
                // System.out.printf("%d열 행복한 수열\n", i);
                answer++; 
            } 
        }
        System.out.println(answer); 

    }
}