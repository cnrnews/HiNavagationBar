package com.imooc.navigation.navigationbar;

import android.view.View;
import android.view.ViewGroup;

/**
 *  NavigationBar 封装 通用方法
 */
public interface INavigationBar {
    //绑定和创建View
    void createNavigationBar();
    //绑定参数
    void attachNavigationParams();
    //将navigationView 添加到父布局
    void attachParent(View navigationView, ViewGroup parent);
}
