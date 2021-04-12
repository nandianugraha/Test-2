package com.nandia.test2.ui.watchlist

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nandia.mylibraryhelper.model.Data
import com.nandia.mylibraryhelper.model.WatchlistModel
import com.nandia.mylibraryhelper.network.service.BaseService
import com.nandia.mylibraryhelper.util.gone
import com.nandia.mylibraryhelper.util.visible
import com.nandia.test2.R
import com.nandia.test2.ui.adapter.WatchlistAdapter
import kotlinx.android.synthetic.main.custom_actionbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WatchlistFragment: Fragment() {

    private var watchlistModel: ArrayList<Data> = ArrayList()
    private lateinit var mContext: Context
    lateinit var rvWatchlist: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var swipeRefresh: SwipeRefreshLayout
    var isLoading: Boolean = false
    lateinit var linearLayoutManager: LinearLayoutManager
    var limit = 10
    lateinit var adapter: WatchlistAdapter
    private var totalItemCount = 0
    private var lastVisibleItem = 0
    private var visibleThreshold = 5

    private var handler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_watchlist, container, false)
        rvWatchlist = view.findViewById(R.id.rv_watchList)
        linearLayoutManager = LinearLayoutManager(requireContext())
        rvWatchlist.layoutManager = linearLayoutManager
        progressBar = view.findViewById(R.id.progress)
        swipeRefresh = view.findViewById(R.id.swipe_refresh)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
        swipeRefresh.isRefreshing = true
        rvWatchlist.gone()
        checkWatchlist(limit)
        load()
    }

    fun load() {
        rvWatchlist.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    val next = watchlistModel.size
                    if (next <= 50) {
                        swipeRefresh.isRefreshing = true
                        checkWatchlist(next+10)
                    } else {
                        Toast.makeText(requireContext(), "Limit", Toast.LENGTH_LONG)
                        checkWatchlist(limit)
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                rvWatchlist.smoothScrollToPosition(dy)
            }
        })
    }

    fun refresh(){
        swipeRefresh.setOnRefreshListener {
            checkWatchlist(limit)
        }
    }

    fun checkWatchlist(limit: Int) {
        watchlistModel.clear()
        val tsym = "USD"
        val watchList = BaseService.watchListService().getAllWatchlist(limit = limit, tsym = tsym)
        watchList.enqueue(object : Callback<WatchlistModel> {
            override fun onResponse(
                call: Call<WatchlistModel>,
                response: Response<WatchlistModel>
            ) {
                swipeRefresh.isRefreshing = false
                val responseData = response.body()?.Data
                if (response.code() == 200) {
                    if (response.body()?.Type == 100) {
                        println(responseData)
                        watchlistModel.addAll(responseData!!.toList())
                        adapter = WatchlistAdapter(watchlistModel, requireContext()){
                            print(it)
                        }
                        rvWatchlist.adapter = adapter
                        adapter.notifyDataSetChanged()
                        rvWatchlist.visible()

                    } else {
                        Toast.makeText(requireContext(), response.body()?.Message, Toast.LENGTH_LONG).show()
                    }

                } else{
                    Toast.makeText(requireContext(), response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<WatchlistModel>, t: Throwable) {
                swipeRefresh.isRefreshing = false
                print(t.localizedMessage)
            }
        })
    }
}