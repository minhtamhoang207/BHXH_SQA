package com.tom.bhxhsqa.function;

import com.tom.bhxhsqa.common.Expense;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTinhBaoHiemCaNhan {

    private static Stream<Arguments> getTestCases() {
        List<Arguments> args = new ArrayList<>();

        args.add(Arguments.of(-10000L, 0.0));

        args.add(Arguments.of(1400000L, 0.0));

        args.add(Arguments.of(1500000L, 330000.0));

        args.add(Arguments.of(1500001L, 330000.22000000003));

        args.add(Arguments.of(33300000L, 6556000.0));
        return args.stream();
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    public void testcases(Long i, Double expected) {
        Double actual = Expense.tinhPhiBaoHiemCaNhan(i);
        assertEquals(expected, actual);
    }
}
