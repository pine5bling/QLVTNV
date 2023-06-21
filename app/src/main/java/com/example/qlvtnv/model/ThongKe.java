package com.example.qlvtnv.model;

public class ThongKe {
    private int idVT;

    private String tenVT;

    private int soNhanVien;

    public String toString() {
        return "Mã Vị Trí = " + idVT +
                ", tên vị trí = " + tenVT +
                ", số nhân viên = " + soNhanVien;
    }

    public ThongKe(){

    }

    public ThongKe(int idVT, String tenVT, int soNhanVien) {
        this.idVT = idVT;
        this.tenVT = tenVT;
        this.soNhanVien = soNhanVien;
    }

    public int getIdVT() {
        return idVT;
    }

    public void setIdVT(int idVT) {
        this.idVT = idVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public int getSoNhanVien() {
        return soNhanVien;
    }

    public void setSoNhanVien(int soNhanVien) {
        this.soNhanVien = soNhanVien;
    }
}
