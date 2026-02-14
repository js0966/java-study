package studyWithGPT;

// Day10.java
public class Day10 {

    // 1) "상태"만 가진 아주 작은 객체
    static class Counter {
        private int minutes;

        Counter(int minutes) { this.minutes = minutes; }

        void inc() { minutes++; }

        int get() { return minutes; }

        Counter copy() {            // 분기(copy): 새 객체 생성
            return new Counter(this.minutes);
        }
    }

    // 2) Logger는 "역할(인터페이스)"만 노출
    interface Logger {
        void log(String msg);
        void flush();

        // main이 구체 클래스(MemoryLogger)를 덜 알게 만드는 작은 패치
        static Logger create() { return new MemoryLogger(); }
    }

    static class MemoryLogger implements Logger {
        private final StringBuilder buf = new StringBuilder();
        public void log(String msg) { buf.append(msg).append("\n"); }
        public void flush() { System.out.print(buf); }
    }

    public static void main(String[] args) {
        Logger logger = Logger.create();

        Counter base = new Counter(0);

        Counter alias = base;
        Counter branched = base.copy(); // 분기(copy): 다른 객체

        logger.log("base id     = " + System.identityHashCode(base));
        logger.log("alias id    = " + System.identityHashCode(alias));
        logger.log("branched id = " + System.identityHashCode(branched));

        alias.inc(); // alias로 증가시키면 base도 같이 바뀜(같은 객체니까)
        logger.log("[after alias.inc] base=" + base.get() + ", branched=" + branched.get());

        branched.inc(); // branched는 다른 객체라 base에 영향 없음
        logger.log("[after branched.inc] base=" + base.get() + ", branched=" + branched.get());

        logger.flush();
    }
}
