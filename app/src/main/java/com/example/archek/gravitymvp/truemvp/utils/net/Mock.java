package com.example.archek.gravitymvp.truemvp.utils.net;

import com.google.gson.annotations.SerializedName;

public class Mock {
    private Integer id;
    private String name;
    @SerializedName("available_stock")
    private Integer availableStock;
    private String image;
    private Boolean isFavorite;
    private Integer price;
    private String city;
    private String description;
    private String latitude;
    private String longitude;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAvailableStock() {
        return availableStock;
    }

    public String getImage() {
        return image;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
