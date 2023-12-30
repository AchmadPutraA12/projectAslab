package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import entity.AdminEntity;
import entity.KamarEntity;
import entity.PasienEntity;
import entity.RawatInapEntity;
import utils.DateString;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RawatInapModel {
    private static ArrayList<KamarEntity> arrayKamar = new ArrayList<>();
    private static ArrayList<AdminEntity> arrayAdmin = new ArrayList<>();
    private static ArrayList<RawatInapEntity> arrayRawat = new ArrayList<>();
    private static final String fileKamar = "Kamar.txt";

    public static ArrayList<KamarEntity> allArrayKamar(){
        return arrayKamar;
    }

    public static ArrayList<AdminEntity> allArrayAdmin(){
        return arrayAdmin;
    }

    public static ArrayList<RawatInapEntity> allArrayRawat(){
        return arrayRawat;
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

    @SuppressWarnings("unchecked")
    public static void loadFileKamar(){
        File file = new File(fileKamar);
        if(file.exists()){
            try(ObjectInputStream inputStream = new java.io.ObjectInputStream(new FileInputStream(fileKamar))){
                arrayKamar = (ArrayList<KamarEntity>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveFile(){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileKamar))) {
            outputStream.writeObject(arrayKamar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}