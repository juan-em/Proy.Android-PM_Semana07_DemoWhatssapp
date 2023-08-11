package com.miempresa.demowhatsapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista:View = inflater.inflate(R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment

        return vista
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lista_chats.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        lista_chats.layoutManager = LinearLayoutManager(context)

        var llenarLista = ArrayList<Elementos>()
        var imagen_list:MutableList<Bitmap> = mutableListOf(
            BitmapFactory.decodeResource(resources,R.drawable.profile),
            BitmapFactory.decodeResource(resources,R.drawable.profile1),
            BitmapFactory.decodeResource(resources,R.drawable.profile2),
            BitmapFactory.decodeResource(resources,R.drawable.profile3),
            BitmapFactory.decodeResource(resources,R.drawable.profile4),
            BitmapFactory.decodeResource(resources,R.drawable.profile5),
        )
        var nombres_list:MutableList<String> = mutableListOf("Sharona","Veronica","Bree","Philippe","Peria","Audre","Evaleen","Neils","Philis","Leonerd","Rubie","Joli","Rachael","Cazzie","Egor","Eduard","Dorothy","Lucretia","Glenn","Jilleen","Gabi","Kendra","Pail","Antonina","Jonah","Rex","Shae","Briny","Webster","Beck","Aila","Frazier","Barrett","Annecorinne","Fabiano","Sheppard","Ag","Hulda","Farlee","Brinna")
        var min = 59
        for (i in 1..12){
            llenarLista.add(
                Elementos(
                    imagen_list[(0..5).random()],
                    nombres_list[(0..nombres_list.size-1).random()],
                    "soy el mensaje del chat "+i,
                    "10:"+min+" p.m.",
                    (1..12).random().toString()
                )
            )
            min -= (1..6).random()
        }
        val adapter = AdaptadorElementos(llenarLista)
        lista_chats.adapter = adapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}