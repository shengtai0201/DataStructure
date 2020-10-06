import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("第一章：導論與測試範例")
public class Chapter1Tests {
    @BeforeAll
    static void initAll() {
        System.out.println("初始化資料");
    }

    @BeforeEach
    void init() {
        System.out.println("當前測試方法開始");
    }

    @DisplayName("判斷質數")
    @ParameterizedTest(name = "{0} 是質數")
    // @ValueSource(ints = { -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    @ValueSource(ints = { 2, 3, 5, 7 })
    void testPrimeNumber(int value) {
        boolean condition = true;

        if (value > 1) {
            int i = 2;
            while (i < value) {
                if (value % i == 0) {
                    condition = false;
                    break;
                } else {
                    i++;
                }
            }
        } else
            condition = false;

        System.out.printf("%d, %b\n", value, condition);
        assertTrue(condition);
    }

    @AfterEach
    void tearDown() {
        System.out.println("當前測試方法結束");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("清理資料");
    }
}
