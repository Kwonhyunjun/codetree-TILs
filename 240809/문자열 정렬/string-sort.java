import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Arrays.sort(arr); 

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}