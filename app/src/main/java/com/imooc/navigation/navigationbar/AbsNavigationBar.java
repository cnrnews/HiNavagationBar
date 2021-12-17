package com.imooc.navigation.navigationbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * NavigationBar 封装：
 * 1. 高扩展：并不是要把所有的内容和出现的问题都想到，而是在新增功能的时候可以保证原来的代码不变
 * 2. 最少知识原则，使用者并不想知道的太多
 * @param <P>
 */
public abstract class AbsNavigationBar<P extends AbsNavigationBar.Builder> implements INavigationBar {

    private P mBuilder;
    private View mNavigationView;

    public AbsNavigationBar(P builder) {
        this.mBuilder = builder;
        createNavigationBar();
    }
    /**
     * 绑定和创建View
     */
    @Override
    public void createNavigationBar(){
        mNavigationView = LayoutInflater.from(mBuilder.mContext)
                .inflate(mBuilder.mLayoutId, mBuilder.mParent, false);
        // 添加
        attachParent(mNavigationView,mBuilder.mParent);
        // 绑定参数
        attachNavigationParams();
    }

    /**
     * 绑定参数
     */
    @Override
    public void attachNavigationParams() {
        // 设置文本
        Map<Integer,CharSequence> textMaps = mBuilder.mTextMaps;
        for (Map.Entry<Integer, CharSequence> entry : textMaps.entrySet()) {
            TextView textView = findViewById(entry.getKey());
            textView.setText(entry.getValue());
        }

        // 设置点击事件
        Map<Integer,View.OnClickListener> clickListenerMaps = mBuilder.mClickListenerMaps;
        for (Map.Entry<Integer, View.OnClickListener> entry : clickListenerMaps.entrySet()) {
            View view = findViewById(entry.getKey());
            view.setOnClickListener(entry.getValue());
        }
    }
    public <T extends View> T findViewById(int viewId){
        return mNavigationView.findViewById(viewId);
    }
    /**
     * 将navigationView 添加到父布局
     * @param navigationView
     * @param parent
     */
    @Override
    public void attachParent(View navigationView, ViewGroup parent) {
        parent.addView(navigationView,0);
    }

    public P getBuilder() {
        return mBuilder;
    }

    /**
     * 构建类
     * 构建 NavigationBar 的基本参数
     */
    public abstract static class Builder<B extends Builder>{
        public Context mContext;
        public int mLayoutId;
        public ViewGroup mParent;

        // 设置View 文本的集合
        public Map<Integer,CharSequence> mTextMaps;
        // 设置View  点击事件的集合
        public Map<Integer,View.OnClickListener> mClickListenerMaps;

        public Builder(Context context,int layoutId, ViewGroup parent) {
           this.mContext = context;
           this.mLayoutId = layoutId;
           this.mParent = parent;

            mTextMaps = new HashMap<>();
            mClickListenerMaps = new HashMap<>();
        }

        public B setText(int viewId,String text){
            mTextMaps.put(viewId,text);
            return (B) this;
        }
        public B setOnClickListener(int viewId,View.OnClickListener listener){
            mClickListenerMaps.put(viewId,listener);
            return (B) this;
        }

        /**
         * 用来构建 NavigationBar
         * @return
         */
        public abstract AbsNavigationBar build();
    }
}
