package practice.algorithms.search;

//배열을 정렬하고, k보다 큰 수가 들어오면 break(비교 중지)하는 것으로 통과

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pairs {

	static int pairs(int k, int[] arr) {
		int answer = 0;

		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int diff = Math.abs(arr[i] - arr[j]);
				if (diff > k) {
					break;
				}
				if (k == diff) {
					map.put(diff, map.getOrDefault(diff, 0) + 1);
				}
			}
		}

		if (map.containsKey(k)) {
			answer = map.get(k);
		}

		return answer;
	}

	public static void main(String[] args) {
		List<TestCase> list = new ArrayList();
		list.add(new TestCase(2, new int[] { 1, 5, 3, 4, 2 }));

		for (TestCase test : list) {
			int answer = pairs(test.k, test.arr);
			System.out.println(answer);
		}
	}

	static class TestCase {
		int k;
		int[] arr;

		TestCase(int k, int[] arr) {
			this.k = k;
			this.arr = arr;
		}
	}
}
