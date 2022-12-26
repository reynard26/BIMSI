package projectc1.com.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import projectc1.com.Item.Read;
import projectc1.com.R;
import projectc1.com.adapter.ReadAdapter;

public class ReadAdmin extends AppCompatActivity {

    private RecyclerView ReadRecyclerView;
    private projectc1.com.adapter.ReadAdapter ReadAdapter;
    private List<Read> ReadList;
    private RecyclerView.LayoutManager manager;

    ImageView dataanalis, accountingg, databasee, algoritma, mobile;

    private static final String BASE_URL = "https://bimbelhimsi.000webhostapp.com/BIMBEL/bacaAdmin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Tutor BIMSI");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_admin);
        dataanalis = findViewById(R.id.dataanalis);
        accountingg = findViewById(R.id.accountingg);
        databasee = findViewById(R.id.databasee);
        algoritma = findViewById(R.id.algoritma);
        mobile = findViewById(R.id.mobile);

        ReadRecyclerView = findViewById(R.id.ReadRec);
        ReadList = new ArrayList<>();
        getRead();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationadmin);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.invoice:
                        startActivity(new Intent(getApplicationContext(), AdminOrder.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;
                }
                return false;
            }
        });

        dataanalis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadRecyclerView.setAdapter(null);
                ReadList.clear();

                getReadDetail("MK001");
            }
        });
        accountingg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadRecyclerView.setAdapter(null);
                ReadList.clear();

                getReadDetail("MK002");
            }
        });
        databasee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadRecyclerView.setAdapter(null);
                ReadList.clear();

                getReadDetail("MK003");
            }
        });
        algoritma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadRecyclerView.setAdapter(null);
                ReadList.clear();

                getReadDetail("MK004");
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadRecyclerView.setAdapter(null);
                ReadList.clear();

                getReadDetail("MK005");
            }
        });

    }

    private void getRead() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);
                                String kode_kelas = object.getString("kode_kelas");
                                String kode_namasubject = object.getString("kode_namasubject");
                                String kode_tutor = object.getString("kode_tutor");
                                String namaTutor = object.getString("namaTutor");
                                String jadwal = object.getString("jadwal");
                                String stok = object.getString("stok");
                                String harga = object.getString("harga");
                                String gambar = object.getString("gambar");
                                String note = object.getString("note");
                                Read read = new Read(kode_kelas, kode_namasubject, kode_tutor, namaTutor, jadwal, stok, harga, gambar, note);
                                ReadList.add(read);
                            }
                        } catch (Exception e) {

                        }

                        ReadAdapter = new ReadAdapter(ReadAdmin.this, ReadList);
                        ReadRecyclerView.setAdapter(ReadAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ReadAdmin.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(ReadAdmin.this).add(stringRequest);
        setReadRec(ReadList);

    }
    private void getReadDetail(String choose) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);
                                String kode_kelas = object.getString("kode_kelas");
                                String kode_namasubject = object.getString("kode_namasubject");
                                String kode_tutor = object.getString("kode_tutor");
                                String namaTutor = object.getString("namaTutor");
                                String jadwal = object.getString("jadwal");
                                String stok = object.getString("stok");
                                String harga = object.getString("harga");
                                String gambar = object.getString("gambar");
                                String note = object.getString("note");
                                Read read = new Read(kode_kelas, kode_namasubject, kode_tutor, namaTutor, jadwal, stok, harga, gambar, note);
                                if (kode_namasubject.equalsIgnoreCase(choose)) {
                                    ReadList.add(read);
                                }
                            }
                        } catch (Exception e) {

                        }

                        ReadAdapter = new ReadAdapter(ReadAdmin.this, ReadList);
                        ReadRecyclerView.setAdapter(ReadAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ReadAdmin.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(ReadAdmin.this).add(stringRequest);
        setReadRec(ReadList);

    }

    private void setReadRec(List<Read> ReadList) {
        manager = new GridLayoutManager(ReadAdmin.this, 2);
        ReadRecyclerView.setLayoutManager(manager);
    }
}