package com.github.cesar1287.turma1dh.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.i("teste", "caiu no meu broadcast")
    }
}