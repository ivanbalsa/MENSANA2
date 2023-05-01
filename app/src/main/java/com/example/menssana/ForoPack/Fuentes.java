package com.example.menssana.ForoPack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fuentes {
    //IDs
    @SerializedName("id")
    @Expose
    private String id;
    //Nombre de la fuente
    @SerializedName("name")
    @Expose
    private String name;

    //Getter y Setter (creados con Generate)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
