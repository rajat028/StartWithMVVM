package rajatarora.com.startwithmvvm.data.local

import rajatarora.com.startwithmvvm.model.Avatar

interface StartWithMVVMDaoRepository {
    fun getAllAvatar(): List<Avatar.Response>

    fun insertAll(avatars: List<Avatar.Response>)
}