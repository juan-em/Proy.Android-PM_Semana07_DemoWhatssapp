package com.miempresa.demowhatsapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Movie.newInstance] factory method to
 * create an instance of this fragment.
 */
class Movie : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var imagen_list:MutableList<Bitmap> = mutableListOf(
            BitmapFactory.decodeResource(resources,R.drawable.pet),
            BitmapFactory.decodeResource(resources,R.drawable.fc),
            BitmapFactory.decodeResource(resources,R.drawable.wf),
            BitmapFactory.decodeResource(resources,R.drawable.fc2),
        )
        var price_list:MutableList<String> = mutableListOf("Free","$0.99","$1.99","$0.79","$2.95","Free")
        var title_list :MutableList<String> = mutableListOf("WhatsFake Pro (Ad free)","Fake Chat (Direct Message)","Portuguese-English")
        var sub1_list :MutableList<String> = mutableListOf("500.000","5.000+","50.000+")


        lista.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(context);

        var llenarLista = ArrayList<ElementosCard>()
        for (i in 1 until 12) {
            llenarLista.add(ElementosCard(
                imagen_list[(0..3).random()],
                price_list[(0..price_list.size-1).random()],
                title_list[(0..title_list.size-1).random()],
                "Estamos en la descripcion "+i,
                sub1_list[(0..sub1_list.size-1).random()],
                "4. "+(1..9).random().toString()+"/5"))
        }

        val adapter = AdaptadorCardView(llenarLista)
        lista.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Movie.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Movie().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}