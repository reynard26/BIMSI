package projectc1.com.Item;

public class Order {


    private String tanggal_pemesanan;
    private String nama_mahasiswa;
    private String line;
    private String kode_kelas;
    private String harga;
    private String jangka_waktu;
    private String total;
    private String notes;

    public Order( String tanggal_pemesanan, String nama_mahasiswa, String line, String kode_kelas, String harga, String jangka_waktu, String total, String notes ) {


        this.tanggal_pemesanan = tanggal_pemesanan;
        this.nama_mahasiswa = nama_mahasiswa;
        this.line = line;
        this.kode_kelas = kode_kelas;
        this.harga = harga;
        this.jangka_waktu = jangka_waktu;
        this.total = total;
        this.notes = notes;
    }



    public String getTanggal_pemesanan() {
        return tanggal_pemesanan;
    }

    public void setTanggal_pemesanan(String tanggal_pemesanan) {
        this.tanggal_pemesanan = tanggal_pemesanan;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJangka_waktu() {
        return jangka_waktu;
    }

    public void setJangka_waktu(String jangka_waktu) {
        this.jangka_waktu = jangka_waktu;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
