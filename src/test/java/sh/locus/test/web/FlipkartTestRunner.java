package sh.locus.test.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlipkartTestRunner {

    @BeforeEach
    void setUp() {
        System.out.println("setup");
    }

    @Test
    void test1() {
        System.out.println("testing-1");
    }

    @Test
    void test2() {
        System.out.println("testing-1");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }
}