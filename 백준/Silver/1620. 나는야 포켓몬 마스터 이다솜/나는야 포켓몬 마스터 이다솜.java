import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		HashMap<String, Integer> hm1 = new HashMap<>();
		HashMap<Integer, String> hm2 = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String a = sc.next();
			hm1.put(a, i);	//이름으로 찾기
			hm2.put(i, a);	//숫자로 찾기;
		}
		for (int i = 0; i < m; i++) {
			String str = sc.next();
			if (isNumber(str)) {
				int a = Integer.parseInt(str);
				sb.append(hm2.get(a)+"\n");
			}else{
				sb.append(hm1.get(str)+"\n");
			}
		}
		System.out.println(sb);
	}

	static boolean isNumber(String str) {
		char tempCh;
		int dotCount = 0; // 실수일 경우 .의 개수를 체크하는 변수
		boolean result = true;

		for (int i = 0; i < str.length(); i++) {
			tempCh = str.charAt(i); // 입력받은 문자열을 문자단위로 검사
			// 아스키 코드 값이 48 ~ 57사이면 0과 9사이의 문자이다.
			if ((int) tempCh < 48 || (int) tempCh > 57) {
				// 만약 0~9사이의 문자가 아닌 tempCh가 .도 아니거나
				// .의 개수가 이미 1개 이상이라면 그 문자열은 숫자가 아니다.
				if (tempCh != '.' || dotCount > 0) {
					result = false;
					break;
				} else {
					// .일 경우 .개수 증가
					dotCount++;
				}
			}
		}
		return result;
	}

}