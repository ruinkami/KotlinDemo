package app.ruinkami.kotlindemo.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.ruinkami.kotlindemo.FakeServer;
import app.ruinkami.kotlindemo.R;

/**
 * Created by ruinkami on 2017/6/25.
 */

public class JListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    // View
    private ListView listView;
    private Button btnClearData;
    private Button btnUpdateData;

    // Data
    private ArrayList<JStudent> studentList = new ArrayList<>();
    private JListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_java);
        initView();
        initData();
    }

    private void initData() {
        listAdapter = new JListAdapter(studentList);
        listView.setAdapter(listAdapter);
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.java_list_view);
        btnClearData = (Button) findViewById(R.id.java_clear_btn);
        btnUpdateData = (Button) findViewById(R.id.java_update_btn);

        listView.setDividerHeight(0);

        listView.setOnItemClickListener(this);
        btnClearData.setOnClickListener(this);
        btnUpdateData.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnClearData) {
            studentList.clear();
            listAdapter.notifyDataSetChanged();
            showShortToast("已清空");
        } else if (view == btnUpdateData) {
            studentList.addAll(FakeServer.randomJavaResponse());
            listAdapter.notifyDataSetChanged();
            showShortToast("已更新10条数据");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(JListActivity.this, JInfoActivity.class);
        intent.putExtra("stu_name", studentList.get(i).getName());
        intent.putExtra("stu_age", studentList.get(i).getAge());
        intent.putExtra("stu_hobby", studentList.get(i).getHobby());
        intent.putExtra("stu_university", studentList.get(i).getUniversity());
        startActivity(intent);
    }

    private void showShortToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
