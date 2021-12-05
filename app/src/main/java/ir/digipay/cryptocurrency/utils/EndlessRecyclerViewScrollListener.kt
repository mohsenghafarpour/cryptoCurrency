package ir.digipay.cryptocurrency.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val STARTING_PAGE_INDEX = 1
abstract class EndlessRecyclerViewScrollListener(
    private val initialPage: Int = STARTING_PAGE_INDEX
) : RecyclerView.OnScrollListener() {

    // The current offset index of data you have loaded
    private var currentPage = initialPage
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val layoutManager = recyclerView.layoutManager as LinearLayoutManager
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (dy > 0) {
            if ((visibleItemCount + firstVisibleItemPosition >= totalItemCount) && (firstVisibleItemPosition >= 0)) {
                onLoadMore(++currentPage)
            }
        }
    }

    protected abstract fun onLoadMore(page: Int)
}