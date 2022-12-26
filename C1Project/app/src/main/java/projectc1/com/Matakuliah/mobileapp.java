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

public class mobileapp extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_app);
        final Spinner spinJadwal3 = findViewById(R.id.spinJadwal3);
        Button reserve3 = findViewById(R.id.reserve3);

        reserve3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(),"Pindah Invoice untuk Reserve " + spinJadwal3.getSelectedItem(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Reservation.class));

            }
        });
    }
}