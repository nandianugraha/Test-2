package com.nandia.test2.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nandia.mylibraryhelper.model.Data
import com.nandia.test2.R
import org.jetbrains.anko.textColor

class WatchlistAdapter(private var list: ArrayList<Data>, var context: Context, val listener: (Data) -> Unit) :
    RecyclerView.Adapter<WatchlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.list_watchlist, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val textInternal: TextView = item.findViewById(R.id.text_internal)
        private val textFullname: TextView = item.findViewById(R.id.text_fullname)
        private val textOpen: TextView = item.findViewById(R.id.text_open)
        private val textChange: TextView = item.findViewById(R.id.text_change)

        fun bind(watchlist: Data, listener: (Data) -> Unit) {
            textInternal.text = watchlist.CoinInfo.Internal
            textFullname.text = watchlist.CoinInfo.FullName
            textOpen.text = watchlist.RAW.USD.PRICE

            val percent = watchlist.DISPLAY.USD.CHANGEPCTDAY
            if (percent.subSequence(0,1)== "-") {
                textChange.setTextColor(Color.RED)
            } else {
                textChange.setTextColor(Color.parseColor("#00AD6C"))
            }

            textChange.text = "${watchlist.DISPLAY.USD.CHANGEDAY.substring(1)} (${percent}%)"

            itemView.setOnClickListener { listener }

        }

    }

}