package ir.digipay.cryptocurrency.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener : RecyclerView.OnScrollListener() {

    // The current offset index of data you have loaded
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (dy > 0) {
            if ((visibleItemCount + firstVisibleItemPosition >= totalItemCount) && (firstVisibleItemPosition >= 0)) {
                onLoadMore(totalItemCount + 1)
            }
        }
    }

    protected abstract fun onLoadMore(start: Int)
}