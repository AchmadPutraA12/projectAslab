package entity;

import utils.DateString;

public class RawatInapEntity {
    private PasienEntity pasien;
    private KamarEntity kamar;
    private int berapaMalam;
    private String tanggalMasuk;
    private String tanggalKeluar;

    public RawatInapEntity(PasienEntity pasien, KamarEntity kamar, int berapaMalam) {
        this.pasien = pasien;
        this.kamar = kamar;
        this.berapaMalam = berapaMalam;
        this.tanggalMasuk = DateString.now();
    }

    public PasienEntity getPasien() {
        return this.pasien;
    }

    public void setPasien(PasienEntity pasien) {
        this.pasien = pasien;
    }

    public KamarEntity getKamar() {
        return this.kamar;
    }

    public void setKamar(KamarEntity kamar) {
        this.kamar = kamar;
    }

    public int getBerapaMalam() {
        return this.berapaMalam;
    }

    public void setBerapaMalam(int berapaMalam) {
        this.berapaMalam = berapaMalam;
    }

    public String getTanggalMasuk() {
        return this.tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTanggalKeluar() {
        return this.tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public int getTotalHarga(){
        return this.kamar.getHargaPermalam() * this.getBerapaMalam();
    }

}