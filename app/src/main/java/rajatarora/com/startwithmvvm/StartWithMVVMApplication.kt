package rajatarora.com.startwithmvvm

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import rajatarora.com.startwithmvvm.di.AppComponent
import rajatarora.com.startwithmvvm.di.AppModule
import rajatarora.com.startwithmvvm.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

open class StartWithMVVMApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        getComponent().inject(this)
    }

    private fun getComponent(): AppComponent {
        return DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }


}

