package rajatarora.com.startwithmvvm.data.local

import rajatarora.com.startwithmvvm.model.Avatar

class StartWithMVVMDaoRepoImpl(var avatarDAO: StartWithMVVMDao) : StartWithMVVMDaoRepository {

    override fun getAllAvatar(): List<Avatar.Response> {
        return avatarDAO.getAllAvatar()
    }

    override fun insertAll(avatars: List<Avatar.Response>) {
        avatarDAO.insertAll(avatars)
    }
}