import java.io.*;
import java.util.*; 

public class Main {

    static int N, M; 
    static int[][] map; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine()); 

            int r = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0); 
            blow(r-1, direction, 0); 
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(map[i][j]).append(" "); 
            }
            sb.append("\n"); 
        }

        System.out.println(sb); 
    }

    static void blow(int r, char direction, int step){
        // System.out.println(r); 
        // System.out.println("이동전: "+Arrays.toString(map[r])); 
        // 이동
        if(direction == 'L'){
            int temp = map[r][M-1]; 
            for(int i=M-1; i>0; i--){
                map[r][i] = map[r][i-1]; 
            }
            map[r][0] = temp; 
        }else{
            int temp = map[r][0];
            for(int i=0; i<M-1; i++){
                map[r][i] = map[r][i+1];
            }
            map[r][M-1] = temp; 
        }
        // System.out.println("이동후: "+Arrays.toString(map[r]));

        char d = (direction == 'L')? 'R' : 'L'; 
        // 전파
        if(r-1 >=0 && step != 2){
            if(spread(r, r-1)) blow(r-1, d, 1);
        }
        // 전파
        if(r+1 < N && step != 1){
            if(spread(r, r+1)) blow(r+1, d, 2);
        }

    }

    static boolean spread(int cur, int nr){
        for(int i=0; i<M; i++){
            if(map[cur][i] == map[nr][i]) return true; 
        }
        return false; 
    }
}