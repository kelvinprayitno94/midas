package com.test.midas.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.midas.base.BaseActivity
import com.test.midas.databinding.ActivityHomeBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeActivity: BaseActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val homeViewModel: HomeViewModel by inject {
        parametersOf(this)
    }

    private val shopAdapter: ShopAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()
        initEvent()
        initRecyclerView()

        homeViewModel.getMenu()
    }

    private fun initRecyclerView() {
        binding.recyclerViewMenu.adapter = shopAdapter
        binding.recyclerViewMenu.layoutManager =
            LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
    }

    private fun initEvent() {

    }

    private fun initObserver() {
        homeViewModel.shopLiveData.observe(this@HomeActivity){
            shopAdapter.updateList(it)
        }
    }
}