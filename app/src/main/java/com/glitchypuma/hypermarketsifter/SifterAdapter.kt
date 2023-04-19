package com.glitchypuma.hypermarketsifter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class SifterAdapter(val context : Context, val listItemModels : ArrayList<ListItemModel>) : RecyclerView.Adapter<SifterAdapter.SifterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SifterViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return SifterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItemModels.size
    }

    override fun onBindViewHolder(holder: SifterViewHolder, position: Int) {
        holder.tvItem.setText(listItemModels.get(position).getItemName())
        holder.tvPrice.setText(listItemModels.get(position).getItemPrice())
        holder.tvType.setText(listItemModels.get(position).getItemType())
    }

    inner class SifterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var tvItem : TextView = view.findViewById(R.id.item_name_text)
        var tvPrice : TextView = view.findViewById(R.id.item_price_text)
        var tvType : TextView = view.findViewById(R.id.item_type_text)
    }
}