package app.ruinkami.kotlindemo.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import org.jetbrains.anko.setContentView

class KInfoActivity : AppCompatActivity() {

    var stuName: String = ""
    var stuAge: Int = 0
    var stuHobby: String = ""
    var stuUniversity: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        InfoUI().setContentView(this@KInfoActivity)
    }

    private fun initData() {
        stuName = intent.getStringExtra("stu_name")
        stuAge = intent.getIntExtra("stu_age", 20)
        stuHobby = intent.getStringExtra("stu_hobby")
        stuUniversity = intent.getStringExtra("stu_university")
    }
}
