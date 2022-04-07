
public class Tank extends Target{

		public Tank(int x, int y) {
			super(x, y);
			health_ = 10;
		}
		
		@Override
		public boolean areYouThere(int x, int y) {
			if ( x_-2 <= x && x <= x_ + 2
					&& y_-2 <= y && y <= y_+2) {
				System.out.println("Tank here.");
				return true;
			}
			return false;
		}
		
		@Override
		public void damage(int dm) {
			health_ -= dm;
			if (health_ < 0) {
				System.out.println("Tank destoyed");
			} else {
				System.out.println("Remaining health: "  + health_);
			}

	}
}
