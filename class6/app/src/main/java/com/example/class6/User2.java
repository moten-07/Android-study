package com.example.class6;

import android.os.Parcel;
import android.os.Parcelable;

public class User2 implements Parcelable {
    private String name;
    private  String password;

    public User2(String name,String password){
        this.name=name;
        this.password=password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getPassword());
    }
    public static  Creator<User2> CREATOR =new Creator<User2>() {
        @Override
        public User2 createFromParcel(Parcel source) {
            return new User2(source.readString(),source.readString());
        }

        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
