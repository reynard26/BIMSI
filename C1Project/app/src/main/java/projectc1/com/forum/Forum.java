package projectc1.com.forum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import projectc1.com.Button;
import projectc1.com.Information.Informasi;
import projectc1.com.Reservation.Reservation;
import projectc1.com.R;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static projectc1.com.forum.TambahForum.REQUEST_ADD;

public class Forum extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    ProgressBar progressBar2;
    ListView lv;
    SwipeRefreshLayout refreshLayout;
    ArrayList<HashMap<String,String>> list_forum;
    String URL_GET_FORUM="https://bimbelhimsi.000webhostapp.com/BIMBEL/getForum.php";

    private static final String TAG_FORUM="data";
    private static final String TAG_ID="id";
    private static final String TAG_NAMA="nama";
    private static final String TAG_POST = "post";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Forum");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setSelectedItemId(R.id.forum);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.forum:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Button.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.information:
                        startActivity(new Intent(getApplicationContext(), Informasi.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.registrasi:
                        startActivity(new Intent(getApplicationContext(), Reservation.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });

        list_forum=new ArrayList<>();
        lv=findViewById(R.id.listView);
        progressBar2=findViewById(R.id.progressBar2);
        floatingActionButton = findViewById(R.id.fab);
        progressBar2.setVisibility(View.VISIBLE);


        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(Forum.this,TambahForum.class);
            startActivityForResult(intent, REQUEST_ADD);
        });

        RequestQueue queue = Volley.newRequestQueue(Forum.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_GET_FORUM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    JSONArray member = jObj.getJSONArray(TAG_FORUM);

                    for (int i = 0; i < member.length(); i++) {
                        JSONObject a = member.getJSONObject(i);
                        String id = a.getString(TAG_ID);
                        String nama = a.getString(TAG_NAMA);
                        String post = a.getString(TAG_POST);

                        HashMap<String, String> map = new HashMap<>();
                        map.put("id", id);
                        map.put("nama", nama);
                        map.put("post",post);

                        list_forum.add(map);
                        String[] from = { "nama", "post"};
                        int[] to = { R.id.forumNama, R.id.forumPost};

                        ListAdapter adapter = new SimpleAdapter(
                                Forum.this, list_forum, R.layout.list_forum,
                                from, to);
                        lv.setAdapter(adapter);
                        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                String nomor = list_forum.get(position).get(TAG_ID);
                                Intent i = new Intent(getApplicationContext(), EditForum.class);
                                i.putExtra("id", nomor);
                                startActivity(i);

                                return true;
                            }
                        });
                    }
                }
                catch (Exception ex) {
                    Log.e("Error", ex.toString());
                    progressBar2.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
                Toast.makeText(Forum.this, "silahkan cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        queue.add(stringRequest);
        progressBar2.setVisibility(View.GONE);
    }
}
