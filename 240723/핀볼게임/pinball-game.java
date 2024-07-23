import java.io.*;
import java.util.*; 

public class Main {

    static int answer, N, map[][]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine()); 

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        answer = -1; 

        for(int i=0; i<N; i++){
            // 위(아래쪽 방향)
            answer = Math.max(answer, solve(0, i, 1));
            // 왼쪽(오른쪽 방향)
            answer = Math.max(answer, solve(i, 0, 3));
            // 오른쪽(왼쪽 방향)
            answer = Math.max(answer, solve(i, N-1, 2)); 
            // 아래쪽
            answer = Math.max(answer,  solve(N-1, i, 0)); 
        }

        System.out.println(answer); 

    }

    static int solve(int r, int c, int d){
        int cnt = 1; 
        int nr = r; 
        int nc = c; 
        // String dir = (d == 0) ? "상" : (d ==1)? "하" : (d==2)? "좌" : "우"; 
        // System.out.printf("시작 : %d %d 방향 : %s 카운트 : %d\n", r, c, dir, cnt);
        while(true){
            nr += dr[d];
            nc += dc[d]; 
            cnt++;
            if(!isRange(nr, nc)){
                break; 
            } 
            if(map[nr][nc] == 1){
                d = turn(1, d); 
                // System.out.println("1번"); 
            }else if(map[nr][nc] == 2){
                d = turn(2, d); 
                // System.out.println("2번");
            }
            // System.out.printf("%d %d 방향 : %s 카운트 : %d\n", nr, nc, dir, cnt);
        }

        return cnt; 
    }

    static int[] dr = {-1, 1, 0, 0};  // 상 하 좌 우 
    static int[] dc = {0, 0, -1, 1};
    static int turn(int type, int d){
        int res = 0; 
        if(type == 1){
            switch(d){
                case 0 :
                    res = 3; 
                    break;
                case 1 :
                    res = 2;
                    break;
                case 2 :
                    res = 1; 
                    break;
                case 3 :
                    res = 0;
                    break; 
            }
        }else{
            switch(d){
                case 0 :
                    res = 2; 
                    break;
                case 1 :
                    res = 3;
                    break;
                case 2 :
                    res = 0; 
                    break;
                case 3 :
                    res = 1;
                    break; 
            }
        }

        return res; 
    }

    static boolean isRange(int r, int c){
        if(r < 0 || c < 0 || r >= N || c >= N){
            return false;
        }
        return true; 
    }
}

/*

구슬이 한 칸 움직이는 데는 1초의 시간이 소요
격자안으로 들어가는 시간과 격자밖으로 나오는 시간까지 포함하여 계산 

return 시작점을 적절하게 선택하여 격자 밖으로 나오는데 까지 걸리는 시간이 최대가 되도록 하는 프로그램 작성
*/