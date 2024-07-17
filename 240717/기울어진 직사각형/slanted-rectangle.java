import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0; 

        for(int sr=2; sr<N; sr++){
            for(int sc=1; sc<N-1; sc++){
                // System.out.printf("시작지점 %d, %d\n", sr, sc); 
                for(int a=1; a<N ; a++){
                    for(int b=1; b<N; b++){
                        if((sr-a-b) < 0 || (sc+a) >= N || (sc-b) < 0) continue; 
                        // System.out.printf("직사각형 가능 가로: %d, 세로: %d\n", a, b);
                        int temp = map[sr][sc]; 
                        // System.out.println(temp);
                        int curR = sr;
                        int curC = sc; 
                        for(int i=1; i<=a; i++){
                            temp += map[--curR][++curC];
                            // System.out.println(i + " " + map[curR][curC]);
                            // System.out.printf("1번 가로 %d, %d => %d\n", curR, curC, map[curR][curC]); 
                        }
                        // System.out.println(temp);
                        for(int i=1; i<=b; i++){
                            // System.out.println(i + " " + map[curR][curC]);
                            temp += map[--curR][--curC];
                            // System.out.printf("2번 세로 %d, %d => %d\n", curR, curC, map[curR][curC]); 
                        }
                        // System.out.println(temp);
                        for(int i=1; i<=a; i++){
                            // System.out.println(i + " " + map[curR][curC]);
                            temp += map[++curR][--curC]; 
                            // System.out.printf("3번 가로 %d, %d => %d\n", curR, curC, map[curR][curC]); 
                        }
                        // System.out.println(temp);
                        for(int i=1; i<b; i++){
                            // System.out.println(i + " " + map[curR][curC]);
                            temp += map[++curR][++curC]; 
                            // System.out.printf("4번 가로 %d, %d => %d\n", curR, curC, map[curR][curC]); 
                        }
                        // System.out.println(temp);
                        answer = Math.max(answer, temp); 
                    }
                }
            }
        }

        System.out.println(answer); 
    }
}