package rajatarora.com.startwithmvvm.ui.avatar.di

import dagger.Module
import dagger.Provides
import rajatarora.com.startwithmvvm.ui.avatar.adapter.AvatarAdapter

@Module
class AvatarModule {
    @Provides
    @AvatarScope
    fun avatarAdapter(): AvatarAdapter {
        return AvatarAdapter()
    }
}