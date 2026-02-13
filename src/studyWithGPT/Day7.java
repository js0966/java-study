package studyWithGPT;

public class Day7 {
    static class Dog {
        int energy = 1;
        void eat() { energy = energy + 1; }
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();   // energy=1
        Dog d2 = d1;          // 같은 객체 공유

        d2.eat();             // eat() 호출 -> 그 객체 energy가 1 증가

        System.out.println(d1.energy);
    }
}
