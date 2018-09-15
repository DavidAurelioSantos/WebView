package com.example.david.revisao.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.revisao.Model.Result;
import com.example.david.revisao.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DavidAdapter extends RecyclerView.Adapter<DavidAdapter.ViewHolder> {

    List<Result> resultList;
    Context context;

    public DavidAdapter(List<Result> resultList, Context context){
        this.resultList = resultList;
        this.context = context;

    }

    @NonNull
    @Override
    public DavidAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DavidAdapter.ViewHolder holder, int position) {
        Result result = resultList.get(position);
        holder.bind(result.getTitle(),result.getBackdropPath());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.titleTextView);
            this.image = itemView.findViewById(R.id.image);
        }

        public void bind(String titulo, String endPointImage){
            this.title.setText(titulo);
            String path = "https://image.tmdb.org/t/p/w780";
            Picasso.get().load(path+endPointImage).into(this.image);
        }
    }
}
