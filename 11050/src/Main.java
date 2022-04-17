import java.util.Scanner;

public class Main {	
	//Target[] mytanklist = new Tank[20];
	//Target[] mysoldierlist = new Soldier[20];
	Target[] mytargetlist = new Target[40];
	//int numTank = 0;
	//int numSoldier = 0;
	int numTarget = 0;
	
	public void run() {
		//mytanklist[numTank++] = new Tank(10,10);
		//mytanklist[numTank++] = new Tank(20,20);
		//mysoldierlist[numSoldier++] = new Soldier(5, 5);
		//mysoldierlist[numSoldier++] =new Soldier(3, 3);
		mytargetlist[numTarget++] = new Tank(10,10);
		mytargetlist[numTarget++] = new Tank(20,20);
		mytargetlist[numTarget++] = new Soldier(5,5);
		mytargetlist[numTarget++] = new Soldier(3,3);
		
		Scanner s = new Scanner(System.in);
		while (s.hasNextInt()) {
			int x = s.nextInt();
			if (s.hasNext()) {
				int y = s.nextInt();
				for (int i=0; i<numTarget; i++){
					if (mytargetlist[i].areYouThere(x, y))
						mytargetlist[i].damage(10);
				}				
			} else break;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.run();
	}

}
