package com.example.asstkgd.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TaiKhoan {

    @PrimaryKey(autoGenerate = true)
    int id;
    String m_TK, m_Matkhau, m_Ten, m_Diachi, m_Sdt;
    public String getM_TK() {
        return m_TK;
    }

    public void setM_TK(String m_TK) {
        this.m_TK = m_TK;
    }

    public String getM_Matkhau() {
        return m_Matkhau;
    }

    public void setM_Matkhau(String m_Matkhau) {
        this.m_Matkhau = m_Matkhau;
    }

    public String getM_Ten() {
        return m_Ten;
    }

    public void setM_Ten(String m_Ten) {
        this.m_Ten = m_Ten;
    }

    public String getM_Diachi() {
        return m_Diachi;
    }

    public void setM_Diachi(String m_Diachi) {
        this.m_Diachi = m_Diachi;
    }

    public String getM_Sdt() {
        return m_Sdt;
    }

    public void setM_Sdt(String m_Sdt) {
        this.m_Sdt = m_Sdt;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void TaiKhoan(){
    }

}
