package entity;

public class Orang {
    private int id;
    private String nama;

    public Orang(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}