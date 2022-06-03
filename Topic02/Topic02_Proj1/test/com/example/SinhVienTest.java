package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void themDiem() {

    }

    @Test
    void tinhDiemTrungBinh() {
        //Arrangemen
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("ly",3,1),7);
        Diem Diem3 = new Diem(new MonHoc("anh",2,2),8);
        Diem Diem4 = new Diem(new MonHoc("hoa",1,2),9);

        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(Diem1);
        dsDiem.add(Diem2);
        dsDiem.add(Diem3);
        dsDiem.add(Diem4);
        SinhVien sv = new SinhVien("M10","Ha Phong",dsDiem);
       // System.out.println(sv.tinhDiemTrungBinh());

        //Action
        double d = sv.tinhDiemTrungBinh();

        //Assertion
        assertEquals(7.933333333333334,d,0.00001);

    }

    @Test
    void bangDiem() {
        // arrangement
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("ly",3,1),7);
        Diem Diem3 = new Diem(new MonHoc("anh",2,2),8);

        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(Diem1);
        dsDiem.add(Diem2);
        dsDiem.add(Diem3);
        SinhVien sv = new SinhVien("M10","Ha Phong",dsDiem);

        System.out.println(sv.bangDiem());
    }

    @Test
    void xepLoai() {
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("ly",3,1),10);
        Diem Diem3 = new Diem(new MonHoc("anh",2,2),8);

        Set<Diem> dsDiem = new HashSet<>();
        dsDiem.add(Diem1);
        dsDiem.add(Diem2);
        dsDiem.add(Diem3);
        SinhVien sv = new SinhVien("M10","Ha Phong",dsDiem);
        //System.out.println(sv.tinhDiemTrungBinh()); 8,6666

        assertEquals("GIOI",sv.xepLoai());

    }
}