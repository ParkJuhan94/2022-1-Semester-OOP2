
class Card{
	public static String[] suitNames = {"♠", "♥", "◆", "♣"};
	public static String[] rankNames = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	private int suit = 0;
	private int rank = 0;
	
	public void setSuit(int n) {
		this.suit = n;
	}
	
	public void setRank(int n) {
		this.rank = n;
	}
	
	public void print() {
		System.out.println(suitNames[suit] + rankNames[rank]);
	}
}

public class CardApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card[] myCard = new Card[52];
		
		for(int i = 0 ; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				myCard[i*13 + j] = new Card();
				myCard[i*13 + j].setSuit(i);
				myCard[i*13 + j].setRank(j);
				myCard[i*13 + j].print();
			}
		}
	}

}
