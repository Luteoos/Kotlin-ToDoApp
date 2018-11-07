package io.github.luteoos.todoapp

import android.app.Application
import android.os.StrictMode
import io.realm.Realm
import io.realm.RealmConfiguration

class ToDoStartup : Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG)
            initDebugStuff()
        Realm.init(this)
        val realmConfiguration = RealmConfiguration
            .Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun initDebugStuff() {

        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build())
        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build())
    }
}