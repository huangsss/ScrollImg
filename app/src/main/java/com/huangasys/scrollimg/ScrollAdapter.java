package com.huangasys.scrollimg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * @author huangasys
 * @date 2018/8/31
 * Created by huangasys on 2018/8/31.16:05
 * @Describe:
 */

public class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.ScrollViewHolder> {



    @Override
    public ScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        return new ScrollViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScrollViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class ScrollViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
         ScrollViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_bg);
        }
    }
}
