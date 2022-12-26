package projectc1.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import projectc1.com.Reservation.Detail;
import projectc1.com.Item.Tutor;
import projectc1.com.R;

public class TutorAdapter extends RecyclerView.Adapter<TutorAdapter.TutorViewHolder>{

    private Context context;
    private List<Tutor> tutorList;

    public TutorAdapter(Context context, List<Tutor> tutorList) {

        this.context = context;
        this.tutorList = tutorList;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.tutor_row, parent, false);

        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {

        final Tutor tutor = tutorList.get(position);

        holder.namaTutor.setText(tutorList.get(position).getNamaTutor());
        Glide.with(context)
                .load(tutor.getGambar())
                .into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, Detail.class);

                i.putExtra("kode_kelas", tutorList.get(position).getKode_kelas());
                i.putExtra("kode_namasubject", tutorList.get(position).getKode_namasubject());
                i.putExtra("namaTutor", tutorList.get(position).getNamaTutor());
                i.putExtra("jadwal", tutorList.get(position).getJadwal());
                i.putExtra("stok", tutorList.get(position).getStok());
                i.putExtra("harga", tutorList.get(position).getHarga());
                i.putExtra("gambar", tutorList.get(position).getGambar());
                i.putExtra("note", tutorList.get(position).getNote());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tutorList.size();
    }

    public static class TutorViewHolder extends RecyclerView.ViewHolder{

        private TextView namaTutor;
        private ImageView gambar;

        public TutorViewHolder(@NonNull View view) {
            super(view);
            namaTutor = view.findViewById(R.id.namatutor);
            gambar = view.findViewById(R.id.gambar);
        }
    }

}
