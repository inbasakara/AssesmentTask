package com.wiprotask.telstra.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiprotask.telstra.Fact
import com.wiprotask.telstra.model.FactList
import com.wiprotask.telstra.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val factList = MutableLiveData<List<Fact>>()
    val errorMessage = MutableLiveData<String>()
    val actionbartitlestring =MutableLiveData<String>();
    val loading = MutableLiveData<Boolean>()

    fun getAllFactList() {
        /*retrives the data using retrofit
        inside onResponse list and actionbar title data are retrived */
        val response = repository.getAllFact()
        response.enqueue(object : Callback<FactList> {
            override fun onResponse(call: Call<FactList>, response: Response<FactList>) {
                if(response.isSuccessful){
                    factList.postValue(response.body()?.mList)
                    actionbartitlestring.postValue(response.body()?.title)
                    loading.value = false
                }else{
                    onError("Error : ${response.message()} ")
                }
            }
            override fun onFailure(call: Call<FactList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

}