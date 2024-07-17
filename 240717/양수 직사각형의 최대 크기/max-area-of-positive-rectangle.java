import java.io.*; 
import java.util.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M]; 

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()); 
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int answer = 0; 

        for(int sr=0; sr<N; sr++){
            for(int sc=0; sc<M; sc++){
                
                for(int i=sr; i<N; i++){
                    for(int j=sc; j<M; j++){
                        // System.out.printf("%d~%d, %d~%d \n", sc, j, sr, i);
                        boolean flag = true; 

                        for(int k=sr; k<=i; k++){
                            for(int l= sc; l<=j; l++){
                                if(map[k][l] <= 0) {
                                    flag = false; 
                                    break; 
                                }
                            }
                        }

                        if(flag){
                            answer = Math.max(answer, (j-sc+1) * (i-sr+1)); 
                        }

                    }
                }

            }
        }

        System.out.println(answer); 
    }
}