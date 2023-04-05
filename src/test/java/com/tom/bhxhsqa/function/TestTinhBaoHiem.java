package com.tom.bhxhsqa.function;

import com.tom.bhxhsqa.common.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTinhBaoHiem {
    @Test
    public void testcase1() {
        Long i = -10000L;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase2() {
        long i = 1500000;
        Double expected = 330000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase3() {
        long i = 1500001;
        Double expected = 330000.22000000003;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase4() {
        long i = 33300000;
        Double expected = 6556000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase5() {
        long i = 29800000;
        Double expected = 6556000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }


    // Test tinh phi BH doanh nghiep
    @Test
    public void testcase6() {
        long i = -10000;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase7() {
        long i = 0;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase8() {
        long i = 6500000;
        Double expected = 2080000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testcase9() {
        long i = 11000000;
        Double expected = 3520000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }
}
