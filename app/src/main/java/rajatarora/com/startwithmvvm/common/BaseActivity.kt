package rajatarora.com.startwithmvvm.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<V : BaseViewModel<*>> : AppCompatActivity() {

    @Inject
    lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(getContentView())
        initUI()
        initMutableData()
        onCreateStuff()
    }

    abstract fun getContentView(): Int

    abstract fun onCreateStuff()

    abstract fun initUI()

    abstract fun initMutableData()

}