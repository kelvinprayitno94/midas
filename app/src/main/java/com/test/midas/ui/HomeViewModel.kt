package com.test.midas.ui

import androidx.lifecycle.MutableLiveData
import com.test.midas.base.BaseViewModel
import com.test.midas.model.Menus
import com.test.midas.service.ApiRepositoryContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    private val apiRepositoryContract: ApiRepositoryContract
) : BaseViewModel() {
    val shopLiveData: MutableLiveData<List<Menus>> = MutableLiveData()

    fun getMenu() {
        apiRepositoryContract.getList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.success?.let { _success ->
                    if (_success) {
                        if (it.payload[0].shop[0].code == 1)
                            shopLiveData.value = it.payload[0].shop[0].Menus
                    }
                }
            }, {
            }).addToDisposable()
    }
}