import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class TaxInspection {
    LongAdder longAdder = new LongAdder();
    AtomicLong atomicLong = new AtomicLong();
    Random random = new Random();

    public void diffLongArray(int size, int maxIncome) {
        long[] money = new long[size];

        for (long j : money) {
            j = random.nextLong(maxIncome);
            longAdder.add(j);
        }

        long current = longAdder.sum();
        System.out.printf("Выручка %s составила %d евро\n", Thread.currentThread().getName(),
                current);
        long totalCurrent = atomicLong.addAndGet(current);
        System.out.println("Итого: " + totalCurrent);
    }

    public long getCurrent() {
        return atomicLong.get();
    }
}
