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
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import projectc1.com.R;

public class EditForum extends AppCompatActivity {

    EditText textNama;
    EditText textPost;
    Button btnEdit, btnHapus, btnBatal;
    String url_get_mahasiswa_by_id="https://bimbelhimsi.000webhostapp.com/BIMBEL/getForumById.php";//ganti dengan url kalian sendiri
    String url_update_mahasiswa="https://bimbelhimsi.000webhostapp.com/BIMBEL/updateForum.php";//ganti dengan url kalian sendiri
    String url_hapus_mahasiswa="https://bimbelhimsi.000webhostapp.com/BIMBEL/deleteForum.php";//ganti dengan url kalian sendiri

    private static final String TAG_FORUM = "data";
    private static final String TAG_ID = "id";
    private static final String TAG_NAMA = "nama";
    private static final String TAG_POST = "post";
    String id, nama, post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editforum);

        textNama = (EditText)findViewById(R.id.textNama);
        textPost = (EditText)findViewById(R.id.textPost);

        Intent i = getIntent();
        id = i.getStringExtra("id");

        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnHapus = (Button)findViewById(R.id.btnHapus);
        btnBatal = (Button)findViewById(R.id.btnBatal);

        RequestQueue queue = Volley.newRequestQueue(EditForum.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_get_mahasiswa_by_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    JSONArray member = jObj.getJSONArray(TAG_FORUM);
                    JSONObject a = member.getJSONObject(0);

                    textNama.setText(a.getString(TAG_NAMA));
                    textPost.setText(a.getString(TAG_POST));
                }
                catch (Exception ex) {
                    Log.e("Error", ex.toString());

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                String errorMsg = "";
                if(response != null && response.data != null){
                    String errorString = new String(response.data);
                    Log.i("log error", errorString);
                }
                Toast.makeText(EditForum.this, "silahkan cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                finish();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };
        queue.add(stringRequest);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = textNama.getText().toString();
                post = textPost.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(EditForum.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url_update_mahasiswa, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jObj     = new JSONObject(response);
                            int sukses = jObj.getInt("success");
                            if (sukses == 1) {
                                Toast.makeText(EditForum.this, "Data Post Forum berhasil diupdate", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(EditForum.this, "Data Post Forum gagal diupdate", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            Log.e("Error", ex.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getMessage());
                        Toast.makeText(EditForum.this, "silahkan cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        params.put("id", id);
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
                Intent i = new Intent(getApplicationContext(), Forum.class);
                startActivity(i);

            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EditForum.this);

                builder.setTitle("Konfirmasi Hapus");
                builder.setMessage("Apakah Anda yakin ingin menghapus Post ini ?");

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        RequestQueue queue = Volley.newRequestQueue(EditForum.this);
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_hapus_mahasiswa, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jObj = new JSONObject(response);
                                    int sukses = jObj.getInt("success");
                                    if (sukses == 1) {
                                        Toast.makeText(EditForum.this, "Post berhasil dihapus", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(EditForum.this, "Post gagal dihapus", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (Exception ex) {
                                    Log.e("Error", ex.toString());
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Error", error.getMessage());
                                Toast.makeText(EditForum.this, "silahkan cek koneksi internet anda", Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<>();
                                params.put("id", id);
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
                        Intent i = new Intent(getApplicationContext(), Forum.class);
                        startActivity(i);
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}