package practice.algorithms.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeautifulTriplets {

	private static int beautifulTriplets(int d, int[] arr) {
		int cnt = 0;

		Arrays.sort(arr);

		List<Map<Integer, List<Integer>>> list = new ArrayList();
		for (int i = 0; i < arr.length - 1; i++) {
			Map<Integer, List<Integer>> map = new HashMap();
			map.put(arr[i], new ArrayList(Arrays.asList(arr[i])));

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] - arr[i] == d) {
					int key = arr[i];
					List<Integer> subList = map.get(key);
					subList.add(arr[j]);

					for (int k = j + 1; k < arr.length; k++) {
						if (arr[k] - arr[j] == d) {
							subList.add(arr[k]);
						}
					}

					map.put(key, subList);
				}
			}
			list.add(map);
		}

		for (Map<Integer, List<Integer>> map : list) {
			for (Integer key : map.keySet()) {
				if (map.get(key).size() == 3) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		List<TestCase> testCase = new ArrayList();
		testCase.add(new TestCase(3, new int[] { 1, 2, 4, 5, 7, 8, 10 })); // 3

		for (TestCase tc : testCase) {
			int result = beautifulTriplets(tc.d, tc.arr);

			System.out.println("RESULT : " + result);
		}
	}

	public static class TestCase {
		int d;
		int[] arr;

		TestCase(int d, int[] arr) {
			this.d = d;
			this.arr = arr;
		}
	}

}
