package rajatarora.com.startwithmvvm.ui.avatar.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import rajatarora.com.startwithmvvm.R
import rajatarora.com.startwithmvvm.model.Avatar
import rajatarora.com.startwithmvvm.ui.avatar.holder.AvatarHolder
import timber.log.Timber

class AvatarAdapter : RecyclerView.Adapter<AvatarHolder>() {

    private var avatarList = ArrayList<Avatar.Response>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvatarHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_avatar, parent, false)
        return AvatarHolder(view)
    }

    override fun onBindViewHolder(holder: AvatarHolder, position: Int) {
        val avatarItem = avatarList[position]
        holder.run { displayAvatar(avatarItem) }
    }

    override fun getItemCount() = avatarList.size

    fun addItems(avatarList: List<Avatar.Response>) {
        this.avatarList.addAll(avatarList)
        Timber.e(avatarList.size.toString())
        notifyDataSetChanged()
    }
}