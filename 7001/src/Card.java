public class Card {
	public static final String[] suitname = { "♠", "♥", "◆", "♣" };
	public static final String[] rankname = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public void draw() {
		System.out.println(suitname[suit] + rankname[rank]);
	}

	public void setRank(int n) throws Exception {

		if (n < 0 || n > 12) {
			throw (new Exception("rank 오류"));
		} else {
			rank = n;
		}
	}

	public void setSuit(int n) throws Exception {
		if (n < 0 || n > 3) {
			throw (new Exception("suit 오류"));
		} else {
			suit = n;
		}
	}

	// 멤버 데이터
	private int suit, rank;
}
