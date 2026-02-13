package studyWithGPT;

public class Day6 {

    static class Dog {
        int energy = 1;

        void eat() {
            System.out.println("eat() 안: energy(before)=" + energy);
            energy = energy + 1;
            System.out.println("eat() 안: energy(after)=" + energy);
        }
    }

    public static void main(String[] args) {
        Dog d1 = new Dog();
        System.out.println("main: energy(before)=" + d1.energy);

        d1.eat();

        System.out.println("main: energy(after)=" + d1.energy);
    }
}
