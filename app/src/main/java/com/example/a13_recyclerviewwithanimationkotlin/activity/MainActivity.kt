package com.example.a13_recyclerviewwithanimationkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a13_recyclerviewwithanimationkotlin.R
import com.example.a13_recyclerviewwithanimationkotlin.adapter.CustomAdapter
import com.example.a13_recyclerviewwithanimationkotlin.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemberList()
        refreshAdpter(members)
    }

    private fun refreshAdpter(members: List<Member>) {
        val adapter = CustomAdapter(members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members = ArrayList<Member>()
        for (i in 0..50 step 1){
            members.add(Member("Odilbek $i", "+998 97 775 17 79"))
        }
        return members
    }

    fun initViews(){
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        val animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down)
        recyclerView.layoutAnimation = animation
    }
}