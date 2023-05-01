package com.example.menssana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menssana.ForoPack.Articulos;
import com.squareup.picasso.Picasso;
import android.content.Intent;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Articulos> articles;

    //Generamos constructor (Generate>Constructor)
    public Adapter(Context context, List<Articulos> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticias, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final Articulos art = articles.get(position);
        holder.tituloscard.setText(art.getTitle());
        holder.fuentescard.setText(art.getSource().getName());
        holder.fechascard.setText(art.getPublishedAt());
        String urlportada = art.getUrlToImage();
        String url = art.getUrl();
        Picasso.with(context).load(urlportada).into(holder.portada);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, noticiaCompleta.class);
                intent.putExtra("title",art.getTitle());
                intent.putExtra("source",art.getSource().getName());
                intent.putExtra("description",art.getDescription());
                intent.putExtra("publishedAt",art.getPublishedAt());
                intent.putExtra("urlportada",art.getUrlToImage());
                intent.putExtra("url",art.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fuentescard, fechascard, tituloscard;
        ImageView portada;
        CardView cardview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloscard = itemView.findViewById(R.id.tituloscard);
            fechascard = itemView.findViewById(R.id.fechascard);
            fuentescard = itemView.findViewById(R.id.fuentescard);
            portada = itemView.findViewById(R.id.portada);
            cardview = itemView.findViewById(R.id.cardview);

        }
    }
}
