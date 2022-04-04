class Rect {
	protected int width_;
	protected int height_;
	public void setSize(int w, int h) {
		width_ = w;
		height_ = h; 
	}
	void show() {
		System.out.println("Size:"+width_ + "X" + height_);
	}
}

class Square extends Rect{
	public void setSize(int w, int h) {
		if(w != h) {
			return;
		}else {
			width_ = w;
			height_ = h; 
		}
	}
}