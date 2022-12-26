package projectc1.com.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import projectc1.com.R;

public class UpdateAdmin extends AppCompatActivity {

    TextView txtKodeKelas, txtKodeNamasubject, txtKodeTutor, txtNamaTutor, txtNote, txtJadwal; //kemungkinan salaha di sini namanya sama
    EditText EdtHarga, EdtStok;
    ImageView ImgGambar;
    String id_tutor, kode_kelas, kode_namasubject, kode_tutor, namaTutor, stok, harga, gambar, note, jadwal;
    private Button btnUpdate, btnDelete;


    String url_update = "https://bimbelhimsi.000webhostapp.com/BIMBEL/updateTutorStok.php";
    String url_delete = "https://bimbelhimsi.000webhostapp.com/BIMBEL/deleteTutor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_admin);

        txtKodeKelas = findViewById(R.id.txtKodekelas);
        txtKodeNamasubject = findViewById(R.id.txtkodesubject);
        txtKodeTutor = findViewById(R.id.txtkodetutor);
        txtNamaTutor = findViewById(R.id.txtnamatutor);
        txtJadwal = findViewById(R.id.txtJadwal);
        EdtStok = findViewById(R.id.EdtStok);
        EdtHarga = findViewById(R.id.EdtHargaSatuan);
        ImgGambar = findViewById(R.id.ImgGambar);
        txtNote = findViewById(R.id.txtNotes);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        Intent i = getIntent();

        id_tutor = i.getStringExtra("id_tutor");
        kode_kelas = i.getStringExtra("kode_kelas");
        kode_namasubject = i.getStringExtra("kode_namasubject");
        kode_tutor = i.getStringExtra("kode_tutor");
        namaTutor = i.getStringExtra("namaTutor");
        jadwal = i.getStringExtra("jadwal");
        stok = i.getStringExtra("stok");
        harga = i.getStringExtra("harga");
        gambar = i.getStringExtra("gambar");
        note = i.getStringExtra("note");

        txtKodeKelas.setText(kode_kelas);
        txtKodeNamasubject.setText(kode_namasubject);
        txtKodeTutor.setText(kode_tutor);
        txtNamaTutor.setText(namaTutor);
        txtJadwal.setText(jadwal);
        EdtStok.setText(stok);
        EdtHarga.setText(harga);
        txtNote.setText(note);
        Glide.with(UpdateAdmin.this).load(gambar).into(ImgGambar);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTutor(kode_kelas);

                Intent i = new Intent(UpdateAdmin.this, ReadAdmin.class);
                startActivity(i);
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kode_kelas= txtKodeKelas.getText().toString();
                stok = EdtStok.getText().toString();
                harga = EdtHarga.getText().toString();
                UpdateTutor(kode_kelas, stok, harga);
            }
        });
    }

        private void UpdateTutor(String kode_kelas, String stok, String harga) {
        RequestQueue requestQueue = Volley.newRequestQueue(UpdateAdmin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_update, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    int success = jsonObject.getInt("success");
                    if (success == 1) {
                        Toast.makeText(UpdateAdmin.this, "Data tutor berhasil diupdate", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(UpdateAdmin.this, ReadAdmin.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(UpdateAdmin.this, "Data tutor gagal diupdate", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateAdmin.this, "Connetion Error!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("kode_kelas", kode_kelas);
                params.put("stok", stok);
                params.put("harga", harga);
                return params;
            }
        };
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);
    }
    private void deleteTutor(String mKode_kelas) {
        RequestQueue requestQueue = Volley.newRequestQueue(UpdateAdmin.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_delete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int sukses = jsonObject.getInt("success");
                            if (sukses == 1) {
                                Toast.makeText(UpdateAdmin.this,
                                        "Data Tutor berhasil dihapus", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(UpdateAdmin.this,
                                        "Data Tutor gagal dihapus", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            Toast.makeText(UpdateAdmin.this,
                                    e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateAdmin.this,
                        "Connetion Error!", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("kode_kelas", mKode_kelas);
                return params;
            }
        };
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);
    }
}