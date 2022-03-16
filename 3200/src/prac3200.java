import java.util.Scanner;

public class prac3200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		String allLine = "";
		int sum = 0;		
		int i = 0;			
		
		while(sc.hasNext()) {
			if(i == 0) {
				allLine = sc.nextLine();
			}else {
				allLine = allLine + "\n" + sc.nextLine();	
			}				
			i++;
		}				
		// System.out.println(allLine);		
		
		Scanner sc1 = new Scanner(allLine);
		String firstLine = sc1.nextLine();		
		// System.out.println(firstLine);		
		
		Scanner sc2 = new Scanner(firstLine);		
		
		while(sc2.hasNext()) {
			sum += sc2.nextInt();				
		}
		System.out.println(sum);		
	}
}
