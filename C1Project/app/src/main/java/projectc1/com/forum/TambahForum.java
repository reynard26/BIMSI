package projectc1.com.forum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import projectc1.com.R;

public class TambahForum extends AppCompatActivity {

    EditText forumNama;
    EditText forumPost;
    Button btntambah_forum;
    String nama, post;
    public static final int REQUEST_ADD = 101;

    String url_tambah_post = "https://bimbelhimsi.000webhostapp.com/BIMBEL/addForum.php";// ganti dengan url kalian sendiri

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahforum);

        forumNama = (EditText) findViewById(R.id.textNama);
        forumPost = (EditText) findViewById(R.id.textAlamat);
        btntambah_forum = (Button) findViewById(R.id.btnTambah);
        btntambah_forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = forumNama.getText().toString().trim();
                post = forumPost.getText().toString().trim();

                if (!nama.isEmpty() || !post.isEmpty()) {
                    RequestQueue queue = Volley.newRequestQueue(TambahForum.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url_tambah_post, new Response.Listener<String>() {
                        @Override

                        public void onResponse(String response) {
                            try {

                                JSONObject jObj = new JSONObject(response);
                                int sukses = jObj.getInt("success");
                                if (sukses == 1) {
                                    Toast.makeText(TambahForum.this, "Post Forum berhasil disimpan", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(TambahForum.this, "Post Forum gagal disimpan", Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception ex) {
                                Log.e("Error", ex.toString());
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error", error.getMessage());
                            Toast.makeText(TambahForum.this, "silahkan cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("nama", nama);
                            params.put("post", post);
                            return params;
                        }

                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("Content-Type", "application/x-www-form-urlencoded");
                            return params;
                        }
                    };
                    queue.getCache().clear();
                    queue.add(stringRequest);
                } else {
                    forumNama.setError("Please insert valid nama");
                    forumPost.setError("Please Insert valid post");
                }
                startActivity(new Intent(getApplicationContext(),Forum.class));
            }

        });
    }
}