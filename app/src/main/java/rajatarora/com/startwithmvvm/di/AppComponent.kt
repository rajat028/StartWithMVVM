package rajatarora.com.startwithmvvm.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import rajatarora.com.startwithmvvm.StartWithMVVMApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    ApiModule::class,
    AndroidInjectionModule::class,
    ActivityBindingModule::class])
interface AppComponent {
    fun inject(application: StartWithMVVMApplication)
}
