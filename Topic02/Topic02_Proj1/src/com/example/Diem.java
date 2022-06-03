package com.example;

import java.io.Serializable;


//Comparable: de giup mk clone ra
//Serializable: khi ghi doc file object
public class Diem implements Comparable<Diem>, Serializable {
    private  MonHoc mon;
    private  int diem;

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public Diem(int diem) {
        this.diem = diem;
    }

    public Diem() {

    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public boolean equals(Object that){
        //2 diem dc goi bang nhau neu cua cung 1 mon
        if(that instanceof  Diem){
            return  this.mon.equals(((Diem) that).mon);
        }
        return false;
    }

    @Override
    public int compareTo(Diem o) {
        if(this.diem>o.diem){
            return 1;
        }
        else if(this.diem <o.diem){
            return -1;
        }
        else
        return 0;

    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public Diem clone()  {
        Diem diem = new Diem(this.mon, this.diem);
        return diem;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }
}
