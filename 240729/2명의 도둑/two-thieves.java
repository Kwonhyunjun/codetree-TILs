import java.io.*;
import java.util.*;

public class Main {

    static int N, M, C, map[][], values[][], maxValue, answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); // 격자의 크기
        M = Integer.parseInt(st.nextToken()); // 도둑이 선택할 수 있는 영역
        C = Integer.parseInt(st.nextToken()); // 도둑이 들고갈 수 있는 최대 무게

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        values = new int[N][N-M+1];

        for(int r=0; r<N; r++){
            for(int c=0; c<=N-M; c++){
                maxValue = 0;
                choose(r, c, 0, 0, 0);
                values[r][c] = maxValue; 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(values[i])); 
        // }

        for(int r=0; r<N; r++){
            for(int c=0; c<N-M+1; c++){
                int value1 = values[r][c]; 

                for(int l = r; l<N; l++){
                    for(int k = 0; k<N-M+1; k++){
                        if(r == l && k < c+M) continue;
                        int value2 = values[l][k];

                        answer = Math.max(answer, value1 + value2); 
                    }
                }
            }
        }
        System.out.println(answer); 
    }

    /*
        해당 영역에서 가질 수 있는 최대 가치를 반환하는 함수

        sr, sc : 시작 위치 
        cnt : 고려하는 물건의 순서
        values : 담은 무게
        total : 담은 무게에 해당하는 총 가치
    */
    static void choose(int sr, int sc, int cnt, int values, int total){
        if(cnt == M){
            if(values <= C){
                maxValue = Math.max(maxValue, total); 
            }
            return; 
        }

        int curValue = map[sr][sc+cnt];

        // 해당 물건을 담는다. 
        choose(sr, sc, cnt+1, (values + curValue), (total + (curValue * curValue))); 

        // 담지 않는다.
        choose(sr, sc, cnt+1, values, total); 

    }
}