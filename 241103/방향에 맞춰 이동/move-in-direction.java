import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); 

        int[] pos = new int[]{0, 0}; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 

            char d = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken()) ;
            int dir = (d == 'N') ? 0 : (d == 'E') ? 1 : (d == 'S') ? 2 : 3; 

            for(int j=0; j<n; j++){
                pos[0] += dr[dir];
                pos[1] += dc[dir];
            }
        }

        System.out.println(pos[0] + " " + pos[1]); 

    }
}