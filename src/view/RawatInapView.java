package view;

import java.util.Scanner;

import controller.RawatInapController;
import entity.KamarEntity;
import entity.RawatInapEntity;

public class RawatInapView {
    Scanner input = new Scanner(System.in);
    RawatInapController objRawat = new RawatInapController();
    KamarEntity objKamar = new KamarEntity();

    public void rawatInap() {
        try {
            System.out.print("Masukkan Id Pasien        = ");
            int id = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Nama Pasien      = ");
            String nama = input.nextLine();
            System.out.print("Masukkan Umur Pasien      = ");
            int umur = input.nextInt();
            input.nextLine();
            System.out.print("Masukkan Alamat Pasien    = ");
            String alamat = input.nextLine();
            KamarEntity kamar = pilihKamar();
            System.out.print("Berapa Malam              = ");
            int berapaMalam = input.nextInt();
            input.nextLine();
            objRawat.pesanKamar(id, nama, umur, alamat, kamar, berapaMalam);
        } catch (Exception e) {
            input.nextLine();
        }
    }

    private KamarEntity pilihKamar() {
        boolean pilihKamar = false;
        KamarEntity kamar;
        do {
            System.out.print("Masukkan Kode Kamar : ");
            String kode = input.nextLine();
            kamar = objRawat.cariKamar(kode);
            if (kamar != null) {
                if (kamar.isStatus()) {
                    char pilihKamarIni = 'n';

                    System.out.println("Kode Kamar      = " + kamar.getKodeKamar());
                    System.out.println("Jenis Kamar     = " + kamar.getJenisKamar());
                    System.out.println("Harga Kamar     = " + kamar.getHargaPermalam());

                    System.out.print("Pilih Kamar Ini (y/n) = ");
                    pilihKamarIni = input.nextLine().charAt(0);

                    if (pilihKamarIni == 'y') {
                        objRawat.rawatInap(kamar);
                        pilihKamar = true;
                        break;
                    }
                } else {
                    System.out.println("Kamar Telah Ditempati");
                }
            } else {
                System.out.println("Kamar Tidak Ditemukan");
            }
        } while (pilihKamar == false);
        return kamar;
    }

    public void rawatJalan(){
        System.out.print("Masukkan Nama Pasien = ");
        String nama = input.nextLine();
        System.out.print("Masukkan Kode Kamar = ");
        String kodeKamar = input.nextLine();
        RawatInapEntity rawat = objRawat.cariPasienInap(nama, kodeKamar);
        if(rawat != null){
            if(rawat.getTanggalKeluar() == null ){
                objRawat.keluarInap(rawat);
            } else {
                System.out.println("Pasien Telah Keluar");
            }
        } else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public void cetakData() {
        if (objRawat.allArrayRawat() != null) {
            for (RawatInapEntity objRawat : objRawat.allArrayRawat()) {
                System.out.println();
                System.out.println("ID Pasien           = " + objRawat.getPasien().getId());
                System.out.println("Nama Pasien         = " + objRawat.getPasien().getNama());
                System.out.println("Umur Pasien         = " + objRawat.getPasien().getUmur());
                System.out.println("Alamat Pasien       = " + objRawat.getPasien().getAlamat());
                System.out.println("Jenis Kamar         = " + objRawat.getKamar().getJenisKamar());
                System.out.println("Harga Kamar         = " + objRawat.getKamar().getHargaPermalam());
                System.out.println("Total Harga Kamar   = " + objRawat.getTotalHarga());
                System.out.println("Berapa Malam        = " + objRawat.getBerapaMalam());
                System.out.println("Tanggal Masuk       = " + objRawat.getTanggalMasuk());
                System.out.println("Tanggal Keluar      = " + objRawat.getTanggalKeluar());
                System.out.println();
            }
        } else {
            System.out.println("Data Masih Kosong");
        }
    }

    public void cetakKamar() {
        if (objRawat.allArrayKamar() != null) {
            for (KamarEntity kamar : objRawat.allArrayKamar()) {
                if (kamar.getStatus() == true) {
                    System.out.println();
                    System.out.println("    Kamar Yang Tersedia");
                    System.out.println("Kode Kamar      : " + kamar.getKodeKamar());
                    System.out.println("Jenis Kamar     : " + kamar.getJenisKamar());
                    System.out.println("Harga Permalam  : " + kamar.getHargaPermalam());
                    System.out.println();
                }
            }
        } else {
            System.out.println("Kamar Kosong");
        }
    }
}
