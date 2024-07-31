import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer, adjMatrix[][]; 
    static ArrayList<Integer>[] adjList; 
    static boolean[] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수 

        // 방문배열 (그래프 탐색 알고리즘 대원칙 2번 - 이미 방문한 정점은 다시는 방문하지 않는다.)
        v = new boolean[N];

        // 인접행렬
        adjMatrix = new int[N][N];
        
        // 인접리스트
        adjList = new ArrayList[N];
        for(int i=0; i<N; i++){
            adjList[i] = new ArrayList<>(); 
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            // 인접행렬
            adjMatrix[a][b] = adjMatrix[b][a] = 1;
            
            // 인접리스트
            adjList[a].add(b);
            adjList[b].add(a);
        }

        v[0] = true;
        dfs2(0); 

        System.out.println(answer);
    }

    /*
        인접행렬을 이용한 DFS
        vertex : 현재 방문한 정점
    */
    public static void dfs1(int vertex){

        for(int i=0; i<N; i++){
            if(adjMatrix[vertex][i] == 1 && !v[i]){
                v[i] = true;
                answer++;  
                dfs1(i); 
            }
        }
    }

    /*
        인접리스트를 잉요한 DFS
    */

    public static void dfs2(int vertex){
        ArrayList<Integer> cur = adjList[vertex];
        
        for(int i=0; i<cur.size(); i++){
            if(v[cur.get(i)]) continue; 
            
            v[cur.get(i)] = true;
            answer++; 
            dfs2(cur.get(i)); 
        }
    }
}