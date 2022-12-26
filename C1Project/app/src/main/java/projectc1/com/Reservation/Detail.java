package projectc1.com.Reservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.text.NumberFormat;
import java.util.Locale;

import projectc1.com.R;

public class Detail extends AppCompatActivity {

    private TextView mNamaTutor, mKode_kelas, mStok, mHarga, mNote, mJadwal;
    private ImageView mGambar;
    private Button btnBuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Tutor BIMSI");

        mGambar = findViewById(R.id.gambar);
        mNamaTutor = findViewById(R.id.namaTutor);
        mKode_kelas = findViewById(R.id.kode_kelas);
        mJadwal = findViewById(R.id.jadwal);
        mStok = findViewById(R.id.stok);
        mHarga = findViewById(R.id.harga);
        mNote = findViewById(R.id.note);

        btnBuy = findViewById(R.id.btnBuy);

        Intent i = getIntent();
        String gambar = i.getStringExtra("gambar");
        String namaTutor = i.getStringExtra("namaTutor");
        String jadwal = i.getStringExtra("jadwal");
        String kode_kelas = i.getStringExtra("kode_kelas");
        String stok = i.getStringExtra("stok");
        String harga = i.getStringExtra("harga");
        String note = i.getStringExtra("note");

        if (i !=null){

            mNamaTutor.setText(namaTutor);
            mKode_kelas.setText(kode_kelas);
            mJadwal.setText(jadwal);
            mStok.setText(stok);
            String detailHarga = (formatRupiah(Double.parseDouble(String.valueOf(harga))));
            mHarga.setText(detailHarga);
            mNote.setText(note);
            Glide.with( Detail.this).load(gambar).into(mGambar);
        }

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Detail.this, FormPembelian.class);

                i.putExtra("kode_kelas", kode_kelas);
                i.putExtra("namaTutor", namaTutor);
                i.putExtra("jadwal", jadwal);
                i.putExtra("stok", stok);
                i.putExtra("harga", harga);

                startActivity(i);
            }
        });



    }
    private String formatRupiah(Double number) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }
}
