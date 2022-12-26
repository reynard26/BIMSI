package projectc1.com.Matakuliah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import projectc1.com.Reservation.Reservation;
import projectc1.com.R;

public class database extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        final Spinner spinJadwal2 = findViewById(R.id.spinJadwal2);
        Button reserve2 = findViewById(R.id.reserve2);

        reserve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Pindah Invoice untuk Reserve " + spinJadwal2.getSelectedItem(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Reservation.class));

            }
        });
    }
}