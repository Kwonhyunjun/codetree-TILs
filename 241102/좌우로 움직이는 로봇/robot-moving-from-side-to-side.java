import java.io.*;
import java.util.*;

public class Main {

    static int N, M, arrA[], arrB[]; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> listA = new ArrayList<>(); 
        ArrayList<Integer> listB = new ArrayList<>(); 
        
        int total = 0; 
        listA.add(0);
        listB.add(0); 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            
            int t = Integer.parseInt(st.nextToken()); 
            int d = (st.nextToken().equals("L")) ? -1 : 1; 

            for(int j=0; j<t; j++){
                listA.add(listA.get(listA.size()-1)+d); 
            }
        }
        

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 
            
            int t = Integer.parseInt(st.nextToken()); 
            int d = (st.nextToken().equals("L")) ? -1 : 1; 

            for(int j=0; j<t; j++){
                listB.add(listB.get(listB.size()-1)+d); 
            }
        }

        // System.out.println(listA);
        // System.out.println(listB);


        int p = 1; 
        int answer = 0; 
        while(true){
            if(p >= listA.size() && p >= listB.size()) break; 

            int curA = (p < listA.size()) ? listA.get(p) : listA.get(listA.size()-1);
            int curB = (p < listB.size()) ? listB.get(p) : listB.get(listB.size()-1);
            int prevA = (p < listA.size()) ? listA.get(p-1) : listA.get(listA.size()-2);
            int prevB = (p < listB.size()) ? listB.get(p-1) : listB.get(listB.size()-2);

            if((curA == curB) && (prevA != prevB)) {
                // System.out.println("meet : " + p);
                answer++;
            } 
            p++; 
        }

        System.out.println(answer);

    }
}