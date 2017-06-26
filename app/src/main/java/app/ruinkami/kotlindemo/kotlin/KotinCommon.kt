package app.ruinkami.kotlindemo.kotlin

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import app.ruinkami.kotlindemo.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onItemClick

/**
 * Created by ruinkami on 2017/6/25.
 */

data class KStudent(var id: Int, var name: String, var age: Int, var hobby: String, var university: String)

fun Context.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

class ListUI : AnkoComponent<KListActivity> {
    override fun createView(ui: AnkoContext<KListActivity>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                val kotlinListView = listView {
                    adapter = ui.owner.listAdapter
                    dividerHeight = 0
                    onItemClick { adapterView, view, position, id -> ui.owner.gotoItemInfo(position) }
                }.lparams {
                    width = matchParent
                    height = dip(0)
                    weight = 1f
                }
                view {
                    backgroundColor = getResources().getColor(R.color.divider)
                }.lparams {
                    width = matchParent
                    height = dip(1)
                    leftMargin = dip(15)
                    rightMargin = dip(15)
                }
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER
                    val kotlinClearButton = button {
                        text = "清空数据"
                        textSize = 20f
                        setAllCaps(false)
                        onClick {
                            ui.owner.clearList()
                        }
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                        margin = dip(5)
                    }
                    val kotlinUpdateButton = button {
                        text = "更新数据"
                        textSize = 20f
                        setAllCaps(false)
                        onClick {
                            ui.owner.updateList()
                        }
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                        margin = dip(5)
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}

class InfoUI : AnkoComponent<KInfoActivity> {
    override fun createView(ui: AnkoContext<KInfoActivity>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                padding = dip(15)
                textView {
                    text = "详细信息"
                    textSize = 24f
                }.lparams {
                    width = matchParent
                    height = wrapContent
                }
                view {
                    backgroundColor = getResources().getColor(R.color.divider)
                }.lparams {
                    width = matchParent
                    height = dip(1)
                    bottomMargin = dip(15)
                    topMargin = dip(15)
                }
                linearLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    orientation = LinearLayout.HORIZONTAL
                    textView {
                        text = "姓名"
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                    val kotlinInfoName = textView {
                        gravity = Gravity.RIGHT
                        text = ui.owner.stuName
                        textSize = 20f
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    bottomMargin = dip(15)
                }
                linearLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    orientation = LinearLayout.HORIZONTAL
                    textView {
                        text = "年龄"
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                    val kotlinInfoAge = textView {
                        gravity = Gravity.RIGHT
                        text = ui.owner.stuAge.toString()
                        textSize = 20f
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    bottomMargin = dip(15)
                }
                linearLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    orientation = LinearLayout.HORIZONTAL
                    textView {
                        text = "爱好"
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                    val kotlinInfoHobby = textView {
                        gravity = Gravity.RIGHT
                        text = ui.owner.stuHobby
                        textSize = 20f
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    bottomMargin = dip(15)
                }
                linearLayout {
                    gravity = Gravity.CENTER_VERTICAL
                    orientation = LinearLayout.HORIZONTAL
                    textView {
                        text = "学校"
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                    val kotlinInfoUniversity = textView {
                        gravity = Gravity.RIGHT
                        text = ui.owner.stuUniversity
                        textSize = 20f
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    bottomMargin = dip(15)
                }
            }
        }
    }
}

class ItemUI(index: Int, student: KStudent, showDivider: Boolean) : AnkoComponent<ViewGroup> {
    var mIndex: Int = 0
    var mStudent: KStudent
    var mShowDivider: Boolean

    init {
        mIndex = index
        mStudent = student
        mShowDivider = showDivider
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                leftPadding = dip(15)
                rightPadding = dip(15)
                topPadding = dip(0)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL

                    textView {
                        text = mStudent.name
                        textSize = 20f
                    }.lparams {
                        width = dip(0)
                        height = wrapContent
                        weight = 1f
                    }
                    textView {
                        text = mStudent.university
                        textSize = 20f
                    }.lparams {
                        width = wrapContent
                        height = wrapContent
                    }
                    imageView {
                        imageResource = R.drawable.right_arrow
                    }.lparams {
                        leftMargin = dip(10)
                        width = wrapContent
                        height = wrapContent
                    }

                }.lparams {
                    topMargin = dip(15)
                    bottomMargin = dip(15)
                    width = matchParent
                    height = wrapContent
                }

                view {
                    visibility = if (mShowDivider) { View.VISIBLE } else { View.GONE }
                    backgroundColor = getResources().getColor(R.color.divider)
                }.lparams {
                    width = matchParent
                    height = dip(1)
                }
            }
        }
    }
}