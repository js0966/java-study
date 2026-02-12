package toy.randomNumber;

import java.util.Scanner;
import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int answer = rand.nextInt(100) + 1;
        int guess = 0;

        while (guess != answer) {
            System.out.print("숫자 입력: ");
            guess = sc.nextInt();

            if (guess > answer) {
                System.out.println("Down!");
            } else if (guess < answer) {
                System.out.println("Up!");
            } else {
                System.out.println("정답!");
            }
        }
    }
}
