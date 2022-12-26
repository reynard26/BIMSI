package projectc1.com.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projectc1.com.R;

public class tambah_studentnote extends AppCompatActivity {
    public static final int REQUEST_ADDNote = 999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_studentnote);


        final EditText edtPengingat = (EditText)findViewById(R.id.edtPengingat);
        final EditText edtPesan = (EditText)findViewById(R.id.edtPesan);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        Button btnAdd = (Button)findViewById(R.id.btnAdd);

        //Buat objek untuk Class MyDBHandler
        final dbHandlerNote MydbHandler = new dbHandlerNote(this);

        //Membuka koneksi database
        try{
            MydbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentNote studentNote = new StudentNote();
                String pengingat = edtPengingat.getText().toString();
                String pesan = edtPesan.getText().toString();
                MydbHandler.createNote(pengingat,pesan);

                Toast.makeText(tambah_studentnote.this, "Student Note berhasil ditambahkan", Toast.LENGTH_LONG).show();
                edtPengingat.setText("");
                edtPesan.setText("");
                edtPengingat.requestFocus();

                Intent i = new Intent(tambah_studentnote.this, StudentNotes.class);
                startActivity(i);
                tambah_studentnote.this.finish();
                MydbHandler.close();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPengingat.setText("");
                edtPengingat.setText("");
                edtPengingat.requestFocus();

                Intent i = new Intent(tambah_studentnote.this, StudentNotes.class);
                startActivity(i);
                tambah_studentnote.this.finish();
                MydbHandler.close();
            }
        });
    }
}