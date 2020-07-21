package practice.algorithms.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/challenges/acm-icpc-team/problem

public class ACM_ICPC_Team {

	static List<String[]> combination(String[] arr, boolean[] visited, int start, int n, int r) {
		List<String[]> pairList = new ArrayList<String[]>();

		if (r == 0) {
			pairList.add(getPairs(arr, visited, n));
			return pairList;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			pairList.addAll(combination(arr, visited, i + 1, n, r - 1));
			visited[i] = false;
		}

		return pairList;
	}

	static String[] getPairs(String[] arr, boolean[] visited, int n) {
		String[] pair = new String[2];

		int pairCnt = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				pair[pairCnt] = arr[i];
				pairCnt++;
			}
		}

		return pair;
	}

	static int[] acmTeam(String[] topic) {
		int[] answer = new int[2];

		boolean[] visited = new boolean[topic.length];
		List<String[]> pairList = combination(topic, visited, 0, topic.length, 2);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for (String[] pairArr : pairList) {
			int cnt = 0;
			for (int i = 0; i < pairArr[0].length(); i++) {
				if (!(pairArr[0].charAt(i) == '0' && pairArr[1].charAt(i) == '0')) {
					cnt++;
				}
			}

			if (max < cnt) {
				max = cnt;
			}

			map.put(cnt, map.getOrDefault(cnt, 0) + 1);
		}

		answer[0] = max;
		answer[1] = map.get(max);

		return answer;
	}

	public static void main(String[] args) {
		List<String[]> tcList = new ArrayList();
		tcList.add(new String[] { "10101", "11100", "11010", "00101" }); // 5, 2

		for (String[] topic : tcList) {
			int[] answer = acmTeam(topic);
			System.out.println(Arrays.toString(answer));
		}
	}
}
