import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> password = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();	
            String ps = st.nextToken();		
            password.put(site, ps);
        }
        for(int i=0;i<M;i++){
            String site = br.readLine();
            bw.write(password.get(site) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}