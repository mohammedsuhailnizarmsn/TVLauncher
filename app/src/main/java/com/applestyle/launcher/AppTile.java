package com.applestyle.launcher;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class AppTile {
    public String name;
    public String packageName;
    public int iconRes;

    public AppTile(String name, String packageName) {
        this.name = name;
        this.packageName = packageName;
    }
}
