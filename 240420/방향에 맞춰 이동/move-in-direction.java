import java.io.*; 
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st; 

        int n = Integer.parseInt(br.readLine());

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};  // 북 서 남 동

        int nr = 0, nc = 0; 
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()); 

            int d = -1; 
            switch(st.nextToken()){
                case "E": 
                    d = 3; 
                    break; 
                case "W": 
                    d = 1; 
                    break;
                case "S": 
                    d = 2; 
                    break;
                case "N": 
                    d = 0; 
                    break;
            }

            int tmp = Integer.parseInt(st.nextToken()); 

            nr += (dr[d] * tmp); 
            nc += (dc[d] * tmp); 

            // System.out.println(nc + " " + nr); 

        }

        System.out.println(nc + " " + nr); 
    }
}