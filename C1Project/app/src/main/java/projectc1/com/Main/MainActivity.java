package projectc1.com.Main;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ClearCacheRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import projectc1.com.Matakuliah.*;
import projectc1.com.R;
import projectc1.com.sqllite.StudentNotes;
import projectc1.com.sqllite.tambah_studentnote;

public class MainActivity extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewMain = inflater.inflate(R.layout.fragment_main, container, false);

        ImageButton btnDataanals = (ImageButton) viewMain.findViewById(R.id.imageDataanal);
        btnDataanals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Data Analysis!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), dataanalysis.class);
                startActivity(i);
            }
        });

        ImageButton btnAccounting = (ImageButton) viewMain.findViewById(R.id.imageAccounting);
        btnAccounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Accounting!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), accounting.class);
                startActivity(i);
            }
        });

        ImageButton btnDatabase = (ImageButton) viewMain.findViewById(R.id.imageDatabase);
        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Database System!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), database.class);
                startActivity(i);
            }
        });

        ImageButton btnAlgoritm = (ImageButton) viewMain.findViewById(R.id.imageAlgorithm);
        btnAlgoritm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Algorithm and Data Structure!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), algorithm.class);
                startActivity(i);
            }
        });

        ImageButton btnMobile = (ImageButton) viewMain.findViewById(R.id.imageMobileapp);
        btnMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Mobile App Development!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), mobileapp.class);
                startActivity(i);
            }
        });

        ImageButton btnStudentNote = (ImageButton) viewMain.findViewById(R.id.imgStudentNote);
        btnStudentNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Move to Student Note!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), StudentNotes.class);
                startActivity(i);
            }
        });

        ImageView btnlogout = (ImageView) viewMain.findViewById(R.id.btnlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Anda Berhasil Keluar Dari Aplikasi!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), LogIn.class);
                startActivity(i);

            }
        });

        return viewMain;


    }



}