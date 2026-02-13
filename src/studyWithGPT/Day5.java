package studyWithGPT;

public class Day5 {

    static class Dog {
        int energy = 1;
        void eat() { energy = energy + 1; }
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog d2 = d1;      // 참조(주소표) 복사 -> 같은 힙 객체를 가리킴

        d1.eat();

        System.out.println("d1.energy=" + d1.energy);
        System.out.println("d2.energy=" + d2.energy);

        // 공유 끊기
        Dog d3 = new Dog();
        d3.eat();

        System.out.println("d3.energy=" + d3.energy);
    }
}
