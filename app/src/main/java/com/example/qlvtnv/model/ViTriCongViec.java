package com.example.qlvtnv.model;

public class ViTriCongViec {

    private int idNhanVien;

    private int idViTri;

    private String thoiDiemGan;

    private String moTaCV;

    public String toString() {
        return "ViTriCongViec{" +
                "MaNhanVien=" + idNhanVien +
                ", MaViTri=" + idViTri +
                ", ThoiDiemGan=" + thoiDiemGan +
                ", MoTaCV=" + moTaCV +
                '}';
    }

    public ViTriCongViec(int idNhanVien, int idViTri, String thoiDiemGan, String moTaCV) {
        this.idNhanVien = idNhanVien;
        this.idViTri = idViTri;
        this.thoiDiemGan = thoiDiemGan;
        this.moTaCV = moTaCV;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdViTri() {
        return idViTri;
    }

    public void setIdViTri(int idViTri) {
        this.idViTri = idViTri;
    }

    public String getThoiDiemGan() {
        return thoiDiemGan;
    }

    public void setThoiDiemGan(String thoiDiemGan) {
        this.thoiDiemGan = thoiDiemGan;
    }

    public String getMoTaCV() {
        return moTaCV;
    }

    public void setMoTaCV(String moTaCV) {
        this.moTaCV = moTaCV;
    }
}
