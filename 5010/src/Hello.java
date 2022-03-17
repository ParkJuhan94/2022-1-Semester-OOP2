
class Speaker{
    public void Speak(){
        System.out.println("Hello world!!!");
    }
}

public class Hello {
    public static void main(String [] arg){
         Speaker s;
         s = new Speaker();    s.Speak();
    }
}