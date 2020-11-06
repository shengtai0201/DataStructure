public class Prime1 extends Prime {

    public Prime1(String label, int starts, int condition, int increases) {
        super(label, starts, condition, increases);
    }

    @Override
    protected boolean Algorithm(int n) {
        boolean isPrime = true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
