import java.io.*;
import java.util.*; 

public class Main {

    static int N, M, arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        arr = new int[M];

        // comb(0, 0); 
        comb2(1, 0); 
        
        System.out.println(sb); 
    }

    static void comb(int idx, int start){
        if(idx == M){
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return; 
        }

        for(int i=start+1; i<=N; i++){
            arr[idx] = i;
            comb(idx+1, i); 
        }
    }

    /*
        curNum : 현재 고려하고 있는 숫자
        cnt : 이때까지 넣은 숫자 개수
    */
    static ArrayList<Integer> list = new ArrayList<>(); 
    static void comb2(int curNum, int cnt){

        if(curNum == N+1){
            if(list.size() == M){
                for(int i=0; i<M; i++){
                    sb.append(list.get(i)).append(" ");
                }
                sb.append("\n");
            }
            return; 
        }

        // 현재 고려하고 있는 숫자 추가 
        list.add(curNum);
        comb2(curNum+1, cnt+1);
        list.remove(list.size()-1); 

        // 추가 X
        comb2(curNum+1, cnt); 

    }
}