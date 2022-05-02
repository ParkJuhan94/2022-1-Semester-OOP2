public class MapTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCorrect = 0;
		long t0 = System.currentTimeMillis();
		Map<Integer, String> goodMap = new HashMap<>();
		for (int i=0; i<10000; i+= 2) {
			goodMap.put(i, "Value"+i);
		}
		for (int i=0; i<9999; i++) {
			int k = (int)(Math.random() * 10000);
			String val = goodMap.get(k);
			if (k%2 == 0 && val!=null || k%2 !=0 && val==null) {
				numCorrect++;
			} 
		}
		System.out.println("Hashmap:\n정확한 회수: " + numCorrect);
		System.out.println("저장된 쌍의 수: " + goodMap.size());
		long t1 = System.currentTimeMillis();
		
		System.out.println("소요시간(ms) = " + (t1-t0));
		
		numCorrect = 0;
		long t2 = System.currentTimeMillis();
		MyMap<Integer, String> badMap = new MyMap<>();
		for (int i=0; i<10000; i+= 2) {
			badMap.put(i, "Value"+i);
		}
		for (int i=0; i<9999; i++) {
			int k = (int)(Math.random() * 10000);
			String val = badMap.get(k);
			if (k%2 == 0 && val!=null || k%2 !=0 && val==null) {
				numCorrect++;
			} else {
				System.out.println("Incorrect " + k + "/" + val);
			}
		}
		System.out.println("\nMyMap:\n정확한 회수: " + numCorrect);
		System.out.println("저장된 쌍의 수: " + badMap.size());
		long t3 = System.currentTimeMillis();
		
		System.out.println("소요시간(ms) = " + (t3-t2));
	
	}

}
