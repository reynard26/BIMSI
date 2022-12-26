package projectc1.com.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import projectc1.com.Button;
import projectc1.com.Information.Informasi;
import projectc1.com.Item.Tutor;
import projectc1.com.R;
import projectc1.com.adapter.TutorAdapter;
import projectc1.com.forum.Forum;

import static java.lang.String.valueOf;

public class Reservation extends AppCompatActivity {

    private RecyclerView TutorRecyclerView;
    private projectc1.com.adapter.TutorAdapter TutorAdapter;
    private List<Tutor> TutorList;
    private RecyclerView.LayoutManager manager;

    ImageView dataanalis, accountingg, databasee, algoritma, mobile;
    private static final String BASE_URL = "https://bimbelhimsi.000webhostapp.com/BIMBEL/tutor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        setTitle("BIMSI Reservation");

        dataanalis = findViewById(R.id.imageDataanal);
        accountingg = findViewById(R.id.imageAccounting);
        databasee = findViewById(R.id.imageDatabase);
        algoritma = findViewById(R.id.imageAlgorithm);
        mobile = findViewById(R.id.imageMobileapp);

        TutorRecyclerView = findViewById(R.id.ProductRec);
        TutorList = new ArrayList<>();
        getTutor();

        dataanalis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorRecyclerView.setAdapter(null);
                TutorList.clear();

                getTutorDetail("MK001");
            }
        });
        accountingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorRecyclerView.setAdapter(null);
                TutorList.clear();

                getTutorDetail("MK002");
            }
        });
        databasee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorRecyclerView.setAdapter(null);
                TutorList.clear();

                getTutorDetail("MK003");
            }
        });
        algoritma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorRecyclerView.setAdapter(null);
                TutorList.clear();

                getTutorDetail("MK004");
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TutorRecyclerView.setAdapter(null);
                TutorList.clear();

                getTutorDetail("MK005");
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.registrasi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.forum:
                        startActivity(new Intent(getApplicationContext(), Forum.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Button.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.information:
                        startActivity(new Intent(getApplicationContext(), Informasi.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.registrasi:
                        return true;


                }
                return false;
            }
        });
    }

    private void getTutor() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);

                                String namaTutor = object.getString("namaTutor");
                                String kode_kelas = object.getString("kode_kelas");
                                String jadwal = object.getString("jadwal");
                                String kode_namasubject = object.getString("kode_namasubject");
                                String stok = object.getString("stok");
                                String harga = object.getString("harga");
                                String gambar = object.getString("gambar");
                                String note = object.getString("note");
                                ;


                                Tutor tutor = new Tutor(namaTutor, kode_kelas, jadwal, stok, harga, gambar, note, kode_namasubject);
                                TutorList.add(tutor);

                            }
                        } catch (Exception e) {

                        }

                        TutorAdapter = new TutorAdapter(Reservation.this, TutorList);
                        TutorRecyclerView.setAdapter(TutorAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Reservation.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(Reservation.this).add(stringRequest);
        setProductRec(TutorList);

    }

    private void getTutorDetail(String choose) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);

                                String namaTutor = object.getString("namaTutor");
                                String kode_kelas = object.getString("kode_kelas");
                                String jadwal = object.getString("jadwal");
                                String kode_namasubject = object.getString("kode_namasubject");
                                String stok = object.getString("stok");
                                String harga = object.getString("harga");
                                String gambar = object.getString("gambar");
                                String note = object.getString("note");
                                Tutor tutor = new Tutor(namaTutor, kode_kelas, jadwal, stok, harga, gambar, note, kode_namasubject);
                                if (kode_namasubject.equalsIgnoreCase(choose)) {
                                    TutorList.add(tutor);
                                }
                            }
                        } catch (Exception e) {

                        }

                        TutorAdapter = new TutorAdapter(Reservation.this, TutorList);
                        TutorRecyclerView.setAdapter(TutorAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Reservation.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(Reservation.this).add(stringRequest);
        setProductRec(TutorList);

    }

    private void setProductRec(List<Tutor> ProductList) {
        manager = new GridLayoutManager(Reservation.this, 2);
        TutorRecyclerView.setLayoutManager(manager);
    }

    private String formatRupiah(int number) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }
}