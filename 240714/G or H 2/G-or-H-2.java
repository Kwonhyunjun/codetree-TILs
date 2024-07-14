import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        int answer = 0; 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st; 

        int N = Integer.parseInt(br.readLine());

        char[] arr = new char[101]; 
        List<Integer> list = new ArrayList<>(); 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 

            int idx = Integer.parseInt(st.nextToken());
            arr[idx] = st.nextToken().charAt(0);
            list.add(idx);
        }

        Collections.sort(list); 

        // System.out.println(list); 
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                // System.out.printf("%d ~ %d -> ", i, j);
                // System.out.printf("%d ~ %d \n", list.get(i), list.get(j));
                int cntG = 0;
                int cntH = 0; 
                for(int k=list.get(i); k<=list.get(j); k++){
                    // System.out.println(k);
                    if(arr[k] == 'G'){
                        cntG++; 
                    }else if(arr[k] == 'H'){
                        cntH++; 
                    }

                }

                // System.out.printf("cntG : %d, cntH : %d\n", cntG, cntH);

                if((cntG == 0 && cntH != 0) || (cntG != 0 && cntH == 0)){
                    answer = Math.max(answer, list.get(j)-list.get(i)); 
                }

                if(cntG == cntH){
                    answer = Math.max(answer, list.get(j)-list.get(i)); 
                }
            }
        }

        System.out.println(answer);
    }
}