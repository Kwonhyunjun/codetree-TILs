/*
    길이가 n인 수열 - 4, 5, 6 으로만 구성
    임의의 길이를 갖는 두개의 인접한 연속 부분 수열이 동일할 경우, 이를 불가능한 수열로 간주
*/

import java.io.*;
import java.util.*; 

public class Main {

    static int N, arr[], answer; 
    static boolean flag = false; 
    static ArrayList<Integer> list = new ArrayList<>(); 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        N = Integer.parseInt(br.readLine()); 
        arr = new int[N]; 

        solve(0, 0); 
        System.out.println(answer); 
    }

    static void solve(int cnt, int prev){
        if(flag) return; 

        if(cnt == N){
            if(check()){
                flag = true;
                StringBuilder sb = new StringBuilder(); 

                for(int i=0; i<arr.length; i++){
                    sb.append(arr[i]);
                }
                // System.out.println(Arrays.toString(arr)); 
                answer = Integer.parseInt(sb.toString());
                
            }
            return; 
        }

        for(int i=4; i<7; i++){
            if(prev == i) continue;
            arr[cnt] = i; 
            solve(cnt+1, i); 
        }
    }

    static boolean check(){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int s=0; s<N-1; s++){ // 시작위치 
            // System.out.printf("s : %d\n", s); 
            for(int l=0; l<(N-s)/2; l++){
                // System.out.printf("l : %d\n", l);

                for(int j = s; j <= s+l; j++){
                    sb1.append(arr[j]);
                    sb2.append(arr[j+l+1]);
                }

                // System.out.println(sb1 + " " + sb2); 
                
                if(sb1.toString().equals(sb2.toString())) {
                    // System.out.println("중복");
                   return false;
                }
                sb1.setLength(0);
                sb2.setLength(0);
            }
        }

        return true;
    }
}