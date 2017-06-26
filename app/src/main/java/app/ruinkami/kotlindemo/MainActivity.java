package app.ruinkami.kotlindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.ruinkami.kotlindemo.java.JListActivity;
import app.ruinkami.kotlindemo.kotlin.KListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.java_list_page_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JListActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.kotlin_list_page_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, KListActivity.class);
                startActivity(intent);
            }
        });
    }
}
