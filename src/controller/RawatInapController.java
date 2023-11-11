package controller;

import java.util.ArrayList;

import entity.AdminEntity;
import entity.KamarEntity;
import entity.RawatInapEntity;
import models.RawatInapModel;
import view.Menu;

public class RawatInapController {

    public ArrayList<KamarEntity> allArrayKamar(){
        return RawatInapModel.allArrayKamar();
    }

    public ArrayList<AdminEntity> allArrayAdmin(){
        return RawatInapModel.allArrayAdmin();
    }

    public ArrayList<RawatInapEntity> allArrayRawat(){
        return RawatInapModel.allArrayRawat();
    }

    public void rawatInap(KamarEntity kamar){
        RawatInapModel.rawatInap(kamar);
    }

    public void keluarInap(RawatInapEntity rawat){
        RawatInapModel.keluarInap(rawat);
    }

    public KamarEntity cariKamar (String kode){
        return RawatInapModel.cariKamar(kode);
    }

    public RawatInapEntity cariPasienInap(String nama, String kodeKamar){
        return RawatInapModel.cariPasienInap(nama, kodeKamar);
    }

    public void pesanKamar(int id, String nama, int umur, String alamat, KamarEntity kamar, int berapaMalam){
        RawatInapModel.pesanKamar(id, nama, umur, alamat, kamar, berapaMalam);
    }

    public boolean loginAdmin(int kartuPegawai, String password){
        return RawatInapModel.loginAdmin(kartuPegawai, password);
    }

    public void menu(){
        Menu objMenu = new Menu();
        objMenu.menu();
    }
}
