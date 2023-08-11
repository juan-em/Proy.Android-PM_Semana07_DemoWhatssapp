package com.miempresa.demowhatsapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_sort_by_size)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigableView: NavigationView = findViewById(R.id.nav_view)
        navigableView.setNavigationItemSelectedListener(this)

        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val lista_tabs = arrayOf("Chats","Estados","Llamadas")
        val pageController = PagerController(this)
        viewPager.adapter = pageController
        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
            tab.text = lista_tabs[position]
        }.attach()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.buscar){
            Toast.makeText(this,"Elegiste Buscar",Toast.LENGTH_LONG).show();
        }
        if (id == R.id.chat) {
            //Toast.makeText(this,"Elegiste Chat",Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,chats::class.java)
            startActivity(llamaactividad)
            return true
        }
        if (id == R.id.ajustes) {
            //Toast.makeText(this, "Elegiste Ajustes", Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,ajustes::class.java)
            startActivity(llamaactividad)
            return true
        }
        if (id == R.id.acerca_de) {
            //Toast.makeText(this, "Elegiste Acerca de", Toast.LENGTH_LONG).show();
            val llamaactividad = Intent(applicationContext,acerca_de::class.java)
            startActivity(llamaactividad)
            return true
        }
        if (id==android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_cuenta-> Toast.makeText(this,"Elegiste Cuenta", Toast.LENGTH_LONG).show()
            R.id.nav_chats-> Toast.makeText(this,"Elegiste Chats", Toast.LENGTH_LONG).show()
            R.id.nav_notificaciones-> Toast.makeText(this,"Elegiste Notificaciones", Toast.LENGTH_LONG).show()
            R.id.nav_datause-> Toast.makeText(this,"Elegiste Uso de datos", Toast.LENGTH_LONG).show()
            R.id.nav_help-> Toast.makeText(this,"Elegiste Informacion y ayuda", Toast.LENGTH_LONG).show()
            R.id.nav_contacts-> Toast.makeText(this,"Elegiste Contactos", Toast.LENGTH_LONG).show()
        }
        return true
    }

}