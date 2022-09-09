public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaxInspection taxInspection = new TaxInspection();
        int size = 100;
        int maxIncome = 1000;

        Thread shop1 = new Thread(null, () -> taxInspection.diffLongArray(size, maxIncome), "Магаз 1");
        Thread shop2 = new Thread(null, () -> taxInspection.diffLongArray(size, maxIncome), "Магаз 2");
        Thread shop3 = new Thread(null, () -> taxInspection.diffLongArray(size, maxIncome), "Магаз 3");

        shop1.start();
        shop2.start();
        shop3.start();

        shop3.join();
        shop2.join();
        shop1.join();

        System.out.println("Полный итого: " + taxInspection.getCurrent());
    }
}
