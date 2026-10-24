package com.applestyle.launcher;

import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.*;
import android.content.Intent;

public class DockAdapter extends RecyclerView.Adapter<DockAdapter.ViewHolder> {
    private List<AppTile> apps;

    public DockAdapter(List<AppTile> apps) {
        this.apps = apps;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, ViewGroup holder) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dock_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppTile app = apps.get(position);
        holder.tvName.setText(app.name);
        holder.itemView.setFocusable(true);
        holder.itemView.setClickable(true);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.setClassName(app.packageName, null);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return apps.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ViewHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tv_app_name);
        }
    }
}
