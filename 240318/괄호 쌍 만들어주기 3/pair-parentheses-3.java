import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        int len = str.length(); 
        char[] arr = new char[len];

        arr = str.toCharArray();

        int cnt = 0; 

        for(int i=0; i<len; i++){
            if(arr[i] == ')') continue;

            for(int j=i+1; j<len; j++){
                if(arr[j] == ')') cnt++;
            }
        }
        System.out.println(cnt); 
    }
}