package rajatarora.com.startwithmvvm.api

import rajatarora.com.startwithmvvm.model.Avatar
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StartWithMVVMApi {

    @GET("avatars")
    fun getAvatars(@Query("access_token") access_token: String): Call<Avatar>
}