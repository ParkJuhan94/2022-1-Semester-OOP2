
public abstract class Target {
	protected int x_, y_; // position
	protected int health_;
	
	public Target(int x, int y) {
		x_ = x; y_ = y;
	}
	
	public abstract boolean areYouThere(int x, int y);
	public abstract void damage(int dm);
	
}
