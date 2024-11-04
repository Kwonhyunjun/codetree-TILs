import java.io.*;
import java.util.*; 

public class Main {

    static int dir, pos[]; 

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        String commands = br.readLine(); 

        dir = 0; 
        pos = new int[]{0, 0}; 

        for(int i=0; i<commands.length(); i++){
            char command = commands.charAt(i); 
            // System.out.println(dir);
            
            switch(command){
                case 'F' : 
                    pos[0] += dr[dir];
                    pos[1] += dc[dir];
                    break; 
                case 'R' :
                    rotateRight(); 
                    break; 
                case 'L' :
                    rotateLeft(); 
                    break; 
                    
            }
        }

        System.out.println(pos[1] + " " + pos[0]); 
    }

    static void rotateLeft(){
        dir = (dir - 1 + 4) % 4; 
    }

    static void rotateRight(){
        dir = (dir + 1) % 4; 
    }
}