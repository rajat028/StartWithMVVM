package rajatarora.com.startwithmvvm.di

import dagger.Module
import dagger.Provides
import rajatarora.com.startwithmvvm.api.StartWithMVVMApi
import rajatarora.com.startwithmvvm.data.remote.StartWithMVVMRepository
import rajatarora.com.startwithmvvm.data.remote.StartWithMVVMRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
open class ApiModule {

    @Provides
    @Singleton
    internal fun startWithMVVMApi(retrofit: Retrofit): StartWithMVVMApi {
        return retrofit.create(StartWithMVVMApi::class.java)
    }

    @Provides
    @Singleton
    internal fun apiAvatarRepository(startWithMVVMAPI: StartWithMVVMApi): StartWithMVVMRepository {
        return StartWithMVVMRepositoryImpl(startWithMVVMAPI)
    }
}
