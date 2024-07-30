import java.io.*;
import java.util.*; 

class Coin implements Comparable<Coin>{
    int r, c, num; 
    
    public Coin(int r, int c, int num){
        this.r = r;
        this.c = c;
        this.num = num; 
    }

    @Override
    public int compareTo(Coin o1){
        return this.num - o1.num; 
    }
}

public class Main {

    static int N, answer; 

    static int arr[], dist[][]; 
    static char[][] map;

    static ArrayList<Coin> coins = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        N = Integer.parseInt(br.readLine()); 
        answer = Integer.MAX_VALUE; 
        map = new char[N][N];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray(); 
        } 

        // 1. 각 지점마다 거리 계산하기
        // 1) 코인 정보 저장
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] >= 49 && map[i][j] <= 57){
                    coins.add(new Coin(i, j, map[i][j]-48)); 
                }else if(map[i][j] == 'S'){
                    coins.add(new Coin(i, j, 0));
                }else if(map[i][j] == 'E'){
                    coins.add(new Coin(i, j, 10)); 
                }
            }
        }

        Collections.sort(coins);
        int coinCnt = coins.size()-2;

        if(coinCnt < 3){
            System.out.println(-1);
            return; 
        }

        // 2) 거리 저장할 차원 배열 생성 및 초기화
        dist = new int[11][11]; 
        
        for(int i=0; i<coins.size(); i++){
            Coin coin = coins.get(i);
            int n = coin.num;
            // System.out.printf("1 : %d번 코인 %d %d\n", n, coin.r, coin.c);

            // 코인
            for(int j=i+1; j<coins.size(); j++){
                Coin coin2 = coins.get(j); 
                // System.out.printf(" 2 : %d번 코인 %d %d\n", coin2.num, coin2.r, coin2.c);
                int d = getDist(coin2.r, coin2.c, coin.r, coin.c);
                dist[n][coin2.num] = dist[coin2.num][n] = d; 
                // System.out.printf("dist[%d][%d] = %d \n", n, coin2.num, dist[n][coin2.num]);
            }
        }

        // for(int i=0; i<11; i++){
        //     System.out.println(Arrays.toString(dist[i]));
        // }

        arr = new int[3]; 
        // System.out.println("size : " + (coins.size()-2)); 
        choose(0, 1); 
        System.out.println(answer);
    }

    // 각 구간별 거리 구하는 메서드
    public static int getDist(int r1, int c1, int r2, int c2){
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }

    // 동전 순서 정하기
    public static void choose(int idx, int start){
        // System.out.printf("idx : %d, start : %d \n", idx, start); 
        if(idx == 3){
            // System.out.println(Arrays.toString(arr)); 
            answer = Math.min(answer, getTotalDist());
            return; 
        }
        
        for(int i=start; i<=coins.size()-2; i++){
            arr[idx] = i; 
            choose(idx+1, i+1); 
        }
    }

    public static int getTotalDist(){
        int res = 0; 
        // 시작점에서 첫번째 지점까지
        res += dist[0][coins.get(arr[0]).num]; 

        for(int i=0; i<2; i++){
            res += dist[coins.get(arr[i]).num][coins.get(arr[i+1]).num];
        }

        res += dist[coins.get(arr[2]).num][10];
        return res; 
    }
}