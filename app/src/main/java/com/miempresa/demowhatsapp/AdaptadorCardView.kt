package com.miempresa.demowhatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCardView(val ListaElementos:ArrayList<ElementosCard>): RecyclerView.Adapter<AdaptadorCardView.ViewHolder>() {

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val fImagen = itemView.findViewById<ImageView>(R.id.card_imagen);
        val fprice = itemView.findViewById<TextView>(R.id.card_price)
        val ftitle = itemView.findViewById<TextView>(R.id.card_title)
        val fdesc = itemView.findViewById<TextView>(R.id.card_desc)
        val fsub_1 = itemView.findViewById<TextView>(R.id.card_sub_1)
        val fsub_2 = itemView.findViewById<TextView>(R.id.card_sub_2)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorCardView.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoscardview, parent, false);
        return AdaptadorCardView.ViewHolder(v);
    }

    override fun onBindViewHolder(holder: AdaptadorCardView.ViewHolder, position: Int) {
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)
        holder?.fprice?.text=ListaElementos[position].price
        holder?.ftitle?.text=ListaElementos[position].title
        holder?.fdesc?.text=ListaElementos[position].desc
        holder?.fsub_1?.text=ListaElementos[position].sub_1
        holder?.fsub_2?.text=ListaElementos[position].sub_2


    }

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }
}
