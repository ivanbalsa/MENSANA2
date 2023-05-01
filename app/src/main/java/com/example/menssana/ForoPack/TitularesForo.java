package com.example.menssana.ForoPack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TitularesForo {
    //Estado
    @SerializedName("status")
    @Expose
    private String status;
    //Número de resultados totales
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    //Artículos
    @SerializedName("articles")
    @Expose
    private List<Articulos> articles;

    //Get y Set de las noticias (generados con Generate>Getter and Setter)

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Articulos> getArticles() {
        return articles;
    }

    public void setArticles(List<Articulos> articles) {
        this.articles = articles;
    }
}
