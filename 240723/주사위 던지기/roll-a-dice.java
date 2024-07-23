import java.io.*;
import java.util.*; 

public class Main { 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] map = new int[N][N];

        map[r][c] = 6;
        int[] dice = new int[]{6, 1, 4, 3, 2, 5}; 
        int[] dr = {-1, 1, 0, 0}; 
        int[] dc = {0, 0, -1, 1}; 

        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<M; i++){
            char direction = st.nextToken().charAt(0); 
            int d = (direction == 'U')? 0 : (direction == 'D')? 1 : (direction == 'L')? 2 : 3; 

            int nr = r + dr[d];
            int nc = c + dc[d]; 
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            
            dice = rotate(dice, d);
            map[nr][nc] = dice[0];

            // for(int j=0; j<N; j++){
            //     System.out.println(Arrays.toString(map[j])); 
            // }
            // System.out.println(); 
            r = nr;
            c = nc;
        }

        int answer = 0; 
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer += map[i][j];
            }
        }

        System.out.println(answer); 


    }
    
    static int[] rotate(int[] dice, int direction){
        int[] temp = new int[6];

        switch(direction){
            case 0 :
                temp[0] = dice[5];
                temp[1] = dice[4]; 
                temp[2] = dice[2];
                temp[3] = dice[3]; 
                temp[4] = dice[0]; 
                temp[5] = dice[1]; 
                break;
            case 1 :
                temp[0] = dice[4];
                temp[1] = dice[5]; 
                temp[2] = dice[2];
                temp[3] = dice[3]; 
                temp[4] = dice[1]; 
                temp[5] = dice[0]; 
                break;
            case 3 :
                temp[0] = dice[3];
                temp[1] = dice[2]; 
                temp[2] = dice[0];
                temp[3] = dice[1]; 
                temp[4] = dice[4]; 
                temp[5] = dice[5]; 
                break;
            case 2 :
                temp[0] = dice[2];
                temp[1] = dice[3]; 
                temp[2] = dice[1];
                temp[3] = dice[0]; 
                temp[4] = dice[4]; 
                temp[5] = dice[5]; 
                break;
        }

        return temp; 
    }
}