package studyWithGPT;

public class Day1 {

    static class Dog {
        int energy = 1;
        void eat() { energy = energy + 1; }
    }

    public static void main(String[] args) {
        // 1) 객체: 참조 복사
        Dog d1 = new Dog();
        Dog d2 = d1;      // 같은 객체를 가리킴
        d1.eat();
        d2.eat();

        System.out.println("객체: d1.energy=" + d1.energy);
        System.out.println("객체: d2.energy=" + d2.energy);

        // 2) 기본형: 값 복사
        int a = 1;
        int b = a;        // 값 복사
        a = 2;

        System.out.println("기본형: a=" + a);
        System.out.println("기본형: b=" + b);
    }
}