package projectc1.com.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import projectc1.com.Item.Order;
import projectc1.com.R;
import projectc1.com.adapter.OrderAdapter;
import projectc1.com.forum.Forum;

public class AdminOrder extends AppCompatActivity {

    private RecyclerView OrderRecyclerView;
    private projectc1.com.adapter.OrderAdapter OrderAdapter;
    private List<Order> OrderList;
    private RecyclerView.LayoutManager manager;

    private static final String url_order = "https://bimbelhimsi.000webhostapp.com/BIMBEL/lihatOrder.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Student Reservation Data");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_order);
        OrderRecyclerView = findViewById(R.id.OrderRec);
        OrderList = new ArrayList<>();
        getOrder();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationadmin);
        bottomNavigationView.setSelectedItemId(R.id.invoice);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ReadAdmin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.invoice:
                        return true;

                }
                return false;
            }
        });
    }

    private void getOrder() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url_order,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);


                                String tanggal_pemesanan = object.getString("tanggal_pemesanan");
                                String nama_mahasiswa = object.getString("nama_mahasiswa");
                                String line = object.getString("line");
                                String kode_kelas = object.getString("kode_kelas");
                                String harga = object.getString("harga");
                                String jangka_waktu = object.getString("jangka_waktu");
                                String total = object.getString("total");
                                String notes = object.getString("notes");
                                Order order = new Order(tanggal_pemesanan, nama_mahasiswa, line, kode_kelas, harga, jangka_waktu, total, notes);
                                OrderList.add(order);

                            }
                        } catch (Exception e) {

                        }

                        OrderAdapter = new OrderAdapter(AdminOrder.this, OrderList);
                        OrderRecyclerView.setAdapter(OrderAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AdminOrder.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(AdminOrder.this).add(stringRequest);
        setOrderRec(OrderList);

    }
    private void setOrderRec(List<Order> OrderList) {


        manager = new GridLayoutManager(AdminOrder.this, 1);
        OrderRecyclerView.setLayoutManager(manager);
    }
}