import java.io.*;
import java.util.*;

public class Main {

    static int N, M; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        List<Data> list = new ArrayList<>(); 
        for(int r=0; r<N; r++){
            for(int c=0; c<M; c++){

                // System.out.printf("시작점 : %d, %d\n", r, c);

                for(int i=0; i<N-r; i++){
                    for(int j=0; j<M-c; j++){
                        // System.out.printf("길이 : %d %d\n", i, j);
                        
                        int area = 0; 
                        // 넓이 구하기
                        for(int k=r; k<=r+i; k++){
                            for(int l=c; l<=c+j; l++){
                                // System.out.printf("넓이 구하기 : map[%d][%d](%d)\n", k, l, map[k][l]); 
                                area += map[k][l]; 
                            }
                        }
                        // System.out.printf("가로 : %d~%d / 세로: %d~%d / 넓이 %d \n", r, r+i, c, c+j, area);
                        list.add(new Data(r, r+i, c, c+j, area)); 
                    }
                }
                // System.out.println(); 
            }
        }

        // for(Data d : list){
        //     System.out.println(d); 
        // }

        // System.out.println(list.size());

        int answer = Integer.MIN_VALUE; 

        for(int i=0; i<list.size(); i++){
            Data d1 = list.get(i); 
            for(int j=i+1; j<list.size(); j++){
                Data d2 = list.get(j);

                // System.out.println(d1);
                // System.out.println(d2);
                // System.out.println(); 

                if(isOver(d1, d2)) continue;
                // System.out.println("겹치지 않음");
                // System.out.println(d1);
                // System.out.println(d2);
                // System.out.println(); 
                answer = Math.max(answer, d1.area + d2.area); 
            }
        }
        System.out.println(answer); 
    }

    static boolean isOver(Data d1, Data d2){
        boolean[][] v = new boolean[N][M];

        for(int r=d1.sr; r<=d1.er; r++){
            for(int c=d1.sc; c<=d1.ec; c++){
                v[r][c] = true; 
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(v[i]));
        // }

        for(int r=d2.sr; r<=d2.er; r++){
            for(int c=d2.sc; c<=d2.ec; c++){
                if(v[r][c]) return true; 
            }
        }

        return false; 
    }

    static class Data{
        int sr; 
        int er; 
        int sc;
        int ec; 
        int area; 

        public Data(int sr, int er, int sc, int ec, int area){
            this.sr = sr;
            this.er = er;
            this.sc = sc;
            this.ec = ec;
            this.area = area; 
        }

        @Override
        public String toString(){
            return "[ 가로 : "+sc +"~"+ec + ", 세로 : "+sr +"~"+ er + ",  "+ "area : "+area+ " ]";  
        }
    }
}