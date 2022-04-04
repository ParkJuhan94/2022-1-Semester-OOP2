class Main{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack myStack = new Stack();
		myStack.add(11);
		myStack.add(22);
		myStack.add(33);
		
		try {
			myStack.addLast(44);  // Override 하고 예외를 던지게 한다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (!myStack.isEmpty()) {
			System.out.println(myStack.peek());
			myStack.pop();
		}
	}	
}