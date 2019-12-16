/* 
	Keeps track of trust scores for all n people and who is most likely the judge at the moment.
	After traversing the array once, judge will hold the index of the actual judge

	Trust score for person a is defined as:
		(# of people who trust a) - (# of people a trusts)

	Therefore, only a person who holds a trust score of n-1 is the judge.

*/

public class TrustTracker {

	// Scores the score that the judge should have
	private int judgeScore;

	// Stores trust scores for all n people
	private int[] trustScores;

	// Stores which person has a trust score of 99 at the time
	// Because getJudge() returns index + 1, must make default index -2
	// to print -1 in the end
	private int judge = -2;

	public TrustTracker(int n) {
		this.judgeScore = n-1;
		this.trustScores = new int[n];
	}

	public void aTrustsB(int[] trusts) {
		int a = trusts[0] - 1;
		int b = trusts[1] - 1;
		
		// If a has the judge's score and then trusts someone, they are no longer the judge
		if (trustScores[a] == judgeScore)
			judge = -2;

		trustScores[a]--;
		trustScores[b]++;

		// If after being trusted, b has the judge's score, they are the judge
		if (trustScores[b] == judgeScore)
			judge = b;
	}

	public int getJudge() {
		return this.judge + 1;
	}
}