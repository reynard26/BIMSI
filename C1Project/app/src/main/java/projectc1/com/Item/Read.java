package projectc1.com.Item;

public class Read {

    private String kode_kelas;
    private String kode_namasubject;
    private String kode_tutor;
    private String namaTutor;
    private String jadwal;
    private String stok;
    private String harga;
    private String gambar;
    private String note;

    public Read(String kode_kelas, String kode_namasubject, String kode_tutor, String namaTutor, String jadwal, String stok, String harga, String gambar, String note) {

        this.kode_kelas = kode_kelas;
        this.kode_namasubject = kode_namasubject;
        this.kode_tutor = kode_tutor;
        this.namaTutor = namaTutor;
        this.jadwal = jadwal;
        this.stok = stok;
        this.harga = harga;
        this.gambar = gambar;
        this.note = note;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getKode_namasubject() {
        return kode_namasubject;
    }

    public void setKode_namasubject(String kode_namasubject) {
        this.kode_namasubject = kode_namasubject;
    }

    public String getKode_tutor() {
        return kode_tutor;
    }

    public void setKode_tutor(String kode_tutor) {
        this.kode_tutor = kode_tutor;
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
        this.namaTutor = jadwal;
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
}
