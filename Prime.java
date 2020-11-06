public abstract class Prime implements Runnable {

    private String label;
    private int starts;
    private int condition;
    private int increases;

    protected Prime(String label, int starts, int condition, int increases) {
        this.label = label;
        this.starts = starts;
        this.condition = condition;
        this.increases = increases;
    }

    protected abstract boolean Algorithm(int n);

    @Override
    public void run() {
        long t = 0;
        for (int starts = this.starts; starts <= this.condition; starts += this.increases) {
            long startTime = System.currentTimeMillis();

            int k = 1;
            for (int i = 3; i < starts; i += 2)
                if (this.Algorithm(i))
                    k++;

            long time = System.currentTimeMillis() - startTime;
            if (t == 0)
                t = time;

            System.out.println(
                    this.label + " 2 ~ " + starts + ": 有 " + k + " 個質數，共使用 " + time + " 毫秒，成長倍數 " + (double) time / t);
        }
    }

    public static void eratosthenes(int p[]) {
        for (int i = 0; i < p.length; i++)
            p[i] = 1;

        int v = (int) Math.sqrt(p.length);
        for (int i = 2; i <= v; i++) {
            int k = i + 1;

            if (p[i] == 0)
                continue;

            while (k < p.length) {
                p[k] = 0;
                k += i;
            }
        }
    }

}
