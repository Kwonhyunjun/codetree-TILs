/*
    2초에 한 칸씩 동일한 속도로 정해진 방향으로 움직이고 있음
    영향력이 크다 -> 무게가 가장 크거나, 무게가 같은 구슬일 경우 구슬의 번호가 가장 클 경우
    두 구슬이 이동하는 도중에 발생할 수도 잇음

    return 가장 마지막으로 충돌이 일어난 시간
*/

import java.io.*;
import java.util.*;

public class Main {

    static float[] dr = {0.5f, -0.5f, 0f, 0f}; // 상하좌우
    static float[] dc = {0f, 0f, -0.5f, 0.5f};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 

        int TC = Integer.parseInt(br.readLine()); 
        HashMap<Character, Integer> dmap = new HashMap<>();
        dmap.put('U', 0);
        dmap.put('D', 1);
        dmap.put('L', 2);
        dmap.put('R', 3); 

        for(int tc=0; tc<TC; tc++){
            int N = Integer.parseInt(br.readLine()); // 구슬 개수
            List<Marble> list = new ArrayList<>(); // 구슬 저장 리스트

            // 구슬 저장
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine()); 
                int c = Integer.parseInt(st.nextToken()); 
                int r = Integer.parseInt(st.nextToken()); 
                int w = Integer.parseInt(st.nextToken()); 
                char d = st.nextToken().charAt(0);

                list.add(new Marble(i, r, c, d, w)); 
            }

            int answer = -1; 

            for(int t=1; t<=4001; t++){
                HashMap<String, Marble> map = new HashMap<>();

                // 이동
                StringBuilder sb = new StringBuilder(); 
                for(Marble m : list){
                    if(!m.isIn || !m.isAlive) continue; 
                    
                    if(m.r > 1000 || m.c > 1000 || m.r < -1000 || m.c < -1000){
                        m.isIn = false;
                        continue; 
                    }

                    float nr = m.r + dr[dmap.get(m.d)];
                    float nc = m.c + dc[dmap.get(m.d)];
                    
                    m.r = nr;
                    m.c = nc; 

                    sb.setLength(0); 
                    sb.append(nr).append("/").append(nc);
                    
                    String key = sb.toString();
                    Marble marble = m;
                    Marble data = map.get(key);
                    if(data != null){
                        answer = t; 
                        if(data.w == marble.w){
                            if(data.n > marble.n){
                                marble.isAlive = false; 
                                marble = data;     
                            }else{
                                data.isAlive = false; 
                            }
                        }else{
                            if(data.w > marble.w){
                                marble.isAlive = false;
                                marble = data; 
                            }else{
                                data.isAlive = false; 
                            }
                        }
                    }
                    map.put(key, marble); 
                }
            }
            System.out.println(answer);
        } 
    }

    static class Marble implements Comparable<Marble>{
        int n; 
        float r; 
        float c;
        char d;
        int w;  
        boolean isIn = true;
        boolean isAlive = true;  

        public Marble(int n, int r, int c, char d, int w){
            this.n = n;
            this.r = (float) r; 
            this.c = (float) c;
            this.d = d;
            this.w = w; 
        }

        @Override
        public int compareTo(Marble o1){
            if(this.w == o1.w){
                return this.n - o1.n; 
            }
            return this.w - o1.w;
        }
    }
}