package projectc1.com.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import projectc1.com.R;

import static java.lang.String.valueOf;

public class FormPembelian extends AppCompatActivity {

    TextView txtNamaTutor, txtHarga, txtTotal, txtKode_kelas;
    String total_harga;

    EditText EdtNama_mahasiswa, EdtLine,  EdtJumlah, EdtNotes;

    android.widget.Button btnConfirm, btnHitung;

    String hargaa, jumlah_pesan;

    String nama_mahasiswa, line, kode_kelas, harga, jangka_waktu, total, notes;

    String url_tambah_penjualan = "https://bimbelhimsi.000webhostapp.com/BIMBEL/pemesanan.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pembelian);
        setTitle("Reservation Page");

        txtKode_kelas = findViewById(R.id.kodekelas);
        txtNamaTutor = findViewById(R.id.namaTutor);
        txtHarga  = findViewById(R.id.hargaPerminggu);
        btnHitung = findViewById(R.id.btnHitung);
        btnConfirm = findViewById(R.id.btnConfirm);
        EdtNama_mahasiswa = findViewById(R.id.nama);
        EdtLine = findViewById(R.id.line);
        EdtJumlah = findViewById(R.id.jumlah);
        EdtNotes = findViewById(R.id.notes); //harusnya gambar
        txtTotal = findViewById(R.id.txtTotal);

        Intent i = getIntent();
        String getNamaTutor = i.getStringExtra("namaTutor");
        String getKode_kelas = i.getStringExtra("kode_kelas");
        hargaa = i.getStringExtra("harga");
        jumlah_pesan = i.getStringExtra("jangka_waktu");
        txtNamaTutor.setText(getNamaTutor);
        txtKode_kelas.setText(getKode_kelas);
        String hargaDatbase = hargaa;
        txtHarga.setText(formatRupiah(Double.parseDouble(hargaDatbase)));


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int subtotal, jumlahh, hargaax;
                jumlahh = Integer.valueOf(EdtJumlah.getText().toString().trim());
                hargaax = Integer.valueOf(hargaDatbase.trim());
                subtotal = jumlahh * hargaax;
                if (jumlahh==4){
                    String totalHarga = (formatRupiah(Double.parseDouble(valueOf(subtotal))));
                    txtTotal.setText(totalHarga);
                    total_harga = valueOf(Integer.valueOf(subtotal));
                }else {
                    Toast.makeText(FormPembelian.this, "Jumlah Reserve Harus 4", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama_mahasiswa = EdtNama_mahasiswa.getText().toString();
                line = EdtLine.getText().toString();
                kode_kelas = txtKode_kelas.getText().toString();
                harga = hargaDatbase;
                jangka_waktu = EdtJumlah.getText().toString();
                total = total_harga;
                notes = EdtNotes.getText().toString();

                if (EdtNama_mahasiswa.length() > 0 && EdtLine.length() > 0 && txtKode_kelas.length() > 0 && hargaDatbase.length() > 0 && EdtJumlah.length() > 0 && total_harga.length() > 0 && EdtNotes.length() > 0 ) {
                    tambahPemesanan(nama_mahasiswa, line, kode_kelas, harga, jangka_waktu, total, notes);
                }else {
                    Toast.makeText(FormPembelian.this, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private String formatRupiah(Double number) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }
    private void tambahPemesanan(String nama_mahasiswa, String line, String kode_kelas, String harga, String jangka_waktu, String total, String notes) {
        RequestQueue requestQueue = Volley.newRequestQueue(FormPembelian.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_tambah_penjualan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int success = jsonObject.getInt("success");
                    if (success == 1) {
                        Toast.makeText(FormPembelian.this, "Invoice Berhasil dibuat", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(FormPembelian.this, Reservation.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(FormPembelian.this, "Invoice gagal dibuat", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Log.e("Error", ex.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FormPembelian.this, "Cek koneksi anda terlebih dahulu!", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama_mahasiswa", nama_mahasiswa);
                params.put("line", line);
                params.put("kode_kelas", kode_kelas);
                params.put("harga", harga);
                params.put("jangka_waktu", jangka_waktu);
                params.put("total", total);
                params.put("notes", notes);
                return params;
            }
        };
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);
    }

}