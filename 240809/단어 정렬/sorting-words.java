import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine()); 

        ArrayList<String> list = new ArrayList<>(); 

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        Collections.sort(list); 

        for(int i=0; i<N; i++){
            System.out.println(list.get(i)); 
        }
        
    }
}