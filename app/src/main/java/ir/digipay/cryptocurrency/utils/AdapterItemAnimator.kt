package ir.digipay.cryptocurrency.utils

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import ir.digipay.cryptocurrency.R

interface AdapterItemAnimator {
    fun animateItem(previousPosition: Int, currentPosition: Int, vh: RecyclerView.ViewHolder): Int {
        if (currentPosition > previousPosition) {
            vh.itemView.startAnimation(AnimationUtils.loadAnimation(vh.itemView.context, R.anim.up_from_bottom))
        } else if (currentPosition < previousPosition) {
            vh.itemView.startAnimation(AnimationUtils.loadAnimation(vh.itemView.context, R.anim.down_from_top))
        }
        return currentPosition
    }
}
