class Figure{
    public void show(){
        System.out.println("Figure 입니다.");
    }
}
class Rect extends Figure{
    @Override public void show(){
        System.out.println("사각형 입니다.");
    }
}
class Oval extends Figure{
    @Override public void show(){
        System.out.println("타원형 입니다.");
    }
}

//이런 클래스들을 이용하되 main에서는 사각형 두개 타원 두개를 집어넣은 후
//모든 도형에 대해 show()를 실행하여보라.