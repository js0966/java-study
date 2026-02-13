package studyWithGPT;

public class Day4 {

    interface Logger {
        void log(String message);
    }

    static class ConsoleLogger implements Logger {
        public void log(String message) {
            System.out.println(message);
        }
    }

    static class MemoryLogger implements Logger {
        String history = "";

        public void log(String message) {
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
        // 1) 메모리에 쌓기
        MemoryLogger mem = new MemoryLogger();

        // Dog는 Logger만 알면 됨 (MemoryLogger든 ConsoleLogger든 상관없음)
        Dog coco = new Dog("coco", 1, new ConsoleLogger());

        coco.routine();

        System.out.println("=== 저장된 로그 ===");
        System.out.println(mem.history);

        // 2) 콘솔로 바로 찍고 싶으면: 아래 2줄로 교체 가능
        // Logger logger = new ConsoleLogger();
        // new Dog("coco", 1, logger).routine();
    }
}

