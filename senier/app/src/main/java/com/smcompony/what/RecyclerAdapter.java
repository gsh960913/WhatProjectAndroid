package com.smcompony.what;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private final List<CardItem> mDataList;

    public interface RecyclerViewClickListener {            // 리사이클뷰 인터페이스 생성
        void onItemClicked(int position);
        void onShareButtonClicked(int position);
        void onLearnMoreButtonClicked(int position);
    }

    private RecyclerViewClickListener mListener;

    public void setOnClickListener(RecyclerViewClickListener listener) {    //
        mListener = listener;
    }

    public RecyclerAdapter(List<CardItem> dataList) {
        mDataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        CardItem item = mDataList.get(position);
        viewHolder.contents.setText(item.getContents());
        viewHolder.recycle_image.setImageResource(item.getImage());

        if (mListener != null){
            final int pos = position;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {            // 뷰홀더 생성
        TextView contents;
        ImageView recycle_image;
        ImageView shareButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contents = itemView.findViewById(R.id.contents_text);
            recycle_image = itemView.findViewById(R.id.recycler_image);
        }
    }
}
