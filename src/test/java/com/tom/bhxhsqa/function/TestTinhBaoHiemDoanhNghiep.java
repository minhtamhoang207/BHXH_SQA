package com.tom.bhxhsqa.function;

import com.tom.bhxhsqa.common.Expense;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTinhBaoHiemDoanhNghiep {

    private static Stream<Arguments> getTestCases() {
        List<Arguments> args = new ArrayList<>();

        args.add(Arguments.of(-100000L, 0.0));

        args.add(Arguments.of(0L, 0.0));

        args.add(Arguments.of(6500000L, 2080000.0));

        args.add(Arguments.of(11000000L, 3520000.0));

        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    public void testcases(Long i, Double expected) {
        Double actual = Expense.tinhPhiBaoHiemDN(i);
        assertEquals(expected, actual);
    }
}
