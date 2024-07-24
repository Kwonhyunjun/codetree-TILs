/*
    방향을 바꾸는 데에는 시간이 전혀 소요되지 않음
    움직이고 난 후 같은 위치에 여러 구슬이 위치하게 될 수도 있다. 
        -> K개가 넘는 구슬이 같은 칸에 위치하게 된다면 우선순위가 높은 구슬 K개만 살아남고 나머지 구슬은 전부 사라지게 됨
        -> 속도가 빠른 구슬일 수록 우선순위가 높으며 구슬의 속도가 일치할 경우 구슬의 번호가 더 큰 구슬이 우선순위가 높음
*/

import java.io.*;
import java.util.*; 

public class Main {

    static List<Marble> list;            // 구슬 저장 리스트
    static PriorityQueue<Marble>[][] map; // 충돌 확인 맵
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken()); // 격자의 크기
        int M = Integer.parseInt(st.nextToken()); // 구슬의 크기
        int T = Integer.parseInt(st.nextToken()); // 시간
        int K = Integer.parseInt(st.nextToken()); // 살아남을 수 있는 최대 구슬 수

        list = new ArrayList<>(); 
        map = new PriorityQueue[N][N]; 

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            char direction = st.nextToken().charAt(0); 
            int d = (direction == 'U') ? 0 : (direction == 'L') ? 1 : (direction == 'R') ? 2 : 3; 
            int v = Integer.parseInt(st.nextToken()); 

            list.add(new Marble(i, r, c, v, d)); 
        }

        for(int t=0; t<T; t++){
            for(int r=0; r<N ;r++){
                for(int c=0; c<N; c++){
                    map[r][c] = new PriorityQueue<>(); 
                }
            }

            // 1. 구슬리스트 순회하면서 움직이기
            for(Marble m : list){
                if(!m.isAlive) continue;
                // 1) Marble 상태변경(움직이기)
                int nr = m.r;
                int nc = m.c;
                // System.out.println("이동 전 " + nr + " " + nc);
                for(int i=0; i<m.v; i++){ // 상 좌 우 하
                    if((m.d == 0 && nr == 0) || (m.d == 1 && nc == 0) ||
                        (m.d == 2 && nc == N-1) || (m.d == 3 && nr == N-1)){
                        m.d = 3 - m.d; 
                        // System.out.println("방향전환");
                    }

                    nr = nr + dr[m.d];
                    nc = nc + dc[m.d];

                    // System.out.println(nr + " " + nc); 
                }
                // System.out.println("이동 후 " + nr + " " + nc);
                
                // 2) PQ맵에 해당 구슬 넣기
                map[nr][nc].add(m); 
            }

            // 2. 충돌 확인
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c].size() > K){
                        // System.out.println("넘침 " + r + " " + c);
                        while(map[r][c].size() > K){
                            map[r][c].poll().isAlive = false; 
                            
                        }
                    }
                }
            }
        }

        // 3. 리스트 순회하면서 살아있는 구슬 찾기
        int cnt = 0;
        for(Marble m : list){
            if(m.isAlive) cnt++; 
        }

        System.out.println(cnt); 
    }

    // 구슬 클래스 
    static class Marble implements Comparable<Marble>{
        int n; 
        int r; 
        int c; 
        int v;
        int d; 
        boolean isAlive = true;

        public Marble(int n, int r, int c, int v, int d){
            this.n = n; 
            this.r = r;
            this.c = c;
            this.v = v; 
            this.d = d; 
        } 

        @Override
        public int compareTo(Marble o1){
            if(this.v == o1.v)
                return this.n - o1.n;
            return this.v - o1.v; // 속도 오름차순 (작은거 부터)
        }
    }
}