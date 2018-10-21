package rajatarora.com.startwithmvvm.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDao
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDaoRepoImpl
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDaoRepository
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMLocalDataBase
import javax.inject.Singleton


@Module
open class AppModule(private val context: Application) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Application {
        return context
    }

    @Singleton
    @Provides
    internal fun getDatabase(): StartWithMVVMLocalDataBase {
        return Room.databaseBuilder(context, StartWithMVVMLocalDataBase::class.java, "local_database")
                .build()
    }

    @Singleton
    @Provides
    internal fun getAvatarDAO(database: StartWithMVVMLocalDataBase): StartWithMVVMDao {
        return database.avatarDataDao()
    }

    @Singleton
    @Provides
    internal fun getLocalAvatarRepository(avatarDAO: StartWithMVVMDao): StartWithMVVMDaoRepository {
        return StartWithMVVMDaoRepoImpl(avatarDAO)
    }

}
