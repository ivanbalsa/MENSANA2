package com.example.menssana.ForoPack;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articulos {
    //Fuente
    @SerializedName("source")
    @Expose
    private Fuentes source;
    //Autor
    @SerializedName("author")
    @Expose
    private String author;
    //Título
    @SerializedName("title")
    @Expose
    private String title;
    //Resumen
    @SerializedName("description")
    @Expose
    private String description;
    //Enlace a cada imagen
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    //Fecha
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    //URL de la imagen
    @SerializedName("url")
    @Expose
    private String url;

//Getter y Setter (con Generate)

    public Fuentes getSource() {
        return source;
    }

    public void setSource(Fuentes source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() { return publishedAt; }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }


    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }
}
