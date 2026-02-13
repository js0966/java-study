package studyWithGPT;

public class Day3 {

    static class Logger {
        void log(String message) {
            System.out.println(message);
        }
    }
    static class MemoryLogger extends Logger {
        String history = "";

        @Override
        void log(String message) {
            history = history + message + "\n";
        }
    }
    static class Dog {
        String name;
        int energy;
        Logger logger;

        Dog(String name, int energy, Logger logger) {
            this.name = name;
            this.energy = energy;
            this.logger = logger;
            logger.log("[Dog] " + name + " 태어남 / energy=" + energy);
        }

        void eat() {
            energy = energy + 2;
            logger.log("[Dog] " + name + " 먹기(+2) / energy=" + energy);
        }

        void bark() {
            if (energy == 0) {
                logger.log("[Dog] " + name + " 짖기 실패(0) / energy=" + energy);
                return;
            }
            energy = energy - 1;
            logger.log("[Dog] " + name + " 짖기(-1) / energy=" + energy);
        }

        void routine() {
            bark();
            eat();
            bark();
        }
    }

    public static void main(String[] args) {
        MemoryLogger logger = new MemoryLogger();
        Dog coco = new Dog("coco", 1, logger);
        coco.routine();

        // "나중에 한 번에 출력" (파일을 열어보는 느낌)
        System.out.println("=== 저장된 로그 ===");
        System.out.println(logger.history);
    }
}
