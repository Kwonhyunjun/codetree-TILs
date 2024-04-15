import java.util.*; 
import java.io.*; 

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int N = Integer.parseInt(st.nextToken()); // 식빵의 개수
        int M = Integer.parseInt(st.nextToken()); // 암호문의 개수

        LinkedList<Character> li = new LinkedList<>();
        String str = br.readLine(); 

        for(int i=0; i<str.length(); i++){
            li.add(str.charAt(i));
        }

        ListIterator<Character> it = li.listIterator(li.size()); 

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()); 

            switch(st.nextToken()){
                case "L" :
                    if(it.hasPrevious()){
                        it.previous(); 
                    }
                break;
                case "R" :
                    if(it.hasNext()){
                        it.next(); 
                    }
                break;
                case "D" :
                    if(it.hasNext()){
                        it.next();
                        it.remove(); 
                    }
                break;
                case "P" :
                    it.add(st.nextToken().charAt(0));
                break;
            }
        }

        for(char c : li){
            sb.append(c);    
        }

        System.out.println(sb); 
    }

}