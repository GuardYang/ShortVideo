package com.ysr.shortvideo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import com.ysr.shortvideo.adapter.MenuAdapter
import com.ysr.shortvideo.bean.MenuBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MenuAdapter.ItemClickListener {


    private var mContext: Context? = null
    private var list: ArrayList<MenuBean>? = null
    private var adapter: MenuAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        list = ArrayList()
        initData()
        adapter = MenuAdapter(mContext!!, list)
        adapter!!.listener = this
        rcl_video.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        rcl_video.adapter = adapter
    }

    private fun initData() {
        val names = resources.getStringArray(R.array.list_mainmenu)
        val icons = getMenuImg()
        for (i in names.indices) {
            val data = MenuBean()
            data.iconId = icons[i]
            data.title = names[i]
            list!!.add(data)

        }
    }

    private fun getMenuImg(): IntArray {
        return intArrayOf(R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.qn_icon,
                R.mipmap.ks_icon

        )
    }

    override fun itemClick(view: View, position: Int) {
        Log.e("itemClick", "itemClick"+position)
    }
}
