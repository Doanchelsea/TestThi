package com.example.testthi;

public class Student {
    public String masv;
    public double diem;
    public String mail;

    public Student(String masv, double diem, String mail) {
        this.masv = masv;
        this.diem = diem;
        this.mail = mail;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
