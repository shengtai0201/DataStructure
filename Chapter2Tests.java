import org.junit.jupiter.api.*;
import java.util.Random;

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

    private int[] RndSort() {
        Random rnd = new Random();

        final int n = 42;
        int idx[] = new int[n];
        int loto[] = new int[6];

        for (int i = 0; i < n; i++)
            idx[i] = 0;

        for (int i = 0; i < 6; i++) {
            int k;

            do {
                k = rnd.nextInt(n);
            } while (idx[k] == 1);

            idx[k] = 1;
        }

        for (int i = 0, j = 0; i < n; i++)
            if (idx[i] == 1)
                loto[j++] = i + 1;

        return loto;
    }

    @DisplayName("產生樂透號碼")
    @Test
    void test5() {
        int loto[] = this.RndSort();

        for (int i = 0; i < loto.length; i++)
            System.out.print(loto[i] + "\t");
    }

    private int[][] magicSquare(int n) {
        int magic[][] = new int[n][n];

        int k = 1, row = 0, column = n / 2;
        while (k <= n * n) {
            magic[row][column] = k++;

            int r = (row + n - 1) % n;
            int c = (column + 1) % n;
            if (magic[r][c] == 0) {
                row = r;
                column = c;
            } else
                row++;
        }

        return magic;
    }

    @DisplayName("魔術方陣")
    @Test
    void test6() {
        int magic[][] = this.magicSquare(7);

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++)
                System.out.print(magic[i][j] + "\t");

            System.out.println();
        }

    }
}
