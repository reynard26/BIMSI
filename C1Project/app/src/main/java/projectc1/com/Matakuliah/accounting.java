package projectc1.com.Matakuliah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import projectc1.com.Reservation.Reservation;
import projectc1.com.R;

public class accounting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);
        final Spinner spinJadwal5 = findViewById(R.id.spinJadwal5);
        Button reserve5 = findViewById(R.id.reserve5);

        reserve5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Pindah Invoice untuk Reserve " + spinJadwal5.getSelectedItem(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Reservation.class));

            }
        });
    }
}