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