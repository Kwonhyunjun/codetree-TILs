import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 

        boolean[] isSelected = new boolean[2*N+1]; 

        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(br.readLine()); 
            isSelected[idx] = true; 
        }

        int answer = 0; 
        int cnt = 0; 
        int pointer = 1; 

        while(pointer < 2*N+1){
            // System.out.println(pointer); 
            if(isSelected[pointer]){
                cnt++;
                pointer++; 
            }else{
                while(pointer < 2*N+1 && cnt > 0 && !isSelected[pointer]){
                    // System.out.println("remove");
                    answer++;
                    cnt--;
                    pointer++; 
                }

                while(pointer < 2*N+1 && !isSelected[pointer]){
                    // System.out.println("move");
                    pointer++; 
                }
            }
        }

        System.out.println(answer); 
    }
}