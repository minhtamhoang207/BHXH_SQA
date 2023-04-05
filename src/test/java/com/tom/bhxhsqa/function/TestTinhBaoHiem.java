package com.tom.bhxhsqa.function;

import com.tom.bhxhsqa.common.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTinhBaoHiem {
    @Test
    public void testTH1() {
        Long i = -10000L;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH2() {
        long i = 1500000;
        Double expected = 330000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH3() {
        long i = 1500001;
        Double expected = 330000.22000000003;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH4() {
        long i = 30000000;
        Double expected = 6600000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }


    // Test tinh phi BH doanh nghiep
    @Test
    public void testTH5() {
        long i = -10000;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH6() {
        long i = 0;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH7() {
        long i = 6500000;
        Double expected = 2080000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    public void testTH8() {
        long i = 11000000;
        Double expected = 3520000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }
}
