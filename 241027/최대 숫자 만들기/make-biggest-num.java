import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int N = Integer.parseInt(br.readLine()); 
        Integer[] arr = new Integer[N]; 

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(arr);

        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2); 
                // System.out.println(s1 + " " + s2);
                int n1 = Integer.parseInt(s1+s2);
                int n2 = Integer.parseInt(s2+s1);

                // System.out.println(n1 + " " + n2);

                if(n1 < n2){
                    // System.out.println("n1이 더작음");
                    return o1-o2;
                }else{
                    // System.out.println("n2이 더작음");
                    return -(o1-o2);
                }
            }
        }); 

        StringBuilder sb = new StringBuilder(); 

        for(int num : arr){
            sb.append(num);
            // System.out.println("arr : " + num );
        }

        System.out.println(Long.parseLong(sb.toString()));
    }
}