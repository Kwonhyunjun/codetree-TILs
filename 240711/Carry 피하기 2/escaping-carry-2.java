import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        String[] nums = new String[N];
        int[] numbers = new int[N];

        StringBuilder sb; 

        for(int i=0; i<N; i++){    
            String temp = br.readLine();
            numbers[i] = Integer.parseInt(temp); 
            nums[i] = new StringBuilder(temp).reverse().toString();
        }

        int answer = -1;

        for(int i=0; i<N-2; i++){
            for(int j= i+1; j<N-1; j++){
                for(int k= j+1; k<N; k++){
                    String s1 = nums[i];
                    String s2 = nums[j];
                    String s3 = nums[k];

                    int len = Math.max(Math.max(s1.length(), s2.length()), s3.length()); 
                    boolean isCarry = false; 

                    for(int l=0; l<len; l++){
                        int digit1 = (l > s1.length()-1)? 0 : s1.charAt(l) - 48;
                        int digit2 = (l > s2.length()-1)? 0 : s2.charAt(l) - 48;
                        int digit3 = (l > s3.length()-1)? 0 : s3.charAt(l) - 48;

                        if((digit1 + digit2 + digit3) > 9){
                            isCarry = true;
                            break; 
                        }
                    }

                    if(!isCarry){
                        answer = Math.max(answer, (numbers[i] + numbers[j] + numbers[k]));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}