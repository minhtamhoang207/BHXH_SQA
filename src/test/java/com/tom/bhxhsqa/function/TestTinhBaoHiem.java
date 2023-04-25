package com.tom.bhxhsqa.function;

import com.tom.bhxhsqa.common.Expense;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTinhBaoHiem {

    private static Stream<Arguments> getTestCases() {
        List<Arguments> args = new ArrayList<>();

        args.add(Arguments.of(-10000L, 0.0));
        args.add(Arguments.of(1500001L, 330000.0));

        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    public void testcase1(Long i, Double expected) {
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 1500000
    public void testcase2() {
        long i = 1500000;
        Double expected = 330000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 1500001
    public void testcase3() {
        long i = 1500001;
        Double expected = 330000.22000000003;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 33300000
    public void testcase4() {
        long i = 33300000;
        Double expected = 6556000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 29800000
    public void testcase5() {
        long i = 29800000;
        Double expected = 6556000.0;
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }


    // Test tinh phi BH doanh nghiep
    @Test
    //Test tính bảo hiểm user có lương = -10000
    public void testcase6() {
        long i = -10000;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 0
    public void testcase7() {
        long i = 0;
        Double expected = 0.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 6500000
    public void testcase8() {
        long i = 6500000;
        Double expected = 2080000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }

    @Test
    //Test tính bảo hiểm user có lương = 11000000
    public void testcase9() {
        long i = 11000000;
        Double expected = 3520000.0;
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }
}
