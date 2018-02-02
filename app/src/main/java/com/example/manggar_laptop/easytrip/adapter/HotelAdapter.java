package com.example.manggar_laptop.easytrip.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.manggar_laptop.easytrip.DetailHotelActivity;
import com.example.manggar_laptop.easytrip.DetailPariwisataActivity;
import com.example.manggar_laptop.easytrip.R;
import com.example.manggar_laptop.easytrip.model.hotel;
import com.example.manggar_laptop.easytrip.model.wisata;

import java.util.List;

/**
 * Created by MANGGAR-LAPTOP on 1/14/2018.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private Context context;
    private List<hotel> listMenuHotel;

    public HotelAdapter(Context context, List<hotel> listMenuHotel) {
        this.context = context;
        this.listMenuHotel = listMenuHotel;
    }

    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hotel,parent,false);
        return new HotelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelAdapter.ViewHolder holder, int position) {
        final hotel kamar = listMenuHotel.get(position);
        holder.TxtHotel.setText(kamar.getNama_hotel());
        holder.TxtAlamat.setText(kamar.getAlamat());
        holder.TxtHarga.setText(kamar.getharga());
        holder.TxtHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailHotelActivity.class);
                i.putExtra("idHotel", kamar.getId_hotel());
                i.putExtra("namaHotel",kamar.getNama_hotel());
                i.putExtra("alamat",kamar.getAlamat());
                i.putExtra("harga",kamar.getharga());
                v.getContext().startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listMenuHotel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView TxtHotel,TxtAlamat,TxtHarga;
        public ViewHolder(View itemView) {
            super(itemView);
            TxtHotel = itemView.findViewById(R.id.txtHotel);
            TxtAlamat = itemView.findViewById(R.id.txtAlamat);
            TxtHarga = itemView.findViewById(R.id.txtHarga);
        }
    }
}

