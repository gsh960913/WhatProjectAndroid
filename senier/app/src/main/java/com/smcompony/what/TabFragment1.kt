package com.smcompony.what

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewFlipper

import java.util.ArrayList

class TabFragment1 : Fragment(), RecyclerAdapter.RecyclerViewClickListener {

    internal var v_flipper: ViewFlipper? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_tab1, container, false)

        val images = intArrayOf(R.drawable.johntheripper, R.drawable.metasplooits, R.drawable.burpsuite, R.drawable.bettercap, R.drawable.wireshark, R.drawable.nmap, R.drawable.aircrackng, R.drawable.sqlmap)     // Flipper Image source
        val morebutton = v.findViewById<Button>(R.id.moreButton)
        v_flipper = v.findViewById(R.id.v_flipper)             // 뷰 플리퍼 findViewById 하기

        val recyclerView = v.findViewById<View>(R.id.recycler_view) as RecyclerView
        val layoutManager = GridLayoutManager(activity, 3)
        recyclerView.layoutManager = layoutManager

        val dataList = ArrayList<CardItem>()

        dataList.add(CardItem("", "시스템 보안", R.drawable.blackarchs))
        dataList.add(CardItem("", "네트워크 보안", R.drawable.kali))
        dataList.add(CardItem("", "웹 보안", R.drawable.parrotos))

        for (i in images.indices) {
            flipperImages(images[i])
        }

        morebutton.setOnClickListener {
            val intent = Intent(activity, NetworkActivity::class.java)
            this@TabFragment1.startActivity(intent)
            //                Toast.makeText(getActivity(), "MORE 버튼 활성화됨", Toast.LENGTH_LONG).show();
        }

        val adapter = RecyclerAdapter(dataList)
        recyclerView.adapter = adapter

        adapter.setOnClickListener(this)
        return v
    }

    fun flipperImages(images: Int) {             // flipper 속성 지정하기
        val imageView = ImageView(activity)
        imageView.setBackgroundResource(images)

        v_flipper?.addView(imageView)
        v_flipper?.setFlipInterval(4000)
        v_flipper?.isAutoStart = true
        v_flipper?.setInAnimation(activity, android.R.anim.slide_in_left)
        v_flipper?.setOutAnimation(activity, android.R.anim.slide_out_right)
        // 에니메이션
    }

    override fun onItemClicked(position: Int) {

        when (position) {
            0 -> {

                val intent = Intent(activity, SystemActivity::class.java)
                this@TabFragment1.startActivity(intent)
            }
            1 -> {
                val intent = Intent(activity, NetworkActivity::class.java)
                this@TabFragment1.startActivity(intent)
            }
            2 -> {
                val intent = Intent(activity, WebActivity::class.java)
                this@TabFragment1.startActivity(intent)
            }
        }
    }

    override fun onShareButtonClicked(position: Int) {

    }

    override fun onLearnMoreButtonClicked(position: Int) {

    }
}
