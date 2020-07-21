package practice.algorithms.Implementation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.hackerrank.com/challenges/taum-and-bday/problem

public class TaumNBday {

	public static BigInteger taumBday(int b, int w, int bc, int wc, int z) {
		BigInteger minCost = BigInteger.ZERO;
		BigInteger _b = new BigInteger(String.valueOf(b));
		BigInteger _w = new BigInteger(String.valueOf(w));
		BigInteger _bc = new BigInteger(String.valueOf(bc));
		BigInteger _wc = new BigInteger(String.valueOf(wc));
		BigInteger _z = new BigInteger(String.valueOf(z));

		List<BigInteger> sumList = new ArrayList<BigInteger>();
		BigInteger sum1 = (_b.multiply(_bc)).add(_w.multiply(_wc)); // (b * bc) + (w * wc)
		BigInteger sum2 = (_b.multiply(_bc)).add(_w.multiply(_bc.add(_z))); // (b * bc) + (w * (bc + z))
		BigInteger sum3 = (_b.multiply(_wc.add(_z))).add((_w).multiply(_wc));// (b * (wc + z)) + (w * wc)

		sumList.add(sum1);
		sumList.add(sum2);
		sumList.add(sum3);

		minCost = Collections.min(sumList);

		return minCost;
	}

	public static void main(String[] args) {
		List<TestCase> tcList = new ArrayList<TestCase>();
//		tcList.add(new TestCase(new int[] { 10, 10 }, new int[] { 1, 1, 1 })); // 20
//		tcList.add(new TestCase(new int[] { 5, 9 }, new int[] { 2, 3, 4 })); // 37
//		tcList.add(new TestCase(new int[] { 3, 6 }, new int[] { 9, 1, 1 })); // 12
//		tcList.add(new TestCase(new int[] { 7, 7 }, new int[] { 4, 2, 1 })); // 35
//		tcList.add(new TestCase(new int[] { 3, 3 }, new int[] { 1, 9, 2 })); // 12
		tcList.add(new TestCase(new int[] { 27984, 1402 }, new int[] { 619246, 615589, 247954 })); // 18192035842

		for (TestCase tc : tcList) {
			int b = tc.first[0];
			int w = tc.first[1];

			int bc = tc.next[0];
			int wc = tc.next[1];
			int z = tc.next[2];

			BigInteger result = taumBday(b, w, bc, wc, z);
			System.out.println("RESULT: " + result);
		}
	}

	public static class TestCase {
		int[] first;
		int[] next;

		TestCase(int[] first, int next[]) {
			this.first = first;
			this.next = next;
		}
	}
}
