package studyWithGPT;

public class Day8 {
    static class Dog {
        void eat() {
            System.out.println("2) eat 시작");
            System.out.println("3) eat 끝");
        }
    }

    public static void main(String[] args) {
        System.out.println("1) main 시작");
        Dog d = new Dog();
        d.eat();
        System.out.println("4) main 끝");
    }
}

