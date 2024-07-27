import java.io.*;
import java.util.*;

public class Main {

    static int N, answer, lines[][];
    static ArrayList<int[]> list = new ArrayList<>(); 


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        N = Integer.parseInt(br.readLine());

        lines = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            lines[i][0] = Integer.parseInt(st.nextToken()); 
            lines[i][1] = Integer.parseInt(st.nextToken()); 
        }

        solve(0); 

        System.out.println(answer);
    }

    static void solve(int cnt){
        if(cnt >= N){
            answer = Math.max(list.size(), answer); 
            return; 
        }

        // 추가
        if(!isOver(cnt)){
            list.add(new int[]{lines[cnt][0], lines[cnt][1]});
            solve(cnt+1); 
            list.remove(list.size()-1); 
        }

        // 추가 안함
        solve(cnt+1);
    }

    static boolean isOver(int cnt){
        int start = lines[cnt][0];
        int end = lines[cnt][0];
        
        for(int i=0; i<list.size(); i++){
            if(!check(start, end, list.get(i)[0], list.get(i)[1]))
                return true; 
        }

        return false; 
    }

    static boolean check(int x1, int x2, int y1, int y2){
        if((x2 < y1) || (y2 < x1)){ // 겹치지 않으면
            return true;
        }

        return false;
    }
}