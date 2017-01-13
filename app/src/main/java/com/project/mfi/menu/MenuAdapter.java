package com.project.mfi.menu;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.mfi.app.R;

import java.util.List;

/**
 * Created by root on 10/01/17.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    List<MenuModel> menuModels;

    public MenuAdapter(List<MenuModel> menuModels) {
        this.menuModels = menuModels;
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.setImageResource(menuModels.get(position).getImage());
        holder.title.setText(menuModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        ImageView image;



        public ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    }
