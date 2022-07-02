package com.example.petagramlite;

public class Pet {
    private String name;
    private String rating;
    private int photo;

    public Pet(String name, String rating, int photo) {
        this.name = name;
        this.rating = rating;
        this.photo = photo;
    }

    public void like(){
        int num_rating = Integer.parseInt(this.rating) + 1;
        this.rating = Integer.toString(num_rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}