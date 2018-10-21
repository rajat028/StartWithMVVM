package rajatarora.com.startwithmvvm.ui.avatar

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import rajatarora.com.startwithmvvm.common.BaseViewModel
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDao
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDaoRepoImpl
import rajatarora.com.startwithmvvm.data.local.StartWithMVVMDaoRepository
import rajatarora.com.startwithmvvm.data.remote.StartWithMVVMRepository
import rajatarora.com.startwithmvvm.data.remote.StartWithMVVMRepositoryImpl
import rajatarora.com.startwithmvvm.model.Avatar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class AvatarViewModel @Inject constructor( val apiAvatarRepository: StartWithMVVMRepository,
                                           val startWithMVVMDao: StartWithMVVMDao)
    : BaseViewModel<AvatarNavigator>() {

    val isLoading = MutableLiveData<Boolean>()
    val avatarList = MutableLiveData<List<Avatar.Response>>()

    fun getAvatars() {
        isLoading.value = true
        apiAvatarRepository.getAvatars("c82114be2caa779ad511e4fa46c03aad", avatarCallback())
    }

    private fun avatarCallback() = object : Callback<Avatar> {
        override fun onFailure(call: Call<Avatar>?, t: Throwable?) {
            isLoading.value = false
        }

        override fun onResponse(call: Call<Avatar>?, response: Response<Avatar>?) {
            response?.body()?.run {

                updateData(response.body()!!.response)
            }
        }

        private fun updateData(data: List<Avatar.Response>) {
//            addToLocalDatabase(data)
            getNavigator().moveToDetail()
            isLoading.value = false
            avatarList.value = data
        }
    }

//    private fun addToLocalDatabase(data: List<Avatar.Response>) {
//        executor.execute {
//            startWithMVVMDaoRepo.insertAll(data)
//            getDataFromDatabase()
//        }
//    }
//
//    private fun getDataFromDatabase() {
//        executor.execute {
//            avatarList.value = startWithMVVMDaoRepo.getAllAvatar()
//            Timber.e(startWithMVVMDaoRepo.getAllAvatar().size.toString())
//        }
//
//    }
}