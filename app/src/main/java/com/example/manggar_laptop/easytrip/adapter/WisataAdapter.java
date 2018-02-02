package com.example.manggar_laptop.easytrip.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manggar_laptop.easytrip.DetailPariwisataActivity;
import com.example.manggar_laptop.easytrip.R;
import com.example.manggar_laptop.easytrip.model.wisata;

import java.util.List;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    private Context context;
    private List<wisata> listWisata;

    public WisataAdapter(Context context, List<wisata> listMenuRestoren) {
        this.context = context;
        this.listWisata = listMenuRestoren;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata,parent,false);
        return new WisataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final wisata menu = listWisata.get(position);
        holder.TxtWisata.setText(menu.getNama_wisata());
        holder.TxtLokasi.setText(menu.getLokasi());
        holder.TxtTiket.setText(menu.getTiket());
        holder.TxtWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailPariwisataActivity.class);
                i.putExtra("idWisata",menu.getId_wisata());
                i.putExtra("namaWisata",menu.getNama_wisata());
                i.putExtra("lokasi",menu.getLokasi());
                i.putExtra("tiket",menu.getTiket());
                v.getContext().startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TxtWisata,TxtLokasi,TxtTiket;
        public ViewHolder(View itemView) {
            super(itemView);
            TxtWisata = itemView.findViewById(R.id.txtWisata);
            TxtLokasi = itemView.findViewById(R.id.txtLokasi);
            TxtTiket = itemView.findViewById(R.id.txtTiket);
        }
    }
}
