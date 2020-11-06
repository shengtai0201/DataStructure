public class Prime2 extends Prime {

    public Prime2(String label, int starts, int condition, int increases) {
        super(label, starts, condition, increases);
    }

    @Override
    protected boolean Algorithm(int n) {
        boolean isPrime = true;

        if (n % 2 == 0 && n > 2)
            return false;

        for (int i = 3; i < n; i += 2)
            if (n % i == 0) {
                isPrime = false;
                break;
            }

        return isPrime;
    }

}
