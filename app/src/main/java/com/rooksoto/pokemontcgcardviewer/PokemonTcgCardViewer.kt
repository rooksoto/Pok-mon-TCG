package com.rooksoto.pokemontcgcardviewer

import androidx.multidex.MultiDexApplication
import timber.log.Timber

import timber.log.Timber.DebugTree




class PokemonTcgCardViewer : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // TODO: Remember to plant a crash report tree and if check here
        Timber.plant(DebugTree())
    }
}