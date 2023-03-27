import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int k;
	static int[] arr;
	static List<ArrayList<Integer>> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		k = sc.nextInt();
		arr = new int[(int) Math.pow(2, k) - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		// depth에 맞게 노드를 저장하기 위한 list
		list = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			list.add(new ArrayList<>());
		}
		search(0, arr.length - 1, 0);

		// 출력을 위해 StringBuilder에 담기
		for (int i = 0; i < k; i++) {
			for (int j : list.get(i)) {
				sb.append(j).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void search(int start, int end, int depth) {
		// 재귀 탈출문
		if (depth == k) {
			return;
		}

		// 중간값
		int mid = (start + end) / 2;

		// depth에 맞게 노드 삽입
		list.get(depth).add(arr[mid]);

		// 왼쪽 노드(시작부터 중간 - 1 까지)
		search(start, mid - 1, depth + 1);
		// 오른쪽 노드 ( 중간 + 1 부터 끝까지)
		search(mid + 1, end, depth + 1);
	}
}