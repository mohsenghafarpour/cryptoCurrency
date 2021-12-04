package ir.digipay.cryptocurrency.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount

        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (dy > 0) {
            if (!isLoading() && (visibleItemCount + firstVisibleItemPosition >= totalItemCount) && (firstVisibleItemPosition >= 0)) {
                onLoadMore()
            }
        }
    }

    protected abstract fun onLoadMore()

    abstract fun isLoading(): Boolean
}
