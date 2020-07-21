package practice.algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.hackerrank.com/challenges/sherlock-and-array/problem

//중첩 for문을 피하고, 전체합을 미리 구해놓음으로써 통과

public class SherlockAndArray {

	static String balancedSums(List<Integer> arr) {
		String result = "NO";

		if (arr.size() == 1) {
			result = "YES";
			return result;
		}

		int total = 0;
		for (int j = 0; j < arr.size(); j++) {
			total += arr.get(j);
		}

		int leftSum = 0;
		for (int i = -1; i < arr.size() - 1; i++) {
			if (i >= 0) {
				leftSum += arr.get(i);
			}

			int rightSum = total - leftSum - arr.get(i + 1);

			if (leftSum == rightSum) {
				result = "YES";
				break;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList();
		list.add(Arrays.asList(1, 1, 4, 1, 1)); // YES
		list.add(Arrays.asList(2, 0, 0, 0)); // YES
		list.add(Arrays.asList(0, 0, 2, 0)); // YES
		list.add(Arrays.asList(1, 2, 3));// NO
		list.add(Arrays.asList(1, 2, 3, 3));// YES

		// CASE 0
		list.add(Arrays.asList(75, 26, 45, 72, 81, 47, 29, 97, 2, 75, 25, 82, 84, 17, 56, 32, 2, 28, 37, 57, 39, 18, 11,
				79, 6, 40, 68, 68, 16, 40, 63, 93, 49, 91, 10, 55, 68, 31, 80, 57, 18, 34, 28, 76, 55, 21, 80, 22, 45,
				11, 67, 67, 74, 91, 4, 35, 34, 65, 80, 21, 95, 1, 52, 25, 31, 2, 53, 96, 22, 89, 99, 7, 66, 32, 2, 68,
				33, 75, 92, 84, 10, 94, 28, 54, 12, 9, 80, 43, 21, 51, 92, 20, 97, 7, 25, 67, 17, 38, 100, 86));// NO

		list.add(Arrays.asList(83, 20, 6, 81, 58, 59, 53, 2, 54, 62, 25, 35, 79, 64, 27, 49, 32, 95, 100, 20, 58, 39,
				92, 30, 67, 89, 58, 81, 100, 66, 73, 29, 75, 81, 70, 55, 18, 28, 7, 35, 98, 52, 30, 11, 69, 48, 84, 54,
				13, 14, 15, 86, 34, 82, 92, 26, 8, 53, 62, 57, 50, 31, 61, 85, 88, 5, 80, 64, 90, 52, 47, 43, 40, 93,
				69, 70, 16, 43, 7, 25, 99, 12, 63, 99, 71, 76, 55, 17, 90, 43, 27, 20, 42, 84, 39, 96, 75, 1, 58, 49));// NO

		list.add(Arrays.asList(185, 170, 208, 216, 236, 155, 88, 206, 211, 209, 84, 99, 130, 245, 232, 125, 127, 232,
				187, 140, 92, 213, 221, 231, 129, 197, 221, 168, 95, 186, 136, 180, 94, 125, 150, 244, 249, 248, 140,
				207, 125, 84, 123, 85, 100, 175, 67, 116, 107, 143, 158, 75, 165, 172, 115, 134, 175, 123, 115, 123,
				159, 181, 63, 176, 158, 109, 67, 154, 126, 141, 111, 95, 138, 161, 71, 118, 151, 189, 126, 109, 194,
				176, 159, 151, 189, 71, 95, 133, 154, 157, 109, 78, 101, 174, 169, 152, 94, 193, 176, 137));// YES

		for (List<Integer> arr : list) {
			String result = balancedSums(arr);

			System.out.println("RESULT:" + result);
		}

	}

}
