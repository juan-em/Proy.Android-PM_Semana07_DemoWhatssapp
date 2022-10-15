package com.miempresa.demowhatsapp

import android.graphics.Bitmap

data class Elementos (
    val imagen: Bitmap,
    val nombre: String,
    val mensaje:String,
    val hora: String,
    val cant_msj:String);