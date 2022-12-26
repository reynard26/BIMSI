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

import projectc1.com.Admin.UpdateAdmin;
import projectc1.com.Item.Read;
import projectc1.com.R;

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.ReadViewHolder>{

    private Context context;
    private List<Read> ReadList;

    public ReadAdapter(Context context, List<Read> ReadList) {

        this.context = context;
        this.ReadList = ReadList;
    }

    @NonNull
    @Override
    public ReadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.read_rowtutor, parent, false);

        return new ReadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadViewHolder holder, int position) {

        final Read read = ReadList.get(position);

        holder.namaTutor.setText(ReadList.get(position).getNamaTutor());
        Glide.with(context)
                .load(read.getGambar())
                .into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, UpdateAdmin.class);

                i.putExtra("kode_kelas", ReadList.get(position).getKode_kelas());
                i.putExtra("kode_namasubject", ReadList.get(position).getKode_namasubject());
                i.putExtra("kode_tutor", ReadList.get(position).getKode_tutor());
                i.putExtra("namaTutor", ReadList.get(position).getNamaTutor());
                i.putExtra("jadwal", ReadList.get(position).getJadwal());
                i.putExtra("stok", ReadList.get(position).getStok());
                i.putExtra("harga", ReadList.get(position).getHarga());
                i.putExtra("gambar", ReadList.get(position).getGambar());
                i.putExtra("note", ReadList.get(position).getNote());

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ReadList.size();
    }

    public class ReadViewHolder extends RecyclerView.ViewHolder {
        private TextView namaTutor;
        private ImageView gambar;

        public ReadViewHolder(@NonNull View view) {
            super(view);
            namaTutor = view.findViewById(R.id.namatutor);
            gambar = view.findViewById(R.id.gambar);
        }

    }
}
