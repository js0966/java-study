package studyWithGPT;

// Day11.java
public class Day11 {

    static class Counter {
        private int minutes;
        Counter(int minutes) { this.minutes = minutes; }
        void add(int delta) { minutes += delta; }
        int get() { return minutes; }
    }

    interface Policy {
        int step(int i); // i번째 턴에 몇 분 올릴지
        static Policy of(int a, int b) { return new LinearPolicy(a, b); } // create 숨김
    }

    static class LinearPolicy implements Policy {
        private final int a, b;
        LinearPolicy(int a, int b) { this.a = a; this.b = b; }
        public int step(int i) { return a * i + b; } // (2,1)이면 3,5,7...
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
            counter = new Counter(999);
            logger.log("after reassign, minutes=" + counter.get());

            for (int i = 1; i <= turns; i++) {
                int step = policy.step(i);
                counter.add(step); // <-- 참조 전달로 공유된 counter를 변경
                logger.log("i=" + i + ", step=" + step + ", minutes=" + counter.get());
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter(0);
        Policy policy = Policy.of(5, 2);  // main은 구체 클래스 이름을 모름
        Logger logger = Logger.create();

        new Simulator().run(3, counter, policy, logger);

        System.out.println("main sees minutes=" + counter.get());
        logger.flush();
    }
}
