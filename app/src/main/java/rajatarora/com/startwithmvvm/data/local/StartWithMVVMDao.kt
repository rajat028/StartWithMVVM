package rajatarora.com.startwithmvvm.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import rajatarora.com.startwithmvvm.model.Avatar

@Dao
interface StartWithMVVMDao {

    @Query("SELECT * FROM avatars_local")
    fun getAllAvatar(): List<Avatar.Response>

    @Insert
    fun insertAll(avatars: List<Avatar.Response>)

}