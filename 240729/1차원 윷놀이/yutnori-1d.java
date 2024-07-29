import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K, answer,moves[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 턴 수
        M = Integer.parseInt(st.nextToken()); // 1차원 윷놀이판 크기
        K = Integer.parseInt(st.nextToken()); // 말 개수

        st = new StringTokenizer(br.readLine());
        moves = new int[N];
        for(int i=0; i<N; i++){
            moves[i] = Integer.parseInt(st.nextToken()); 
        }

        int[] players = new int[K];
        Arrays.fill(players, 1);

        play(0, players);
        System.out.println(answer); 
    }

    static void play(int cnt, int[] curPos){
        if(cnt == N){
            // System.out.println(Arrays.toString(curPos)); 
            int score = 0; 
            for(int i=0; i<K; i++){
                if(curPos[i] >= M) score++;
            }
            answer = Math.max(answer, score); 
            return; 
        }

        // System.out.println(cnt + " " + Arrays.toString(curPos));
        for(int i=0; i<K; i++){

            curPos[i] += moves[cnt]; 
            play(cnt+1, curPos); 
            curPos[i] -= moves[cnt]; 
        }
    }
}