package com.example.user.sample2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by user on 29/01/2018.
 */

class MineralWaterAdapter extends RecyclerView.Adapter<MineralWaterAdapter.ViewHolder> {

    private ArrayList<MineralWater> mMineralWater;
    private Context mContext;


    MineralWaterAdapter(Context context, ArrayList<MineralWater> mineralWater ) {
        mContext = context;
        mMineralWater = mineralWater;
    }

    @Override
    public MineralWaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MineralWaterAdapter.ViewHolder holder, int position) {
        MineralWater currentmw = mMineralWater.get(position);
        holder.bindTo(currentmw);
        Glide.with(mContext).load(currentmw.getImageResource()).into(holder.mImagesView);
    }

    @Override
    public int getItemCount() {
        return mMineralWater.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mImagesView;

        public ViewHolder(View itemView) {
            super(itemView);

            mTitleText = (TextView)itemView.findViewById(R.id.titles);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mImagesView = (ImageView) itemView.findViewById(R.id.mwimages);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MineralWater currentM = mMineralWater.get(getAdapterPosition());
                    Intent detailIntent = new Intent(mContext, DetailActivity.class);
                    detailIntent.putExtra("title", currentM.getName());
                    detailIntent.putExtra("image_resource", currentM.getImageResource());
                    mContext.startActivity(detailIntent);
                }
            });
        }

        public void bindTo(MineralWater currentmw) {
            mTitleText.setText(currentmw.getName());
            mInfoText.setText(currentmw.getInfo());
        }
    }
}
