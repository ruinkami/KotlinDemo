package app.ruinkami.kotlindemo.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import app.ruinkami.kotlindemo.R;

/**
 * Created by ruinkami on 2017/6/25.
 */

public class JInfoActivity extends AppCompatActivity {

    private TextView javaInfoName;
    private TextView javaInfoAge;
    private TextView javaInfoHobby;
    private TextView javaInfoUniversity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_java);
        initView();
        initData();
        showShortToast("信息展示完毕");
    }

    private void initData() {
        String stuName = getIntent().getStringExtra("stu_name");
        if (stuName != null) {
            javaInfoName.setText(stuName);
        }

        int stuAge = getIntent().getIntExtra("stu_age", 20);
        javaInfoAge.setText(Integer.toString(stuAge));

        String stuHobby = getIntent().getStringExtra("stu_hobby");
        if (stuHobby != null) {
            javaInfoHobby.setText(stuHobby);
        }

        String stuUniversity = getIntent().getStringExtra("stu_university");
        if (stuUniversity != null) {
            javaInfoUniversity.setText(stuUniversity);
        }
    }

    private void initView() {
        javaInfoName = (TextView) findViewById(R.id.java_info_name);
        javaInfoAge = (TextView) findViewById(R.id.java_info_age);
        javaInfoHobby = (TextView) findViewById(R.id.java_info_hobby);
        javaInfoUniversity = (TextView) findViewById(R.id.java_info_university);
    }

    private void showShortToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
