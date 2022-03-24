public class Main {
	public static void main(String[] args){
		try {
		Card c1;
		c1 = new Card();
		c1.setSuit(1);
		c1.setRank(11);
		c1.draw();
		c1.setSuit(5);
		c1.setRank(15);
		c1.draw();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
