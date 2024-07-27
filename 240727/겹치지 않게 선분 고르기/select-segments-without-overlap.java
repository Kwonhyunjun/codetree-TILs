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
            // for(int[] line : list){
            //     System.out.print(Arrays.toString(line) + " "); 
            // }
            // System.out.println(); 
            return; 
        }

        // System.out.println("cnt :" + cnt);
        // for(int[] line : list){
        //     System.out.print(Arrays.toString(line) + " "); 
        // }
        // System.out.println();

        // 추가
        if(!isOver(cnt)){
            // System.out.println(cnt +" : "+ Arrays.toString(lines[cnt]) + " 추가");
            list.add(new int[]{lines[cnt][0], lines[cnt][1]});
            solve(cnt+1); 
            list.remove(list.size()-1); 
        }

        // 추가 안함
        // System.out.println(cnt + " 생략");
        solve(cnt+1);
    }

    static boolean isOver(int cnt){
        int start1 = lines[cnt][0];
        int end1 = lines[cnt][1];
        
        for(int i=0; i<list.size(); i++){
            int start2 = list.get(i)[0];
            int end2 = list.get(i)[1];

            // System.out.printf("[%d, %d], [%d, %d]\n", start1, end1, start2, end2); 
            if(!((end1 < start2) || (end2 < start1))){
                // System.out.println("겹친다");
                return true;
            } 
        }
        // System.out.println("겹치지 않는다"); 
        return false; 
    }
}