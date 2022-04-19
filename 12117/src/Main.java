class Book {
	public String title, isbn, author;
	Printer p;
	public Book(String t, String i, String a) {
		this.title = t;
		this.isbn = i;
		this.author = a;
	}
	public void print() {
		p.print(this);
	}
	public void setPrinter(SimpleBookPrinter s) {
		this.p = s;
	}
	public void setPrinter(PrettyBookPrinter p) {
		this.p = p;
	}	
}

interface Printer{
	public void print(Book b);
}

class SimpleBookPrinter implements Printer {		
	public void print(Book b) {
		System.out.println(b.title + "/" + b.author + "/" + b.isbn);
	}
		
}

class PrettyBookPrinter implements Printer{	
	public void print(Book b) {
		System.out.println("***** Title : " + b.title);
		System.out.println("***** Author : " + b.author);
		System.out.println("***** ISBN : " + b.isbn);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("Java Book", "111-22-333333", "Jane Austin");
		System.out.println("첫번째 출력:");
		b1.setPrinter(new SimpleBookPrinter());
		b1.print();
		System.out.println("두번째 출력:");
		b1.setPrinter(new PrettyBookPrinter());
		b1.print();
	}

}