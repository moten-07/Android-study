package com.example.class23_3;

public class Goods {
    public int photo;
    public String name;
    public String ButtonText;

    public Goods(int photo, String name, String ButtonText){
        this.photo=photo;
        this.name=name;
        this.ButtonText=ButtonText;
    }
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getButtonText() {
        return ButtonText;
    }

    public void setButtonText(String buttonText) {
        ButtonText = buttonText;
    }
}
