package studyWithGPT;

// Day12.java
public class Day12 {

    static class Counter {
        private int minutes;
        Counter(int minutes) { this.minutes = minutes; }
        void add(int delta) { minutes += delta; }
        int get() { return minutes; }
    }

    interface Policy {
        int step(int i);

        static Policy from(String name) {
            if ("easy".equalsIgnoreCase(name)) return easy();
            if ("hard".equalsIgnoreCase(name)) return hard();
            return easy(); // 기본값
        }

        // "숫자"를 숨기는 프리셋 (main은 의미로 고른다)
        static Policy easy() { return new LinearPolicy(2, 1); }
        static Policy hard() { return new LinearPolicy(5, 2); }
    }

    static class LinearPolicy implements Policy {
        private final int a, b;
        LinearPolicy(int a, int b) { this.a = a; this.b = b; }
        public int step(int i) { return a * i + b; }
    }

    interface Logger {
        void log(String msg);
        void flush();
        static Logger create() { return new MemoryLogger(); }
    }

    static class MemoryLogger implements Logger {
        private final StringBuilder buf = new StringBuilder();
        public void log(String msg) { buf.append(msg).append("\n"); }
        public void flush() { System.out.print(buf); }
    }

    static class Simulator {
        void run(int turns, Counter counter, Policy policy, Logger logger) {
            logger.log("counter id=" + System.identityHashCode(counter));
            for (int i = 1; i <= turns; i++) {
                int step = policy.step(i);
                counter.add(step);
                logger.log("i=" + i + ", step=" + step + ", minutes=" + counter.get());
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        Logger logger = Logger.create();

        Policy policy = Policy.from("easy"); // 나중에 입력으로 바뀔 자리
        // <-- 오늘 타이핑: easy()로 바꿔서 2번 실행
        new Simulator().run(3, counter, policy, logger);

        System.out.println("main sees minutes=" + counter.get());
        logger.flush();
    }
}
