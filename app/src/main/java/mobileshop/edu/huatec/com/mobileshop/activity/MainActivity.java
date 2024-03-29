package mobileshop.edu.huatec.com.mobileshop.activity;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mobileshop.edu.huatec.com.mobileshop.R;
import mobileshop.edu.huatec.com.mobileshop.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {


    @Override
     public @LayoutRes
     int getContentViewId(){
        return R.layout.activity_main;
    }
    @Override
    protected void initView(){
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();
    }


    }



