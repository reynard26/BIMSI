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

public class EditNotes extends AppCompatActivity {
    private long id;
    private String namaPengingat;
    private String pengingat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
        final EditText edtNamaPengingat = (EditText)findViewById(R.id.edtNamaPengingat);
        final EditText edtPengingat = (EditText)findViewById(R.id.edtPengingat);
        Button btnKembali = (Button)findViewById(R.id.btnBatal);
        Button btnEditNotes = (Button)findViewById(R.id.btnEditNotes);

        //Buat objek untuk Class MyDBHandler
        final dbHandlerNote MydbHandler = new dbHandlerNote(this);

        //Membuka koneksi database
        try{
            MydbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }

        Bundle bundle = this.getIntent().getExtras();
        id = bundle.getLong("id");
        namaPengingat = bundle.getString("namaPengingat");
        pengingat = bundle.getString("Pengingat");

        this.setTitle("Edit Notes ID: "+id);
        edtNamaPengingat.setText(namaPengingat);
        edtPengingat.setText(pengingat);

        btnEditNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentNote StudentNote = new StudentNote();
                StudentNote.set_id(id);
                StudentNote.set_namaPengingat(edtNamaPengingat.getText().toString());
                StudentNote.set_pengingat(edtPengingat.getText().toString());
                MydbHandler.updatePengingat(StudentNote);

                Toast.makeText(EditNotes.this, "Student Note berhasil diedit", Toast.LENGTH_LONG).show();

                Intent i = new Intent(EditNotes.this, StudentNotes.class);
                startActivity(i);
                EditNotes.this.finish();
                MydbHandler.close();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EditNotes.this, StudentNotes.class);
                startActivity(i);
                EditNotes.this.finish();
                MydbHandler.close();
            }
        });

    }
}