package com.applestyle.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.*;
import java.util.*;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private RecyclerView rvApps, rvDock;
    private TextView tvClock, tvDate, tvGreeting, tvFocusedAppName;
    private AppAdapter appAdapter;
    private DockAdapter dockAdapter;
    private int currentFocusedRow = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvClock = findViewById(R.id.tv_clock);
        tvDate = findViewById(R.id.tv_date);
        tvGreeting = findViewById(R.id.tv_greeting);
        tvFocusedAppName = findViewById(R.id.tv_focused_app_name);
        rvApps = findViewById(R.id.rv_apps);
        rvDock = findViewById(R.id.rv_dock);

        setupClock();
        setupApps();
        setupDock();
    }

    private void setupClock() {
        // Implementation for real-time clock would go here
        tvClock.setText("8:42 PM");
        tvDate.setText("Friday, October 24");
        tvGreeting.setText("Good Evening");
    }

    private void setupApps() {
        List<AppTile> apps = new ArrayList<>();
        // Logic to fetch installed apps excluding self
        // For now, dummy data
        apps.add(new AppTile("Netflix", "com.netflix.ninja"));
        apps.add(new AppTile("Apple TV", "com.apple.atve.amazon.appletv"));
        apps.add(new AppTile("Prime Video", "com.amazon.primevideo.android"));
        apps.add(new AppTile("Hotstar", "in.startv.hotstar"));
        apps.add(new AppTile("YouTube", "com.google.android.youtube"));
        apps.add(new AppTile("Twitch", "tv.twitch.android.viewer"));
        apps.add(new AppTile("Discovery+", "com.discoveryplus.tv.fire"));
        apps.add(new AppTile("SonyLIV", "com.onemainstream.sonyliv.android"));

        appAdapter = new AppAdapter(apps);
        rvApps.setLayoutManager(new GridLayoutManager(this, 4));
        rvApps.setAdapter(appAdapter);
    }

    private void setupDock() {
        List<AppTile> dockApps = new ArrayList<>();
        dockApps.add(new AppTile("Netflix", "com.netflix.ninja"));
        dockApps.add(new AppTile("Apple TV", "com.apple.atve.amazon.appletv"));
        dockApps.add(new AppTile("Prime Video", "com.amazon.primevideo.android"));
        dockApps.add(new AppTile("Hotstar", "in.startv.hotstar"));

        dockAdapter = new DockAdapter(dockApps);
        rvDock.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDock.setAdapter(dockAdapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Custom deterministic D-pad logic
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                if (rvDock.isFocused()) {
                    rvApps.requestFocus();
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                if (rvApps.isFocused()) {
                    rvDock.requestFocus();
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
