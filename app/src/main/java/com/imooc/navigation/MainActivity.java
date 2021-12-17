package com.imooc.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.imooc.navigation.navigationbar.DefaultNavigationBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NavigationBar 使用
        new DefaultNavigationBar
                .Builder(this,findViewById(R.id.root_view))
                .hideLeftText()// 隐藏左侧图标
                .setLeftText("返回")
                .setLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 返回上一页
                    }
                })
                .setTitle("主页")// 设置标题
                .setRightText("发布")
                .setRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 提交发布信息
                    }
                })// 右侧view点击事件
                .build();
    }
}