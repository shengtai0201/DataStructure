public class Prime3 extends Prime {

    public Prime3(String label, int starts, int condition, int increases) {
        super(label, starts, condition, increases);
    }

    @Override
    protected boolean Algorithm(int n) {
        boolean isPrime = true;

        if (n % 2 == 0 && n > 2)
            return false;

        int v = (int) Math.sqrt(n);
        for (int i = 3; i <= v; i += 2)
            if (n % i == 0) {
                isPrime = false;
                break;
            }

        return isPrime;
    }

}
