package com.imooc.navigation.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imooc.navigation.R;


public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder> {

    public DefaultNavigationBar(Builder builder) {
        super(builder);
    }

    @Override
    public void attachNavigationParams() {
        super.attachNavigationParams();
        // 处理特性的属性功能
        View leftText = findViewById(R.id.back_tv);
        leftText.setVisibility(getBuilder().mLeftVisible);
    }
    public void setTitle(String title){
        TextView titleView = findViewById(R.id.title_tv);
        titleView.setText(title);
    }
    public static class Builder extends AbsNavigationBar.Builder<DefaultNavigationBar.Builder>{

        // 定义自身属性：左边图标是否显示
        public int mLeftVisible = View.VISIBLE;
        public Builder(Context context, ViewGroup parent) {
            super(context, R.layout.ui_default_navigation_bar, parent);
        }

        @Override
        public DefaultNavigationBar build() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text){
            setText(R.id.back_tv,text);
            return this;
        }
        public Builder setLeftClickListener(View.OnClickListener listener){
            setOnClickListener(R.id.back_tv,listener);
            return this;
        }
        public Builder setTitle(String text){
            setText(R.id.title_tv,text);
            return this;
        }
        public Builder setRightText(String text){
            setText(R.id.right_tv,text);
            return this;
        }
        public Builder setRightClickListener(View.OnClickListener listener){
            setOnClickListener(R.id.right_tv,listener);
            return this;
        }
        /**
         * 隐藏文本
         * @return
         */
        public Builder hideLeftText(){
            mLeftVisible = View.INVISIBLE;
            return this;
        }
    }
}
