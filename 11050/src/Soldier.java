public class Soldier extends Target{

	public Soldier(int x, int y) {
		super(x, y);
		health_ = 5;
	}
	
	@Override
	public boolean areYouThere(int x, int y) {
		if ( x_ == x && y_ == y) {
			System.out.println("Soldier here.");
			return true;
		}
		return false;
	}

	@Override
	public void damage(int dm) {
		health_ -= dm;
		if (health_ < 0) {
			System.out.println("Soldier dead.");
		} else {
			System.out.println("Remaining health: "  + health_);
		}
	}
}
