import java.io.*; 
import java.util.*;

public class Main {
    static int R, C, ans; 
    static String[][] map; 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        
        st = new StringTokenizer(br.readLine()); 
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()); 
        	for(int j=0; j<C; j++) {
        		map[i][j] = st.nextToken();
        	}
        }
        
        
        int tmp = map[0][0].equals("W") ? 0 : 1; 
        jump(0, 0, 0, 0); 
        System.out.println(ans);
    }

    // 0 : 백 / 1 : 흰
    static void jump(int curR, int curC, int type, int cnt){
        // System.out.println("curR : " + curR + " " + "curC : " + curC);
        // System.out.println("R : " + R + " " + "C : " + C);
        if(curR == R-1 && curC == C-1){
            // System.out.println("curR : " + curR + " " + "curC : " + curC);
            if(cnt == 3) ans++;
            return; 
        }
        
        for(int i=curR+1; i<R; i++){
            for(int j=curC+1; j<C; j++){
                if(type == 0 && map[i][j].equals("W")) continue;
                if(type == 1 && map[i][j].equals("B")) continue; 
                // System.out.println("nxtR : " + i + " " + "nxtC : " + j);
                int temp = (map[i][j].equals("W"))? 0 : 1;
                jump(i, j, temp, cnt+1);
            }
        }

    }

}