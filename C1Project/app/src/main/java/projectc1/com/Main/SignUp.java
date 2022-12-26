package projectc1.com.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import projectc1.com.R;

public class SignUp extends AppCompatActivity {
    EditText edtNamaFull, edtNickname, edtEmail, edtPassword, edtPhone, edtYoc;
    View btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        edtNamaFull = findViewById(R.id.edtNamaFull);
        edtNickname = findViewById(R.id.edtNickname);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
        edtYoc = findViewById(R.id.edtYoc);

        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NamaFull, nickname, email, password, phone, yoc;
                NamaFull = String.valueOf(edtNamaFull.getText());
                nickname = String.valueOf(edtNickname.getText());
                email = String.valueOf(edtEmail.getText());
                password = String.valueOf(edtPassword.getText());
                phone = String.valueOf(edtPhone.getText());
                yoc = String.valueOf(edtYoc.getText());
         if(!NamaFull.equals("") && !nickname.equals("") && !email.equals("") && !password.equals("") && !phone.equals("") && !yoc.equals("") ) {

             Handler handler = new Handler(Looper.getMainLooper());
             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     String [] field  = new String[6];
                     field[0] = "NamaFull";
                     field[1] = "nickname";
                     field[2] = "email";
                     field[3] = "password";
                     field[4] = "phone";
                     field[5] = "yoc";

                     String[] data = new String[6];
                     data[0] = NamaFull;
                     data[1] = nickname;
                     data[2] = email;
                     data[3] = password;
                     data[4] = phone;
                     data[5] = yoc;

                     PutData putData = new PutData ("https://bimbelhimsi.000webhostapp.com/BIMBEL/SignUp.php", "POST",field, data);
                     if(putData.startPut()) {
                         if(putData.onComplete()) {
                             String result = putData.getResult();
                             if (result.equals("SignUp Success")) {
                                 Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                             }else {
                                 Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                 Intent intent = new Intent(getApplicationContext(), LogIn.class);
                                 startActivity(intent);
                             }
                         }
                     }

                 }
             });
         } else {
             Toast.makeText(getApplicationContext(), "All fields must be filled", Toast.LENGTH_SHORT).show();
         }
            }
        });
    }
}