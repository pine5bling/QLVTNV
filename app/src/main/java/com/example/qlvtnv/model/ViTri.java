package com.example.qlvtnv.model;

public class ViTri {

    private int maVT;

    private String tenVT;

    private String moTa;

    public String toString() {
        return "Vị Trí{" +
                "ID=" + maVT +
                ", tênVT='" + tenVT + '\'' +
                ", môTả=" + moTa +
                '}';
    }

    public ViTri(){

    }

    public ViTri(int maVT, String tenVT, String moTa) {
        this.maVT = maVT;
        this.tenVT = tenVT;
        this.moTa = moTa;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
