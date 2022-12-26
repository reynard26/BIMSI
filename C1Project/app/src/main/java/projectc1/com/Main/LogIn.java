package projectc1.com.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import projectc1.com.Admin.ReadAdmin;
import projectc1.com.Button;
import projectc1.com.R;

public class LogIn extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private View btnSignin;
        final String URL_Login = "https://bimbelhimsi.000webhostapp.com/BIMBEL/SignIn.php";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setTitle("Log In");

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignin = findViewById(R.id.btnSignin);

        btnSignin.setOnClickListener(new View.OnClickListener(){
             @Override
              public void onClick(View v) {
                String iEmail = edtEmail.getText().toString().trim();
                String iPassword = edtPassword.getText().toString().trim();

                if(!iEmail.isEmpty() || !iPassword.isEmpty()){
                    SignIn(iEmail,iPassword);
                } else {
                    edtEmail.setError("Please insert valid email");
                    edtPassword.setError("Please Insert valid password");
                }
             }
        });
        TextView textView = findViewById(R.id.notmember);
        String text = "Not a member yet ? Sign up here";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(true);

            }
        };
        ss.setSpan(clickableSpan1, 19, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    private void SignIn(String email, String password){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_Login, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String success = jsonObject.getString("success");
                        JSONArray jsonArray = jsonObject.getJSONArray("SignIn");

                        if (success.equals("1")) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Toast.makeText(LogIn.this, "Log In Success", Toast.LENGTH_SHORT).show();
                                if (edtEmail.getText().toString().equals("adminbimsi@gmail.com") && edtPassword.getText().toString().equals("akuadminbimsi")) {
                                    Intent intent = new Intent(getApplicationContext(), ReadAdmin.class);
                                    startActivity(intent);

                                } else {
                                    Intent intent = new Intent(getApplicationContext(), Button.class);
                                    startActivity(intent);
                                }
                            }

                        } else if (success.equals("0")) {
                            Toast.makeText(LogIn.this, "Wrong Email/Password", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(LogIn.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LogIn.this, "Error"+error.toString(), Toast.LENGTH_SHORT).show();
                }
            })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email",email);
                params.put("password",password);
                return params;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(LogIn.this);
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);


    }
}