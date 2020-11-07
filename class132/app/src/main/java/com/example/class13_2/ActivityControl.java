package com.example.class13_2;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityControl {
    public static List<Activity> list=new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        list.add(activity);
    }
    public static void removeActivity(Activity activity){
        list.remove(activity);
    }
    public static void fishAll(){
        for (int i=0;i<list.size();i++){
            if(!(list.get(i).isFinishing())){
                list.get(i).finish();
            }
        }
        list.clear();
    }
}
