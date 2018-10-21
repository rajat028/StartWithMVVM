package rajatarora.com.startwithmvvm.data.remote

import rajatarora.com.startwithmvvm.api.StartWithMVVMApi
import rajatarora.com.startwithmvvm.model.Avatar
import retrofit2.Callback

class StartWithMVVMRepositoryImpl(val api : StartWithMVVMApi) : StartWithMVVMRepository {

    override fun getAvatars(access_token: String, avatarCallback: Callback<Avatar>) {
        return  api.getAvatars(access_token).enqueue(avatarCallback)
    }
}