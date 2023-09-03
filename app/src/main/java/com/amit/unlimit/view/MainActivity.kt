package com.amit.unlimit.view

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.amit.unlimit.R
import com.amit.unlimit.base.BaseActivity
import com.amit.unlimit.base.viewBinding
import com.amit.unlimit.databinding.ActivityMainBinding
import com.amit.unlimit.view.adapter.JokesAdapter
import com.amit.unlimit.view.viewmodel.JokesViewStateData
import com.amit.unlimit.view.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.mapLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalCoroutinesApi::class)
class MainActivity : BaseActivity() {

    private val binding by viewBinding { ActivityMainBinding.bind(it) }
    private val viewModel by viewModel<MainViewModel>()

    override val layoutId: Int
        get() = R.layout.activity_main

    private val mJokesAdapter: JokesAdapter by lazy {
        JokesAdapter(
            dataList = ArrayList(),
            onItemClicked = { _, _ -> }
        )
    }

    override fun initUI() {

        binding.rvJokes.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mJokesAdapter
        }

        observeViewModelData()
        initData()
    }

    private fun initData() {
        showLoading()
        viewModel.fetchLocalJokes()
    }

    private fun observeViewModelData(){
        viewModel.jokesLiveData.observe(this){ newState ->
            when (newState) {
                is JokesViewStateData.Success -> {
                    newState.dataList?.let {
                        mJokesAdapter.addData(newState.dataList)
                    }
                    hideLoading()
                }

                is JokesViewStateData.LoadFailed -> {
                    hideLoading()
                    showToast("Data not available!")
                }

                is JokesViewStateData.Failure -> {
                    hideLoading()
                    showToast(newState.throwable.localizedMessage.orEmpty())
                }

                else -> Unit
            }
        }
    }

}