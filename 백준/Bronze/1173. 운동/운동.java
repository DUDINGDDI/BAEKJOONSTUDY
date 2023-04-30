import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
	public static int N,m,M,T,R, CUR;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line[] = in.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		CUR = m = Integer.parseInt(line[1]);
		M = Integer.parseInt(line[2]);
		T = Integer.parseInt(line[3]);
		R = Integer.parseInt(line[4]);
		out.write(String.valueOf(simulate()));
		out.close();
		in.close();
	}
	private static int simulate(){
		int i = 0, time = 0;
		if(m+T>M) return -1;
		for(i=0;time<N;i++){
			if(CUR+T<=M){
				exercise();
				time++;
			}
			else rest();
		}
		return i;
	}
	private static void rest(){
		int tmp = CUR-R;
		if(tmp<m) CUR = m;
		else CUR = tmp;
	}
	private static void exercise(){ CUR+=T; }
}