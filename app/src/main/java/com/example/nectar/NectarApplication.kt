package com.example.nectar

import com.example.nectar.data.local.util.DatabaseSeeder
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class NectarApplication : Application(){

    @Inject
    lateinit var seeder: DatabaseSeeder

    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.IO).launch {
            seeder.seed()
        }
    }
}