package com.example;

import com.example.Diem;
import com.example.MonHoc;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void testEquals() {
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("toan",1,3),9);
        boolean check = Diem2.equals(Diem1);
        assertTrue(check);
    }

    @Test
    void compareTo() {
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("toan",1,3),7);
        assertEquals(1,Diem1.compareTo(Diem2));
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testClone() {
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("toan",1,3),9);
        assertEquals(Diem1,Diem2.clone());
    }

    @Test
    void getDiem(){
        Diem Diem = new Diem(new MonHoc("toan",1,3),8);
        assertEquals(8, Diem.getDiem());
        assertNotEquals(10,Diem.getDiem());
    }

    @Test
    void testWitCollection(){
        List<Diem> danhSachDiem = new ArrayList<>();
        Diem Diem1 = new Diem(new MonHoc("toan",1,3),8);
        Diem Diem2 = new Diem(new MonHoc("toan",1,3),9);
        Diem Diem3 = new Diem(new MonHoc("toan",1,3),8);


    }

}