package com.example.menssana.citas.ListaCitasAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menssana.R;
import com.example.menssana.citas.VerActivity;
import com.example.menssana.db.Citas;

import java.util.ArrayList;

public class ListaCitasAdapter extends RecyclerView.Adapter<ListaCitasAdapter.CitaViewHolder> {

    static ArrayList<Citas> listaCitas;



    public ListaCitasAdapter(ArrayList<Citas> listaCitas){
        this.listaCitas = listaCitas;
    }


    @NonNull
    @Override
    public CitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_cita, null, false);
        return new CitaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitaViewHolder holder, int position) {

    holder.viewLugar.setText(listaCitas.get(position).getLugar());
    holder.viewFecha.setText(listaCitas.get(position).getFecha());


    }

    @Override
    public int getItemCount() {

        return listaCitas.size();
    }

    public static class CitaViewHolder extends RecyclerView.ViewHolder {

        TextView viewLugar, viewFecha;
        public CitaViewHolder(@NonNull View itemView) {
            super(itemView);
            viewLugar = itemView.findViewById(R.id.viewLugar);
            viewFecha = itemView.findViewById(R.id.viewFecha);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = viewFecha.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listaCitas.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}
