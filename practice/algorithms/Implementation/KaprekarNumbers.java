package practice.algorithms.Implementation;

import java.util.ArrayList;
import java.util.List;

public class KaprekarNumbers {

	static void kaprekarNumbers(int p, int q) {
		StringBuffer sb = new StringBuffer();

		if (p == 1) {
			sb.append(p).append(" ");
			p++;
		}

		for (int i = p; i <= q; i++) {
			String sr = String.valueOf((long) (Math.pow(i, 2)));

			if (sr.length() >= 2) {
				String first = sr.substring(0, sr.length() / 2);
				String second = sr.substring(sr.length() / 2, sr.length());

				long part = Integer.parseInt(first) + Integer.parseInt(second);
				if (part == i) {
					sb.append(i).append(" ");
				}
			}
		}

		if (sb.toString().equals("")) {
			System.out.print("INVALID RANGE");
		} else {
			System.out.print(sb.toString());
		}
	}

	public static void main(String[] args) {
		List<int[]> testCase = new ArrayList();
//		testCase.add(new int[] { 1, 100 });
//		testCase.add(new int[] { 400, 700 });
		testCase.add(new int[] { 1, 99999 });

		for (int[] tc : testCase) {
			kaprekarNumbers(tc[0], tc[1]);
		}
	}

}
