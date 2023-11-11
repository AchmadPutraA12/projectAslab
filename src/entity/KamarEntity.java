package entity;

public class KamarEntity {
    private String kodeKamar;
    private String jenisKamar;
    private int hargaPermalam;
    private boolean status;

    public KamarEntity(String kodeKamar, String jenisKamar, int hargaPermalam, boolean status) {
        this.kodeKamar = kodeKamar;
        this.jenisKamar = jenisKamar;
        this.hargaPermalam = hargaPermalam;
        this.status = status;
    }

    public KamarEntity() {
    }


    public String getKodeKamar() {
        return this.kodeKamar;
    }

    public void setKodeKamar(String kodeKamar) {
        this.kodeKamar = kodeKamar;
    }

    public String getJenisKamar() {
        return this.jenisKamar;
    }

    public void setJenisKamar(String jenisKamar) {
        this.jenisKamar = jenisKamar;
    }

    public int getHargaPermalam() {
        return this.hargaPermalam;
    }

    public void setHargaPermalam(int hargaPermalam) {
        this.hargaPermalam = hargaPermalam;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
