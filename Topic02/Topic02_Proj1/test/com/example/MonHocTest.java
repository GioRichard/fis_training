package com.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void getTen() {
        MonHoc monhoc = new MonHoc("CSDL",2,3);
       assertEquals("CSDL",monhoc.getTen());
        assertNotEquals("Cau truc du lieu", monhoc.getTen());
    }

    @Test
    void getTcLT() {
    }

    @Test
    void getTcHT() {
    }

    @Test
    void testEquals() {
        MonHoc monhoc1 = new MonHoc("CSDL",2,3);
        MonHoc monhoc2 = new MonHoc("CSDL",2,3);

        assertTrue(monhoc1.equals(monhoc2));

        MonHoc monhoc3 = new MonHoc("CSDLieu",2,3);
        assertFalse(monhoc1.equals(monhoc3));
    }
    @Test
    void testWithCollection(){
        List<MonHoc> danhSachMocHoc = new ArrayList<>();
        MonHoc monhoc1 = new MonHoc("CSDL",5,3);
        MonHoc monhoc2 = new MonHoc("aop",2,3);
        danhSachMocHoc.add(monhoc1);
        danhSachMocHoc.add(monhoc2
        );

        MonHoc monhoc3 = new MonHoc("dSDL",1,3);
        danhSachMocHoc.add(monhoc3);
        assertEquals(0,danhSachMocHoc.indexOf(monhoc1));
        assertEquals(2,danhSachMocHoc.indexOf(monhoc3));

        Collections.sort(danhSachMocHoc);
        System.out.println(danhSachMocHoc.toString());

        Collections.sort(danhSachMocHoc, new Comparator<MonHoc>() {
            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                if(o1.getTcLT()>o2.getTcLT()){
                    return 1;
                }
                else if(o1.getTcLT()<o2.getTcLT()){
                    return -1;
                }
                else
                    return 0;
            }
        });
    }

    @Test
    void testWithSet(){
        Set<MonHoc> monHocSet = new HashSet<>();
        MonHoc monhoc1 = new MonHoc("CSDL",2,3);
        MonHoc monhoc2 = new MonHoc("oop",2,3);
        monHocSet.add(monhoc1);
        monHocSet.add(monhoc2);

        MonHoc monhoc3 = new MonHoc("CSDL",2,3);
        monHocSet.add(monhoc3);
        assertEquals(2,monHocSet.size());
    }
    //Ham tra ve danh sach mon hoc
    List<MonHoc> createDanhSachMonHoc(){
        List<MonHoc> danhSachMocHoc = new ArrayList<>();
        MonHoc monhoc1 = new MonHoc("CSDL",3,2);
        MonHoc monhoc2 = new MonHoc("aop",2,3);
        danhSachMocHoc.add(monhoc1);
        danhSachMocHoc.add(monhoc2);
        return danhSachMocHoc;
    }


    @Test
    void testLamdaconllection(){
        List<MonHoc> danhSachMocHoc = createDanhSachMonHoc();

        danhSachMocHoc.stream().map(new Function<MonHoc, Diem>() {
            @Override
            public  Diem apply(MonHoc monHoc){
                Diem diem = new Diem(monHoc,(int)(Math.random() *10));
                return  diem;
            }
        }).forEach(diem -> {
            System.out.println(diem.toString());
        });

/////////////////
       // Stream<MonHoc> monHocStream = danhSachMocHoc.stream()
////filter
//                .filter(monHoc -> {
//                    if(monHoc.getTcLT()>=3){
//                        return  true;
//                    }
//                    return false;
//                    }).filter(monHoc -> {
//            if(monHoc.getTcHT()>1){
//                return  true;
//            }
//            else
//                return false;
//        });


       // System.out.println(monHocStream.count());
       // monHocStream.forEach(MonHoc::printMonHoc);
        //System.out.println();



//        //try1:No Lamda Exception
//        for (MonHoc monHoc:danhSachMocHoc) {
//            System.out.println(monHoc.getTen());
//        }
//
//        //try 2: use Lamda
//        danhSachMocHoc.forEach(
//                element -> System.out.println(element.getTen()));
//    /////
//        danhSachMocHoc.stream().filter(new Predicate<MonHoc>() {
//            @Override
//            public boolean test(MonHoc monHoc) {
//                if(monHoc.getTcLT() >2){
//                    return  true;
//                }
//                return false;
//            }
//        }).forEach(element -> System.out.println(element.getTen()));
//
//        ///
//        danhSachMocHoc.stream().filter(monHoc -> {
//            return  (monHoc.getTcLT() >2) ? true : false;
//        }).forEach(element -> System.out.println(element.getTen()));
//
//        //
//    danhSachMocHoc.stream().filter(MonHoc::tcLTGreaterThan2).forEach(MonHoc::printMonHoc);
//
    }
}