package com.example;

import java.util.HashSet;
import java.util.Set;
public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<Diem>();

    public SinhVien() {
    }

    public SinhVien(String mssv, String ten, Set<Diem> monDaHoc) {
        this.mssv = mssv;
        this.ten = ten;
        this.monDaHoc = monDaHoc;
    }

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong

        double total=0;
        double avg =0,stc =0;

        for (Diem d: monDaHoc) {
            total += d.getDiem() * (d.getMon().getTcHT() + d.getMon().getTcLT()) ;
            stc +=d.getMon().getTcHT() + d.getMon().getTcLT();
        }
        return  total/stc;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder

        StringBuilder sbd = new StringBuilder("");
        sbd.append("Msv:" +this.mssv + "\n");
        sbd.append("Ten:" + this.ten + "\n");
        sbd.append("Danh sach diem:" + "\n");
        int cout =1;
        sbd.append("STT\t"+ "Ten Mon \t"+ "Diem \t"+ "SO Tin Chi \t");
        for ( Diem diem: monDaHoc) {

            sbd.append((cout++) +"\t" + diem.getMon().getTen() + "\t"+ diem.getDiem()+"\t"
                    +(diem.getMon().getTcLT() + diem.getMon().getTcHT()));
            sbd.append("\n");

        }
        sbd.append("Diem trung binh: "+ " " + tinhDiemTrungBinh());
        return sbd.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        if(tinhDiemTrungBinh()<5){
            return "YEU";
        }
        else if(tinhDiemTrungBinh()>=5 && tinhDiemTrungBinh() <6){
            return "tB";
        }
        else if(tinhDiemTrungBinh()>=6 && tinhDiemTrungBinh()<7){
            return "TB-KHA";
        } else if (tinhDiemTrungBinh()>=7 && tinhDiemTrungBinh()<8) {
            return "KHA";
        }
        else
            return "GIOI";
    }
}
