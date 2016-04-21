# Fine-Webview
Webview封装了一些功能，并添加了底部Bar，操作网页前进后退以及刷新 
# Gradle
```groovy
compile compile 'com.siokagami.android.finewebview:FineWebview:0.5.1'
```
# Usage
```java
import com.siokagami.android.finewebview.FineWebview;

public class MainActivity extends AppCompatActivity {
    private FineWebview finewebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init()
    {
        finewebview = (FineWebview) findViewById(R.id.finewebview);
        finewebview.setUrl("http://siokagami.me");
    }
}
```
# Method
|方法|说明|
|-------|-------|
|hideBottomToolBarVisiblity()|隐藏底部工具bar|
|setCacheMode()|设置缓存模式|
|enableJavaScript()|允许js脚本|
|getWebview()|获取webview|
# 说明
 默认开启底部工具栏，禁止js脚本运行，java与js交互的接口尚在开发中，先可以通过getWebview方法获取到Webview进行操作。 