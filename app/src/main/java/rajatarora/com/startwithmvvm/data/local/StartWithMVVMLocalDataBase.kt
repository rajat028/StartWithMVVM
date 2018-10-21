package rajatarora.com.startwithmvvm.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import rajatarora.com.startwithmvvm.model.Avatar

@Database(entities = [Avatar.Response::class], version = 1)
abstract class StartWithMVVMLocalDataBase : RoomDatabase() {
    abstract fun avatarDataDao(): StartWithMVVMDao
}