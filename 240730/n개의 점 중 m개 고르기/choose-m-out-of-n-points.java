import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, answer, points[][]; 

    static ArrayList<int[]> list = new ArrayList<>(); 


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        points = new int[N][2];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i][0] = x; 
            points[i][1] = y; 
        }

        answer = Integer.MAX_VALUE; 
        combi(0, 0); 
        System.out.println(answer);
    }

    public static void combi(int idx, int start){
        if(idx == M){
            answer = Math.min(answer, calc()); 
            return; 
        }

        for(int i=start; i<N; i++){
            list.add(points[i]);
            combi(idx+1, i+1); 
            list.remove(list.size()-1); 
        }
    }

    public static int calc(){
        int res = -1; 

        for(int i=0; i<M; i++){
            for(int j=i+1; j<M; j++){
                res = Math.max(res, getDist(list.get(i), list.get(j))); 
            }
        }
        return res;
    }

    public static int getDist(int[] p1, int[] p2){
        // System.out.println((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        // return (int) Math.sqrt((double) (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
    
}