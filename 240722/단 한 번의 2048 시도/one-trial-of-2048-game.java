import java.io.*; 
import java.util.*; 

public class Main {

    static int[][] map; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4]; 
        
        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<4; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        char direction = br.readLine().charAt(0); 
        move(direction);

        StringBuilder sb = new StringBuilder(); 
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                sb.append(map[i][j]).append(" "); 
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void move(char direction){
        int[][] temp = new int[4][4]; 

        switch(direction){
            case 'L' : 
                for(int r=0; r<4; r++){
                    int idx = 1; 
                    int num = 0;
                    int start = 0; 
                    for(int i=0; i<4; i++){
                        if(map[r][i] != 0){
                            start = i; 
                            num = map[r][i]; 
                            temp[r][0] = map[r][i];
                            break;  
                        }
                    }
                    // System.out.printf("start : %d, num : %d\n", start, num);
                    for(int c=start+1; c<4; c++){
                        if(map[r][c] == 0)continue; 

                        if(map[r][c] != num){
                            temp[r][idx++] = map[r][c]; 
                            num = map[r][c]; 
                        }else{
                            temp[r][idx-1] = map[r][c] * 2; 
                            num = -1; 
                        }
                    }
                } 
                break;
            case 'R' :
                for(int r=0; r<4; r++){
                    int idx = 2; 
                    int num = 0;
                    int start = 0; 
                    for(int i=3; i>=0; i--){
                        if(map[r][i] != 0){
                            start = i; 
                            num = map[r][i]; 
                            temp[r][3] = map[r][i];
                            break;  
                        }
                    }
                    // System.out.printf("start : %d, num : %d\n", start, num);
                    for(int c=start-1; c>=0; c--){
                        if(map[r][c] == 0)continue; 

                        if(map[r][c] != num){
                            temp[r][idx--] = map[r][c]; 
                            num = map[r][c]; 
                        }else{
                            temp[r][idx+1] = map[r][c] * 2; 
                            num = -1; 
                        }
                    }
                } 
                break;
            case 'U' : 
                for(int c=0; c<4; c++){
                    int idx = 1; 
                    int num = 0;
                    int start = 0; 
                    for(int i=0; i<4; i++){
                        if(map[i][c] != 0){
                            start = i; 
                            num = map[i][c]; 
                            temp[0][c] = map[i][c];
                            break;  
                        }
                    }
                    // System.out.printf("start : %d, num : %d\n", start, num);
                    for(int r=start+1; r<4; r++){
                        if(map[r][c] == 0)continue; 

                        if(map[r][c] != num){
                            temp[idx++][c] = map[r][c]; 
                            num = map[r][c]; 
                        }else{
                            temp[idx-1][c] = map[r][c] * 2; 
                            num = -1; 
                        }
                    }
                } 
                break;
            case 'D' : 
                for(int c=0; c<4; c++){
                    int idx = 2; 
                    int num = 0;
                    int start = 0; 
                    for(int i=3; i>=0; i--){
                        if(map[i][c] != 0){
                            start = i; 
                            num = map[i][c]; 
                            temp[3][c] = map[i][c];
                            break;  
                        }
                    }
                    // System.out.printf("start : %d, num  : %d\n", start, num);
                    for(int r=start-1; r>=0; r--){
                        if(map[r][c] == 0)continue; 

                        if(map[r][c] != num){
                            temp[idx--][c] = map[r][c]; 
                            num = map[r][c]; 
                        }else{
                            temp[idx+1][c] = map[r][c] * 2; 
                            num = -1; 
                        }
                    }
                } 
                break;
        }
            
        map = temp; 
        
    }

}