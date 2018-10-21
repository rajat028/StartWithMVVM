package rajatarora.com.startwithmvvm.ui.avatar.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.item_avatar.view.*
import rajatarora.com.startwithmvvm.model.Avatar

class AvatarHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun displayAvatar(avatarItem: Avatar.Response): Unit = with(itemView) {
        Glide.with(itemView)
                .load(avatarItem.avtar_url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(ivAvatar)
    }
}