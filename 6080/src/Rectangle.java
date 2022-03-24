import java.util.Scanner;

class Point{
	private int x_, y_;
	
	public Point(int x, int y) {
		x_ = x;
		y_ = y;
	}
	
	public int getX() {
		return x_;
	}
	
	public int getY() {
		return y_;
	}
}

public class Rectangle {
	private int x1_,y1_,x2_,y2_;
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		x1_ = x1;
		y1_ = y1;
		x2_ = x2;
		y2_ = y2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int x1, y1, x2, y2;
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		
		Rectangle r = new Rectangle(x1, y1, x2, y2);		
		
		int tempx, tempy;
		while(sc.hasNextInt()) {
			Point p = new Point(sc.nextInt(), sc.nextInt());
			
			if(x1 <= p.getX() && p.getX() <= x2 && y1 <= p.getY() && p.getY() <= y2) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
		System.out.println("END");
		
	}

}
