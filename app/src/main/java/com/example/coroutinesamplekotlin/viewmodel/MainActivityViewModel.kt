package com.example.coroutinesamplekotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinesamplekotlin.models.RecyclerList
import com.example.coroutinesamplekotlin.netwwork.RetrofitInstance
import com.example.coroutinesamplekotlin.netwwork.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    lateinit var recylerListLiveData: MutableLiveData<RecyclerList>

    init {
        recylerListLiveData = MutableLiveData()
    }

    fun getRecylerListObserver(): MutableLiveData<RecyclerList> {
        return recylerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance =
                RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recylerListLiveData.postValue(response)
        }
    }

}