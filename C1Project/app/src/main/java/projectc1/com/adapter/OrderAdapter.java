package projectc1.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import projectc1.com.Admin.AdminOrder;
import projectc1.com.Item.Order;
import projectc1.com.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    private Context context;
        private List<Order> OrderList;

    public OrderAdapter(Context context, List<Order> OrderList) {

        this.context = context;
        this.OrderList = OrderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_row_item, parent, false);

        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        final Order order = OrderList.get(position);

        holder.tanggal_pemesanan.setText(OrderList.get(position).getTanggal_pemesanan());
        holder.kode_kelas.setText(OrderList.get(position).getKode_kelas());
        holder.nama_mahasiswa.setText(OrderList.get(position).getNama_mahasiswa());
        holder.line.setText(OrderList.get(position).getLine());
        holder.jangka_waktu.setText(OrderList.get(position).getJangka_waktu());
        holder.total.setText(OrderList.get(position).getTotal());
        holder.notes.setText(OrderList.get(position).getNotes());


    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        private TextView tanggal_pemesanan, kode_kelas, nama_mahasiswa, line ,jangka_waktu, total, notes;

        public OrderViewHolder(@NonNull View view) {
            super(view);
            tanggal_pemesanan = view.findViewById(R.id.txtTglPemesanan);
            kode_kelas = view.findViewById(R.id.txtKodeKelas);
            nama_mahasiswa = view.findViewById(R.id.nama_mahasiswa);
            line = view.findViewById(R.id.line);
            jangka_waktu = view.findViewById(R.id.txtJangkawaktu);
            total = view.findViewById(R.id.txtTotal);
            notes = view.findViewById(R.id.txtNotes);



        }
    }
}
