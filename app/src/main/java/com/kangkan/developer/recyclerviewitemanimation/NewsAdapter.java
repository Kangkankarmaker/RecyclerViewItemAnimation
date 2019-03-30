package com.kangkan.developer.recyclerviewitemanimation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements Filterable{

    Context context;
    List<NewsItem> mData;
    List<NewsItem> mDataFilter;

    boolean isDark=false;

    public NewsAdapter(Context context, List<NewsItem> mData, boolean isDark) {
        this.context = context;
        this.mData = mData;
        this.isDark = isDark;
        this.mDataFilter= mData;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

      View layout;
      layout= LayoutInflater.from(context).inflate(R.layout.iten_news,viewGroup,false);

        return new  NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {


        newsViewHolder.imageView.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_trans));
        newsViewHolder.relativeLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_anim));

        newsViewHolder.tv_title.setText(mDataFilter.get(position).getTitle());
        newsViewHolder.tv_content.setText(mDataFilter.get(position).getContent());
        newsViewHolder.tv_date.setText(mDataFilter.get(position).getDate());
        newsViewHolder.imageView.setImageResource(mDataFilter.get(position).getUserPhoto());


    }

    @Override
    public int getItemCount() {
        return mDataFilter.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key=constraint.toString();
                if (key.isEmpty()){
                    mDataFilter=mData;
                }else {
                    List<NewsItem>isFiltered =new ArrayList<>();
                    for (NewsItem row : mData){
                        if (row.getTitle().toLowerCase().contains(key.toLowerCase())){
                            isFiltered.add(row);
                        }
                    }
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=mDataFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDataFilter=(List<NewsItem>)results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{



        TextView tv_title,tv_content,tv_date;
        ImageView imageView;

        RelativeLayout relativeLayout;



        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout=itemView.findViewById(R.id.anim);
            tv_title=itemView.findViewById(R.id.txt_title);
            tv_content=itemView.findViewById(R.id.txt_details);
            tv_date=itemView.findViewById(R.id.txt_side);
            imageView=itemView.findViewById(R.id.img_view);

            if (isDark){
                setDarkTheam();
            }

        }


        private void setDarkTheam(){

            relativeLayout.setBackgroundResource(R.drawable.card_bd_dark);

        }
    }
}
