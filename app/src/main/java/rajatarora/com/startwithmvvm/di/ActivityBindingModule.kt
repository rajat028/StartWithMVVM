package rajatarora.com.startwithmvvm.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import rajatarora.com.startwithmvvm.ui.avatar.AvatarActivity
import rajatarora.com.startwithmvvm.ui.avatar.di.AvatarModule
import rajatarora.com.startwithmvvm.ui.avatar.di.AvatarScope

@Module
abstract class ActivityBindingModule {

    @AvatarScope
    @ContributesAndroidInjector(modules = [AvatarModule::class])
    abstract fun bindAvatarActivity(): AvatarActivity
}
