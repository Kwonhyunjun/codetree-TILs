import java.io.*;
import java.util.*; 

class Line{
    int link1, link2, height; 
    boolean isActive; 

    public Line(int link1, int link2, int height){
        this.link1 = link1;
        this.link2 = link2;
        this.height = height; 
        isActive = true;
    }
}

public class Main {

    static int N, M, answer, goal[]; 
    static Line[][] map; 
    static Line[] lines; 
    static boolean flag = false; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 가로선의 수

        lines = new Line[16]; // 가로선 저장하는 배열 
        map = new Line[N+1][16]; // 사다리 타기 현황 

        int maxHeight = 0; 
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int num = Integer.parseInt(st.nextToken()); 
            int height = Integer.parseInt(st.nextToken()); 

            lines[i] = new Line(num, num+1, height);
            map[num][height] = lines[i]; 
            map[num+1][height] = lines[i]; 
            maxHeight = Math.max(maxHeight, height); 
        }

        answer = M+1;
        goal = simulation(); 
        // System.out.println(Arrays.toString(goal)); 
        solve(0, 0); 
        System.out.println(answer); 
    }

    static void solve(int cnt, int activeLineCnt){
        if(cnt >= M){
            if(isSame()){
                answer = Math.min(answer, activeLineCnt); 
                // flag = true; 
            }
            return; 
        }

        // if(flag) return; 


        // 비활성화
        lines[cnt].isActive = false;
        solve(cnt+1, activeLineCnt); 
        lines[cnt].isActive = true;

        // 활성화
        solve(cnt+1, activeLineCnt+1);  
    }

    static int[] simulation(){
        int[] res = new int[N+1]; 

        for(int i=1; i<=N; i++){
            // System.out.printf("%d번 사람\n", i);
            int curLine = i; 
            int height = 1; 

            while(true){
                // System.out.printf("    높이: %d - 현재위치 : %d줄\n", height, curLine);
                if(height == 16){
                    res[i] = curLine;
                    break; 
                }

                Line now = map[curLine][height]; 

                if(now != null && now.isActive){
                    curLine = (now.link1 == curLine)? now.link2 : now.link1;
                    // System.out.printf("    %d로 줄변경\n", curLine);
                }
                height++; 
            }
        }
        return res;
    } 

    static boolean isSame(){
        int[] temp = simulation(); 

        // System.out.println(Arrays.toString(temp));

        for(int i=1; i<=N; i++){
            if(temp[i] != goal[i]) 
                return false;
        }
        return true; 
    }
}