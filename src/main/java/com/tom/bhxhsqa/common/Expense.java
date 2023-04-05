package com.tom.bhxhsqa.common;

import java.util.List;

public class Expense {
    public static Double tinhPhiBaoHiemCaNhan(Long luong) {
        if ( luong < 1500000) {
            return 0.0;
        } else {
            return luong * 0.22;
        }
    }

    public static Double tinhPhiBaoHiemDN(Long luong) {
        if ( luong <= 0) {
            return 0.0;
        } else {
            return luong * 0.32;
        }
    }
}