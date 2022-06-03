package com.example;

import java.util.Objects;

public class MonHoc implements Comparable<MonHoc> {
    private  String ten;
    private  int tcLT;
    private  int tcHT;

    public MonHoc() {
    }

    public MonHoc(String ten, int tcLT, int tcHT) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcHT = tcHT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public void setTcLT(int tcLT) {
        this.tcLT = tcLT;
    }

    public int getTcHT() {
        return tcHT;
    }

    public void setTcHT(int tcHT) {
        this.tcHT = tcHT;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tcLT, tcHT);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHoc monHoc = (MonHoc) o;
        return tcLT == monHoc.tcLT && tcHT == monHoc.tcHT && ten.equals(monHoc.ten);
    }



    @Override
    public int compareTo(MonHoc that) {
        if(this.ten.compareTo(that.ten) >0){
            return 1;
        }
        else if(this.ten.compareTo(that.ten) <0){
            return  -1;
        }
        else
            return  0;
    }

    public static void  printMonHoc(MonHoc monHoc) {
       System.out.println(monHoc.toString());
   }

   public  boolean tcLTGreaterThan2(MonHoc monHoc){
        return (monHoc.getTcLT() >2) ? true : false;
   }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcHT=" + tcHT +
                '}';
    }
}
