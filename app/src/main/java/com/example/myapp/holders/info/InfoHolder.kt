package com.example.myapp.holders.info

import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import kotlinx.android.synthetic.main.user_info_view.view.*


class InfoHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(dataInfoHolder: DataInfoHolder) {
        view.apply {
            name.text = dataInfoHolder.name
            txtClass.text = dataInfoHolder.myClass
            web.setOnClickListener {
                view.context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(dataInfoHolder.link)
                    )
                )
            }
            val res: Resources = resources
            val src = BitmapFactory.decodeResource(res, R.drawable.cat)
            var dr: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(res, src)
            dr.cornerRadius = 200F
            img.setImageDrawable(dr)
        }
    }
}