package com.smcompony.what

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class RecyclerAdapter2(private val mDataList: List<CardItem>) : RecyclerView.Adapter<RecyclerAdapter2.ViewHolder>() {

    private var mListener: RecyclerViewClickListener? = null

    interface RecyclerViewClickListener {            // 리사이클뷰 인터페이스 생성
        fun onItemClicked(position: Int)
        fun onShareButtonClicked(position: Int)
        fun onLearnMoreButtonClicked(position: Int)
    }

    fun setOnClickListener(listener: RecyclerViewClickListener) {    //
        mListener = listener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = mDataList[position]
        viewHolder.contents.text = item.contents
        viewHolder.recycle_image.setImageResource(item.image)

        if (mListener != null) {
            viewHolder.itemView.setOnClickListener { mListener!!.onItemClicked(position) }
        }

    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {            // 뷰홀더 생성
        internal var contents: TextView
        internal var recycle_image: ImageView
        internal var shareButton: ImageView? = null

        init {
            contents = itemView.findViewById(R.id.contents_text)
            recycle_image = itemView.findViewById(R.id.recycler_image)
        }
    }
}
