package com.example.lunajomobile;

public class DesignItem {

    private String designerName;
    private int designImageResource;
    private String designDescription;

    public DesignItem(String designerName, int designImageResource, String designDescription) {
        this.designerName = designerName;
        this.designImageResource = designImageResource;
        this.designDescription = designDescription;
    }

    public String getDesignerName() {
        return designerName;
    }

    public int getDesignImageResource() {
        return designImageResource;
    }

    public String getDesignDescription() {
        return designDescription;
    }
}