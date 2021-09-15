package com.example.ptsganjil202111rpl1samy22.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ptsganjil202111rpl1samy22.Activity.DetailActivity;
import com.example.ptsganjil202111rpl1samy22.Model.SportModel;
import com.example.ptsganjil202111rpl1samy22.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.SportViewHolder> {
    public List<SportModel> sportModels;
    Context context;


    public SportAdapter(List<SportModel> sportModels, Context context) {
        this.sportModels = sportModels;
        this.context = context;
    }


    @NonNull
    @Override
    public SportAdapter.SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new SportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.SportViewHolder holder, int position) {
        holder.sportname.setText(sportModels.get(position).getSportName());
        holder.sportformat.setText(sportModels.get(position).getSportFormat());
        String url = sportModels.get(position).getSportPic();
        Glide.with(context)
                .load(url)
                .into(holder.sportpic);
        holder.sportCv.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id", sportModels.get(position).getId());
            intent.putExtra("sportName", sportModels.get(position).getSportName());
            intent.putExtra("sportFormat", sportModels.get(position).getSportFormat());
            intent.putExtra("sportDescription", sportModels.get(position).getSportDescription());
            intent.putExtra("sportPic", sportModels.get(position).getSportPic());
            context.startActivities(new Intent[]{intent});
        });
    }

    @Override
    public int getItemCount() {
        return sportModels.size();
    }

    public class SportViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

        TextView sportname, sportformat;
        CardView sportCv;
        ImageView sportpic;


        public SportViewHolder(@NonNull View dataView) {
            super(dataView);
            sportname = dataView.findViewById(R.id.sport_Name);
            sportformat = dataView.findViewById(R.id.format_Sport);
            sportCv = dataView.findViewById(R.id.cv_sport);
            sportpic = dataView.findViewById(R.id.sport_Pic);

            sportCv.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(R.menu.menu, R.id.option1, 1, "Edit").setOnMenuItemClickListener(this);
            menu.add(R.menu.menu, R.id.option2, 2, "Delete").setOnMenuItemClickListener(this);


        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.option1:
                    Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.option2:
                    Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show();


            }
            return false;
        }
    }






}
