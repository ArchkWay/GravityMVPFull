package com.example.archek.gravitymvp.truemvp.utils;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.archek.gravitymvp.R;
import com.example.archek.gravitymvp.truemvp.utils.net.Mock;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GravityAdapter extends RecyclerView.Adapter<GravityAdapter.ViewHolder> {

    private final List<Mock> mocks = new ArrayList<>();//main list for results to adapter
    private final Callback callback;

    public GravityAdapter(Callback callback) { //Конструктор с колбэком
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item, parent, false);
        final ViewHolder holder = new ViewHolder(itemView); //set on click listener(launch map)
        holder.tvDescription.setMovementMethod(new ScrollingMovementMethod());
        itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mock mock  = mocks.get(holder.getAdapterPosition());
                callback.onMockClick(mock);
            }
        } );
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Mock mock = mocks.get(position);
        Picasso.get().load(mock.getImage()).into(holder.ivPhoto);
        holder.tvId.setText(mock.getId().toString());
        holder.tvName.setText(mock.getName());
        holder.tvCity.setText(mock.getCity());
        holder.tvCost.setText(mock.getPrice().toString());
        holder.tvDescription.setText(mock.getDescription());

    }

    @Override
    public int getItemCount() {
        return mocks.size();
    } //count all items

    public void replaceAll(List<Mock> mocksToReplace) {//load all mocks in main list
        mocks.clear();
        mocks.addAll(mocksToReplace);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivPhoto; //instal all views in holder
        private final TextView tvId;
        private final TextView tvName;
        private final TextView tvCity;
        private final TextView tvCost;
        private final TextView tvDescription;

        @SuppressLint("ResourceAsColor")
        private ViewHolder(View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);//initiate views
            tvId = itemView.findViewById(R.id.tvID);
            tvName = itemView.findViewById(R.id.tvName);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvCost = itemView.findViewById(R.id.tvCost);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvName.setTextColor(R.color.colorAccent);
        }
    }
    public interface Callback{
        void onMockClick(Mock mock);
    }

}
