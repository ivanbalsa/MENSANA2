package com.example.menssana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.menssana.ForoPack.Articulos;
import com.example.menssana.ForoPack.TitularesForo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Foro extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    EditText busqueda;
    Button button7;
    final String apiKey = "62900a256e2544b38434c7c0bc3e9b03";
    List<Articulos> articles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        busqueda = findViewById(R.id.busqueda);
        button7 = findViewById(R.id.button7);
        String country = getCountry();
        getJSON("",country,apiKey);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!busqueda.getText().toString().equals("")){
                    getJSON(busqueda.getText().toString(),country,apiKey);
                }else{

                }
            }
        });
    }
    public void getJSON(String busqueda, String country, String apiKey){
        //Método para obtener la info JSON de la API
        Call<TitularesForo> titularesForoCall;
        if (busqueda.equals("")){
            titularesForoCall = ClienteAPIForo.getInstance().getApi().getTitulares(country,apiKey);
        }else{
            titularesForoCall = ClienteAPIForo.getInstance().getApi().getBusqueda(busqueda,apiKey);
        }
        titularesForoCall.enqueue(new Callback<TitularesForo>() {
            @Override
            public void onResponse(Call<TitularesForo> call, Response<TitularesForo> response) {
                if (response.isSuccessful() && response.body().getArticles() != null){
                    //Si las noticias se han cargado bien y hay al menos una:
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(Foro.this, articles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TitularesForo> call, Throwable t) {
                Toast.makeText(Foro.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }

}