package app.ruinkami.kotlindemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.ruinkami.kotlindemo.FakeServer

import org.jetbrains.anko.*

class KListActivity : AppCompatActivity() {

    var studentList: ArrayList<KStudent> = ArrayList()
    var listAdapter: KListAdapter = KListAdapter(studentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListUI().setContentView(this@KListActivity)
    }

    fun clearList() {
        studentList.clear()
        listAdapter.notifyDataSetChanged()
        showShortToast("已清空")
    }

    fun updateList() {
        studentList.addAll(FakeServer.randomKotlinResponse())
        listAdapter.notifyDataSetChanged()
        showShortToast("已更新10条数据")
    }

    fun gotoItemInfo(position: Int) {
        var student = studentList[position]
        startActivity<KInfoActivity>("stu_name" to student.name, "stu_age" to student.age, "stu_hobby" to student.hobby, "stu_university" to student.university)
    }

}
