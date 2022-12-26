package projectc1.com.Item;

public class Tutor {

    private String namaTutor;
    private String kode_kelas;
    private String jadwal;
    private String stok;
    private String harga;
    private String gambar;
    private String note;
    private String kode_namasubject;

    public Tutor(String namaTutor, String kode_kelas, String jadwal, String stok, String harga, String gambar, String note, String kode_namasubject ) {

        this.namaTutor = namaTutor;
        this.kode_kelas = kode_kelas;
        this.jadwal = jadwal;
        this.stok = stok;
        this.harga = harga;
        this.gambar = gambar;
        this.note = note;
        this.kode_namasubject = kode_namasubject;
    }

    public String getNamaTutor() {
        return namaTutor;
    }

    public void setNamaTutor(String namaTutor) {
        this.namaTutor = namaTutor;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKode_namasubject() {
        return kode_namasubject;
    }

    public void setKode_namasubject(String kode_merk) {
        this.kode_namasubject = kode_namasubject;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }
}
