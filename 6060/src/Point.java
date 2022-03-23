import java.util.Scanner;

public class Point {

	private int x_, y_;
	
	public Point(int x, int y) {
		x_ = x;
		y_ = y;
	}
	
	public static void printDist(Point a, Point b) {
		double d;
		int xd, yd;
		
		yd = (int) Math.pow((a.x_ - b.x_),2);
		xd = (int) Math.pow((a.y_ - b.y_),2);
		d = Math.sqrt(yd+xd);
		
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x1,y1,x2,y2;
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		
		Point a = new Point(x1, y1);
		Point b = new Point(x2, y2);
	
		printDist(a, b);
	}

}
