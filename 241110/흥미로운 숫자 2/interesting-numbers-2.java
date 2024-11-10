import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int answer = 0;

        for(int i=start; i<=end; i++){
            if(check(i)) answer++; 
        }

        System.out.println(answer);
    }

    static boolean check(int num){
        ArrayList<Integer> idx = new ArrayList<>(); 
        int[] arr = new int[10];

        while(num > 0){
            int digit = num % 10; 

            if(arr[digit] == 0) idx.add(digit); 
            arr[digit]++; 
            
            num /= 10; 
        }

        if(idx.size() != 2) return false; 

        for(int i : idx){
            if(arr[i] == 1) return true; 
        }
        
        return false; 
    }
}