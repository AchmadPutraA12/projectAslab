package entity;

public class PasienEntity extends Orang{
    private int umur;
    private String alamat;

    public PasienEntity(int id, String nama, int umur, String alamat) {
        super(id, nama);
        this.umur = umur;
        this.alamat = alamat;
    }

    public int getUmur() {
        return this.umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}