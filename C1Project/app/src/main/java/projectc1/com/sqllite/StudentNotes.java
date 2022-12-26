package projectc1.com.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import projectc1.com.Matakuliah.dataanalysis;
import projectc1.com.R;
import projectc1.com.forum.Forum;
import projectc1.com.forum.TambahForum;

import static projectc1.com.forum.TambahForum.REQUEST_ADD;
import static projectc1.com.sqllite.tambah_studentnote.REQUEST_ADDNote;


public class StudentNotes extends ListActivity implements AdapterView.OnItemLongClickListener{
    private dbHandlerNote MydbHandler;
    private ArrayList<StudentNote> values;
    private Button btnEditNotes;
    private Button btnDeleteNotes;
    private ListView list;
    Context context = this;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notes);

        back = (ImageButton) findViewById(R.id.buttonBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Back = new Intent(StudentNotes.this, projectc1.com.Button.class);
                startActivity(Back);
            }
        });


        //Buat objek untuk Class MyDBHandler
        MydbHandler = new dbHandlerNote(this);

        //Membuka koneksi database
        try{
            MydbHandler.open();
        }catch (SQLException e){
            e.printStackTrace();
        }

        values = MydbHandler.getStudentNote();

        ArrayAdapter<StudentNote> adapter = new ArrayAdapter<StudentNote>(this, android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        list = (ListView)findViewById(android.R.id.list);
        list.setOnItemLongClickListener(this);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), tambah_studentnote.class);
                startActivity(i);
            }
        });
    }


    //Method yang digunakan jika ListView ditekan agak lama
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Menampilkan dialog dan mengambil layout dari dialog.xml
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("Choose one");
        dialog.show();

        final StudentNote studentNote = (StudentNote) getListAdapter().getItem(i);
        final long id = studentNote.get_id();

        btnEditNotes = dialog.findViewById(R.id.btnEditDialog);
        btnDeleteNotes = dialog.findViewById(R.id.btnHapus);

        //Method yang digunakan jika Button Edit pada dialog.xml ditekan

        btnEditNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentNote Note = MydbHandler.getNote(id);
                Intent i = new Intent(getApplicationContext(), EditNotes.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id", Note.get_id());
                bundle.putString("namaPengingat", Note.get_namaPengingat());
                bundle.putString("Pengingat", Note.get_pengingat());
                i.putExtras(bundle);
                startActivity(i);
                dialog.dismiss();
            }
        });

        //Method yang digunakan jika Button Delete pada dialog.xml ditekan
        btnDeleteNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder konfirm = new AlertDialog.Builder(context);
                konfirm.setTitle("Hapus Student Note");
                konfirm.setMessage("Anda yakin akan menghapus Student Note ini?");
                konfirm.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MydbHandler.deleteNote(id);


                        finish();
                        startActivity(getIntent());

                        Toast.makeText(StudentNotes.this, "Student Note berhasil dihapus", Toast.LENGTH_LONG).show();
                    }
                });
                konfirm.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                konfirm.show();
                dialog.dismiss();
            }
        });
        return true;
    }
}