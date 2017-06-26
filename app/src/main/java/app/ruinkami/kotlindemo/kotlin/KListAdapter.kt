package app.ruinkami.kotlindemo.kotlin

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.jetbrains.anko.AnkoContext

import java.util.ArrayList

/**
 * Created by ruinkami on 2017/6/25.
 */

class KListAdapter(val dataList: ArrayList<KStudent>) : BaseAdapter() {

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(i: Int): Any {
        return dataList[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        return ItemUI(i, dataList[i], i != dataList.size - 1).createView(AnkoContext.create(viewGroup!!.context, viewGroup))
    }

}
