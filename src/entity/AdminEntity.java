package entity;

public class AdminEntity extends Orang{
    private int kartuPegawai;
    private String password;

    public AdminEntity(int id, String nama, int kartuPegawai, String password) {
        super(id, nama);
        this.kartuPegawai = kartuPegawai;
        this.password = password;
    }

    public int getKartuPegawai() {
        return this.kartuPegawai;
    }

    public void setKartuPegawai(int kartuPegawai) {
        this.kartuPegawai = kartuPegawai;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}