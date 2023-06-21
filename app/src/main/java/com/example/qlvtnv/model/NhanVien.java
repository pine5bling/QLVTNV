package com.example.qlvtnv.model;

public class NhanVien {

    private int maNV;

    private String tenNV;

    private int namSinh;

    private String queQuan;

    private String trinhDo;

    public String toString() {
        return "Nhân Viên{" +
                "ID=" + maNV +
                ", tênNV='" + tenNV + '\'' +
                ", nămSinh ='" + namSinh + '\'' +
                ", quêQuán ='" + queQuan + '\'' +
                ", trìnhĐộ ='" + trinhDo + '\'' +
                '}';
    }

    public NhanVien(){

    }

    public NhanVien(int maNV, String tenNV, int namSinh, String queQuan, String trinhDo) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.trinhDo = trinhDo;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }
}
