import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		char[][] arr = new char[n][n];
		int cnt = 1;
		int max = 0;
		for(int i = 0; i<n; i++) {
			String str = sc.nextLine();
			arr[i] = str.toCharArray();
		}
		//전체 탐색
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n-1; j++) {
				if(arr[i][j]==arr[i][j+1]) {
					cnt++;
				}else {
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
				}
			}
			if(cnt>max) {
				max = cnt;
			}
			cnt = 1;
		}
		for(int j = 0; j<n; j++) {
			for(int i = 0; i<n-1; i++) {
				if(arr[i][j]==arr[i+1][j]) {
					cnt++;
				}else {
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
				}
			}
			if(cnt>max) {
				max = cnt;
			}
			cnt = 1;
		}
		
		
		//양옆 탐색
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n-1; j++) {
				if(arr[i][j]!=arr[i][j+1]) { // 교화해주고
					char temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
					//몇갠지 찾기
					//가로
					for(int k = 0; k<n-1; k++) {
						if(arr[i][k]==arr[i][k+1]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
					//세로
					for(int k = 0; k<n-1; k++) {
						if(arr[k][j]==arr[k+1][j]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
					for(int k = 0; k<n-1; k++) {
						if(arr[k][j+1]==arr[k+1][j+1]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
					
					//원래대로
					temp = arr[i][j];
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
				}
			}
		}
		
		//위아래 탐색
		
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]!=arr[i+1][j]) { // 교화해주고
					char temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
					//몇갠지 찾기
					//가로
					for(int k = 0; k<n-1; k++) {
						if(arr[i][k]==arr[i][k+1]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
					//가로
					for(int k = 0; k<n-1; k++) {
						if(arr[i+1][k]==arr[i+1][k+1]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;

					
					for(int k = 0; k<n-1; k++) {
						if(arr[k][j]==arr[k+1][j]) {
							cnt++;
						}else {
							if(cnt>max) {
								max = cnt;
							}
							cnt = 1;
						}
					}
					if(cnt>max) {
						max = cnt;
					}
					cnt = 1;
					
					//원래대로
					temp = arr[i][j];
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
				}
			}
		}
		System.out.println(max);
	}//main
}