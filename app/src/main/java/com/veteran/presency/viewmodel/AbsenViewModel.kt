package com.veteran.presency.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.veteran.presency.database.DatabaseClient.Companion.getInstance
import com.veteran.presency.database.dao.DatabaseDao
import com.veteran.presency.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class AbsenViewModel(application: Application) : AndroidViewModel(application) {
    var databaseDao: DatabaseDao? = getInstance(application)?.appDatabase?.databaseDao()

    fun addDataAbsen(
        foto: String,
        nama: String,
        nim: String,
        tanggal: String,
        lokasi: String,
        matkul: String,
        status: String,
        keterangan: String) {
        Completable.fromAction {
            val modelDatabase = ModelDatabase()
            modelDatabase.fotoSelfie = foto
            modelDatabase.nama = nama
            modelDatabase.nim = nim
            modelDatabase.tanggal = tanggal
            modelDatabase.lokasi = lokasi
            modelDatabase.matkul = matkul
            modelDatabase.status = status
            modelDatabase.keterangan = keterangan
            databaseDao?.insertData(modelDatabase)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

}