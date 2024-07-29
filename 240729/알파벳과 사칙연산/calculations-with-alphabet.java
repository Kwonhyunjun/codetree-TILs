import java.io.*;
import java.util.*; 

public class Main {

    static int ASCII_CODE = 128; 
    
    static int[] mapper = new int[ASCII_CODE];

    static int answer;
    static char[] arr; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        arr = br.readLine().toCharArray(); 

        solve(97); 
        System.out.println(answer); // 'a' - > 97 'f' -> 102
 
    }

    static void solve(int cnt){
        if(cnt > 102){
            answer = Math.max(answer, calculate());
            return; 
        }

        for(int i=1; i<5; i++){
            mapper[cnt] = i;
            solve(cnt+1); 
        }
    }

    static int calculate(){
        int res = mapper[arr[0]]; 
        char oper = arr[1]; 

        for(int i = 2; i<arr.length; i++){
            if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*'){
                oper = arr[i]; 
            }else{
                int num = mapper[arr[i]]; 
                switch(oper){
                    case '+' :
                         res += num;
                        break; 
                    case '-' : 
                        res -= num;
                        break; 
                    case '*' : 
                        res *= num; 
                        break; 
                }
            }
        }
        return res; 
    }
}