public class Solution {

	public static void test(int n, int[][] trust) {
		TrustTracker t = new TrustTracker(n);

		for (int[] trustVal : trust)
			t.aTrustsB(trustVal);

		System.out.println(t.getJudge());
	}

	public static void main(String[] args) {
		test(2, new int[][] { {1, 2} });
		test(3, new int[][] { {1, 3}, {2, 3} });
		test(3, new int[][] { {1, 3}, {2, 3}, {3, 1} });
		test(3, new int[][] { {1, 2}, {2, 3} });
		test(4, new int[][] { {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3} });
	}
}