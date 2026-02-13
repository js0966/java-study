package studyWithGPT;

public class Day2 {
    static class Dog {
        // 상태(state)
        String name;
        int energy;

        static final int EAT_GAIN = 2;
        static final int BARK_COST = 1;

        // 생성자(constructor): "처음 상태"를 여기서 결정
        Dog(String name, int energy) {
            this.name = name;
            this.energy = energy;
            log("태어남");
        }

        // 행동(behavior)
        void eat() {
            energy = energy + EAT_GAIN;
            log("먹기(+2)");
        }

        void bark() {
            if (energy == 0) {
                log("짖기 실패(에너지 0)");
                return;
            }
            energy = energy - BARK_COST;
            log("짖기(-1)");
        }


        // 로그(상태 변화가 눈에 보이게)
        void log(String action) {
            System.out.println("[Dog] " + name + " / " + action + " / energy=" + energy);
        }

        void routine() {
            bark();
            eat();
            bark();
        }

    }

    public static void main(String[] args) {
        Dog coco = new Dog("coco", 1);
        coco.routine();
    }

}

