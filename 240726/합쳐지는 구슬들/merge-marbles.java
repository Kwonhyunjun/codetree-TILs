import java.io.*;
import java.util.*;

class Marble{
    int r, c, dir, weight, num;

    public Marble(int r, int c, int dir, int weight, int num){
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.weight = weight; 
        this.num = num;
    }

    @Override
    public String toString(){
        return "["+ this.r +" "+ this.c +" "+ this.dir +" "+ this.weight +" "+ this.num  +"]";
    }
}

public class Main {
    public static final int ASCII_NUM = 128;

    static int n, t; 

    static int[] mapper = new int[ASCII_NUM];
    static int[] dr = {-1, 0, 0, 1}; // 상 좌 우 하
    static int[] dc = {0, -1, 1, 0}; 
    
    static int heaviest, largest, map[][];
    static List<Marble> marbles = new ArrayList<>();
    static ArrayList<Marble> nextMarbles = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        mapper['U'] = 0; 
        mapper['D'] = 3; 
        mapper['L'] = 1; 
        mapper['R'] = 2; 

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        heaviest = -1;
        largest = -1;

        map = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(map[i], -1); 
        }

        // 구슬 저장
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine()); 

            int r = Integer.parseInt(st.nextToken())-1; 
            int c = Integer.parseInt(st.nextToken())-1; 
            int dir = mapper[st.nextToken().charAt(0)]; 
            int weight = Integer.parseInt(st.nextToken());

            marbles.add(new Marble(r, c, dir, weight, i)); 
        }


        simulate();

        System.out.println(marbles.size() + " " + heaviest);
    }

    public static void simulate(){
        
        while(t-- >0){
            // System.out.println("t: " +t);
            // 구슬 움직이기
            for(int i=0; i<marbles.size(); i++){
                // System.out.println("이동 전 : " + marbles.get(i));
                Marble nextMarble = move(marbles.get(i));
                // System.out.println("이동 후 : " + nextMarble);

                pushNextMarble(nextMarble);
            }
            
            marbles = (ArrayList<Marble>) nextMarbles.clone(); 

            for(int i=0; i<nextMarbles.size(); i++){
                Marble m = nextMarbles.get(i);

                map[m.r][m.c] = -1;
            }

            nextMarbles = new ArrayList<>(); 
        }

        
        for(int i=0; i<marbles.size(); i++){
            heaviest = Math.max(heaviest, marbles.get(i).weight); 
            
            largest = Math.max(largest, marbles.get(i).num); 
        }
    }

    public static Marble move(Marble marble){
        int nr = marble.r + dr[marble.dir]; 
        int nc = marble.c + dc[marble.dir];

        if(nr < 0 || nc < 0 || nr >= n || nc >= n){
            return new Marble(marble.r, marble.c, (3-marble.dir), marble.weight, marble.num); 
        }

        return new Marble(nr, nc, marble.dir, marble.weight, marble.num);
    }

    public static void pushNextMarble(Marble marble){
        int idx = map[marble.r][marble.c]; 

        if(idx == -1){
            nextMarbles.add(marble); 
            map[marble.r][marble.c] = nextMarbles.size() -1; 
        }else{
            collide(idx, marble);
        }
    }

    public static void collide(int idx, Marble marble){
        Marble merge = nextMarbles.get(idx);
        
        // 무게는 구슬의 합
        merge.weight += marble.weight; 
        
        // 큰 번호가 매겨져 있는 구슬의 방향을 따르게 됨,
        if(marble.num > merge.num){ 
            merge.num = marble.num;
            merge.dir = marble.dir; 
        }
    }
}