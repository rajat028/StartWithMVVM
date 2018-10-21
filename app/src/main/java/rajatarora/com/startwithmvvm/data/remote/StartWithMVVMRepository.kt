package rajatarora.com.startwithmvvm.data.remote

import rajatarora.com.startwithmvvm.model.Avatar
import retrofit2.Callback

interface StartWithMVVMRepository {

    fun getAvatars(access_token: String, avatarCallback: Callback<Avatar>)
}