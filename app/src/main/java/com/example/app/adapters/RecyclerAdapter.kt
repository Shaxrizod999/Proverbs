package com.example.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.models.Maqollar
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter(private val list: List<Maqollar>, val onClick: (maqol: Maqollar) -> Unit):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(maqol: Maqollar) {
            itemView.apply {
                maqoluz.text = maqol.uzbek
            }
            itemView.setOnClickListener {
                onClick(maqol)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
    override fun getItemCount(): Int = list.size
}

