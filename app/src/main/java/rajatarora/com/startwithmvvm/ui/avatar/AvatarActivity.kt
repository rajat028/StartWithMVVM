package rajatarora.com.startwithmvvm.ui.avatar

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import rajatarora.com.startwithmvvm.R
import rajatarora.com.startwithmvvm.common.BaseActivity
import rajatarora.com.startwithmvvm.ui.avatar.adapter.AvatarAdapter
import rajatarora.com.startwithmvvm.utils.subscribe
import timber.log.Timber
import javax.inject.Inject

class AvatarActivity : BaseActivity<AvatarViewModel>(), AvatarNavigator {

    @Inject
    lateinit var avatarAdapter: AvatarAdapter

    override fun getContentView() = R.layout.activity_main

    override fun initUI() {
        rvAvatars.layoutManager = GridLayoutManager(this, 2)
        rvAvatars.itemAnimator = DefaultItemAnimator()
        rvAvatars.adapter = avatarAdapter
    }

    override fun initMutableData() {
        mViewModel.isLoading.subscribe(this, this::showLoading)
        mViewModel.avatarList.subscribe(this, avatarAdapter::addItems)
    }

    override fun onCreateStuff() {
        mViewModel.setNavigator(this)
        mViewModel.getAvatars()
    }

    private fun showLoading(visible: Boolean) {
        pbAvatar.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun moveToDetail() {
        Timber.e("Started Working")
    }
}


