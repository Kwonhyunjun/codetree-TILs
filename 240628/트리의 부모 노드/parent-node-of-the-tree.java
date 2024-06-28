import java.io.*;
import java.util.*;

public class Main {

    static int N; 
    static boolean[] v;
    static int[] parents; 
    static ArrayList<Integer>[] edges; 

    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 노드 개수
        
        v = new boolean[N+1]; // 방문 체크 배열
        parents = new int[N+1]; // 부모 노드
        edges = new ArrayList[N+1]; // 간선 정보 저장하는 리스트 배열

        // 간선 리스트 초기화
        for(int i=1; i<N+1; i++){
            edges[i] = new ArrayList<Integer>();
        }

        // 간선 정보 저장
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a].add(b);
            edges[b].add(a);
        }

        v[1] = true; 
        dfs(1);
        

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<N+1; i++){
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int n){
        // System.out.printf("현재 노드 : %d\n", n);
        for(int i=0; i<edges[n].size(); i++){
            int num = edges[n].get(i); 
            
            if(!v[num]){
                // 부모 정보 저장
                // System.out.printf("부모노드(%d)의 자식노드 : %d\n", n, num);
                parents[num] = n; 
                v[num] = true;
                dfs(num); 
            }
        }
    }
}