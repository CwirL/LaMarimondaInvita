package com.example.lamarimondainvita;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Event> mData;
    private List<Event> mDataCopy;

    public RecyclerViewAdapter(Context mContext, List<Event> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataCopy = new ArrayList<>(mData);

    }

    public void filter(String text) {
        mData.clear();
        if(text.isEmpty()){
            System.out.println("here");
            mData.addAll(mDataCopy);
        } else{
            text = text.toLowerCase();
            System.out.println(text);
            for(Event event: mDataCopy){
                System.out.print(event.getName().toLowerCase() + " " + text.toLowerCase());
                if(event.getName().toLowerCase().startsWith(text.toLowerCase())){
                    mData.add(event);
                    notifyItemInserted(mData.indexOf(event));
                }
            }
            System.out.println(mData.size());
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.event_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.event_title.setText(mData.get(position).getName());
        holder.img_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, eventActivity.class);
                intent.putExtra("Title", mData.get(position).getName());
                intent.putExtra("Location", mData.get(position).getLocation());
                intent.putExtra("Date", mData.get(position).getDate());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                intent.putExtra("Valor", mData.get(position).getValor());
                intent.putExtra("Reto", mData.get(position).getReto());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView event_title;
        ImageView img_thumbnail;
        CardView item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_title = (TextView) itemView.findViewById(R.id.event_title);
            img_thumbnail = (ImageView) itemView.findViewById(R.id.event_img);
            item = (CardView) itemView.findViewById(R.id.event_item);
        }
    }
}
