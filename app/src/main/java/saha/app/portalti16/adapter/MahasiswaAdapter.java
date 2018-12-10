package saha.app.portalti16.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import saha.app.portalti16.entity.Mahasiswa;
import saha.app.portalti16.holder.MahasiswaHolder;
import saha.app.portalti16.R;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

    private List<Mahasiswa> mahasiswas;
    private MahasiswaListener listener;

    public MahasiswaAdapter(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public void setListener(MahasiswaListener listener) {
        this.listener = listener;
    }

    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        final MahasiswaHolder mahasiswaHolder = new MahasiswaHolder(itemView);

        return mahasiswaHolder;
    }

    @Override
    public void onBindViewHolder(MahasiswaHolder holder, final int position) {
        holder.txtNama.setText(mahasiswas.get(position).getName());
        holder.txtNim.setText(mahasiswas.get(position).getNim());

        //tambahkan fungsi delete
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDelete(mahasiswas.get(position).getId());

            }
        });
}

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }

    public interface MahasiswaListener {
        void onDelete(int mhsId);

    }
}
