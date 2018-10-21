package rajatarora.com.startwithmvvm.common

import android.arch.lifecycle.ViewModel
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDaoRepoImpl
import java.lang.ref.WeakReference
import java.util.concurrent.Executors
import javax.inject.Inject

abstract class BaseViewModel<N : BaseNavigators> : ViewModel() {


    val executor = Executors.newFixedThreadPool(2)

    private var mNavigator: WeakReference<N>? = null


    fun getNavigator(): N {
        return mNavigator!!.get()!!
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

}