import java.io.*;
import java.util.*; 

/*
    1이상 4이하의 숫자로만 이루어져 있음, 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자
*/

public class Main {

    static int N, answer;
    static ArrayList<Integer> list = new ArrayList<>();  
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 

        N = sc.nextInt(); 

        makeNum(0); 

        System.out.println(answer); 
    }

    static void makeNum(int cnt){
        if(cnt == N){
            if(isBeautiful()){
                // System.out.println(list); 
                answer++; 
            }
            return; 
        }

        for(int i=1; i<5; i++){
            list.add(i); 
            makeNum(cnt+1);
            list.remove(list.size() -1); 
        }
    }

    static boolean isBeautiful(){
        boolean res = true;

        int num = list.get(0);
        int cnt = 1; 
        
        for(int i=1; i<list.size(); i++){
            if(num == list.get(i)){
                cnt++; 
            }else{
                if(cnt % num != 0) return false; 
                num = list.get(i); 
                cnt = 1; 
            }
        }

        if(cnt % num != 0) res = false; 

        return res; 
    }
}