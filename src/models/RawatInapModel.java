package models;

import java.util.ArrayList;

import entity.AdminEntity;
import entity.KamarEntity;
import entity.PasienEntity;
import entity.RawatInapEntity;
import utils.DateString;

public class RawatInapModel {
    private static ArrayList<KamarEntity> arrayKamar = new ArrayList<>();
    private static ArrayList<AdminEntity> arrayAdmin = new ArrayList<>();
    private static ArrayList<RawatInapEntity> arrayRawat = new ArrayList<>();

    public static ArrayList<KamarEntity> allArrayKamar(){
        return arrayKamar;
    }

    public static ArrayList<AdminEntity> allArrayAdmin(){
        return arrayAdmin;
    }

    public static ArrayList<RawatInapEntity> allArrayRawat(){
        return arrayRawat;
    }

    public static void dataKamar(){
        arrayKamar.add(new KamarEntity("K101", "VIIP", 1500000, true));
        arrayKamar.add(new KamarEntity("K102", "VIP", 1000000, true));
    }

    public static void dataAdmin(){
        arrayAdmin.add(new AdminEntity(1, "achmad", 123, "1"));
    }

    public static void rawatInap(KamarEntity kamar){
        kamar.setStatus(false);
    }

    public static void keluarInap(RawatInapEntity rawat){
        rawat.setTanggalKeluar(DateString.now());
        rawat.getKamar().setStatus(true);
    }

    public static KamarEntity cariKamar (String kode){
        for(KamarEntity objKamar : arrayKamar){
            if(objKamar.getKodeKamar().equals(kode)){
                return objKamar;
            }
        }
        return null;
    }

    public static RawatInapEntity cariPasienInap(String nama, String kodeKamar){
        for(RawatInapEntity objRawat : arrayRawat){
            if(objRawat.getPasien().getNama().equals(nama) && objRawat.getKamar().getKodeKamar().equals(kodeKamar)){
                return objRawat;
            }
        }
        return null;
    }

    public static void pesanKamar(int id, String nama, int umur, String alamat, KamarEntity kamar, int berapaMalam){
        PasienEntity objPasien = new PasienEntity(id, nama, umur, alamat);
        RawatInapEntity objRawat = new RawatInapEntity(objPasien, kamar, berapaMalam);
        arrayRawat.add(objRawat);
    }

    public static boolean loginAdmin(int kartuPegawai, String password){
        for(AdminEntity objAdmin : arrayAdmin){
            if(objAdmin.getKartuPegawai() == kartuPegawai && objAdmin.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}