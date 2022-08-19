package com.wiprotask.telstra

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.wiprotask.telstra.databinding.ActivityMainBinding
import com.wiprotask.telstra.repository.MainRepository
import com.wiprotask.telstra.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //swiperefresh
        swipeRefreshLayout = findViewById(R.id.swipe)
        //get viewmodel instance using ViewModelProvider.Factory
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        //set adapter in recyclerview
        binding.recyclerview.adapter = adapter
        binding.recyclerview.setHasFixedSize(true);
        //the observer will only receive events if the owner(activity) is in active state
        //invoked when movieList data changes
        viewModel.factList.observe(this, Observer { Log.d(TAG, "factList: $it")
            adapter.setFactList(it)
        })
        //invoked when a network exception occurred
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
            Toast.makeText(applicationContext,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.getAllFactList();
        viewModel.actionbartitlestring.observe(this,{
            //to change title of actionbar
            val actionBar = supportActionBar
            actionBar!!.title = it.toString();
        })
        swipeRefreshLayout.setOnRefreshListener {
            // on below line we are setting is refreshing to false.
            swipeRefreshLayout.isRefreshing = false
            // on below line we are notifying adapter
            // that data has changed in recycler view.
            adapter.notifyDataSetChanged()
        }
    }
}