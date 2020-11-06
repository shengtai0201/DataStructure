import org.junit.jupiter.api.*;

@DisplayName("第一章：陣列")
public class Chapter2Tests {

    private void show(int a[]) {
        for (int i : a)
            System.out.print(" " + i);

        System.out.print("\n");
    }

    private void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int m = i;

            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[m])
                    m = j;

            int t = a[i];
            a[i] = a[m];
            a[m] = t;
        }
    }

    @DisplayName("選擇排序 O(n^2)")
    @Test
    void test1() {
        int a[] = new int[] { 50, 40, 35, 90, 72, 51, 85, 43 };

        this.show(a);
        this.selectionSort(a);
        this.show(a);
    }

    private int binSearch(int a[], int x) {
        int lo = 0, hi = a.length - 1;

        while (lo <= hi) {
            int mi = (lo + hi) / 2;

            if (a[mi] == x)
                return mi;
            else if (x < a[mi])
                hi = mi - 1;
            else
                lo = mi + 1;
        }

        return -1;
    }

    @DisplayName("二分搜尋法")
    @Test
    void test2() {
        int a[] = new int[] { 5, 12, 21, 35, 37, 52, 61 };

        int index = this.binSearch(a, 21);
        System.out.println(index);
    }

    @DisplayName("質數篩選法")
    @Test
    void test3() {
        int p[] = new int[75];

        this.show(p);
        Prime.eratosthenes(p);
        this.show(p);
    }

    private void merge(int a[], int b[], int c[]) {
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];

        while (i < a.length)
            c[k++] = a[i++];

        while (j < b.length)
            c[k++] = b[j++];
    }

    @DisplayName("陣列合併")
    @Test
    void test4() {
        int a[] = new int[] { 1, 12, 15, 25, 30, 32, 45, 60 };
        int b[] = new int[] { 4, 14, 16, 20, 35, 47, 55, 62 };
        int c[] = new int[16];

        this.merge(a, b, c);
        this.show(c);
    }
}
