package studyWithGPT;

public class Day9 {

    static class Dog {
        int energy = 1;

        void eat() {
            System.out.println("  eat: before energy=" + energy);
            energy = energy + 1;
            System.out.println("  eat: after  energy=" + energy);
        }
    }

    static void addOne(int x) {
        System.out.println("  addOne: before x=" + x);
        x = x + 1;
        System.out.println("  addOne: after  x=" + x);
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        int n = 1;

        System.out.println("main: start d.energy=" + d.energy + ", n=" + n);

        d.eat();
        addOne(n);

        System.out.println("main: end   d.energy=" + d.energy + ", n=" + n);
    }
}
