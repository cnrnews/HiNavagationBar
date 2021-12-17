# HiNavagationBar

#### 介绍
自定义通用NavigationBar

#### 软件架构
架构中使用了Builder构建者模式


#### 使用说明


```
new DefaultNavigationBar
                .Builder(this,findViewById(R.id.root_view)) // 要添加的根布局的viewID
                .hideLeftText()// 隐藏左侧图标
                .setLeftText("返回") // 设置左侧按钮文字
                .setLeftClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 返回上一页
                    }
                }) // 设置左侧按钮点击事件
                .setTitle("主页")// 设置标题
                .setRightText("发布") // 设置右侧文本
                .setRightClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 提交发布信息
                    }
                })// 右侧右侧按钮点击事件
                .build();
```

### 封装思想
 * NavigationBar 封装：
 * 高扩展：并不是要把所有的内容和出现的问题都想到，而是在新增功能的时候可以保证原来的代码不变
 * 最少知识原则，使用者并不想知道的太多
