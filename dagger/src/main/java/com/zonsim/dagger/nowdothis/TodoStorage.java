package com.zonsim.dagger.nowdothis;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * ^-^
 * Created by tang-jw on 8/6.
 */

public class TodoStorage {
    
    public static final String KEY_TODOS = "todos";
    
    private final Gson gson;
    
    private final SharedPreferences prefs;
    
    // @Inject构造方法
    @Inject
    public TodoStorage(Gson gson, SharedPreferences prefs) {
        this.gson = gson;
        this.prefs = prefs;
    }
    
    public void saveTodos(@NonNull String string) {
        String[] dirty = string.split("\n");
        ArrayList<String> clean = new ArrayList<>(dirty.length);
        for (String s : dirty) {
            s = s.trim();
            if (!TextUtils.isEmpty(s)) {
                clean.add(s);
            }
        }
        
        prefs.edit()
                .putString(KEY_TODOS, gson.toJson(clean))
                .apply();
    }
}
