package com.tom.bhxhsqa.common;

import java.util.List;

public class Expense {
    public static Double tinhPhiBaoHiemCaNhan(Long luong) {
        if ( luong < 1500000 ) {
            return 0.0; // muc dong BH thap nhat la 1,500,000
        } else if ((luong > (1490000 * 20))) {
            // cao nhat la 20 lan luong co so ( 1,490,000 )
            return 6556000.0;
        } else {
            return luong * 0.22;
        }
    }

    public static Double tinhPhiBaoHiemDN(Long luong) {
        if ( luong <= 4680000) { //muc luong toi thieu vung
            return 0.0;
        } else {
            return luong * 0.32;
        }
    }
}