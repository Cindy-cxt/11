package mobileshop.edu.huatec.com.mobileshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import mobileshop.edu.huatec.com.mobileshop.R;
import mobileshop.edu.huatec.com.mobileshop.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.common.MobileShopApp;

public class AdActivity extends BaseActivity{
    private TextView tv_skip;

    @Override
    public int getContentViewId(){
        return R.layout.activity_ad;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skip();
            }
        });


        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        String url = "http://i1.sinaimg.cn/ent/d/2008-06-04/U105P28T3D2048907F326DT20080604225106.jpg";
        ImageLoader.getInstance().displayImage(url, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                MobileShopApp.handler.post(jumpTread);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                MobileShopApp.handler.post(jumpTread);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
    }
        private final void skip(){
            Intent intent=new Intent(AdActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            c_count=COUNT;
            MobileShopApp.handler.removeCallbacks(jumpTread);
        }
        private static final String SKIP_TEXT="点击跳过 %d";
        private final  static int COUNT=5;
        private final static int DELAYED=1000;
        private  int c_count=COUNT;

        private Runnable jumpTread=new Runnable() {
            @Override
            public void run() {
                if (c_count<=0){
                    skip();
                }else {
                    tv_skip.setText(String.format(SKIP_TEXT,c_count));
                    c_count--;
                    MobileShopApp.handler.postDelayed(jumpTread,DELAYED);
                }
            }
        };
    }
