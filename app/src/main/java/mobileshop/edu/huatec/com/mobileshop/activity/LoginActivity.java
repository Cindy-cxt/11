package mobileshop.edu.huatec.com.mobileshop.activity;


import android.text.TextUtils;

import android.widget.EditText;



import butterknife.BindView;
import butterknife.OnClick;
import mobileshop.edu.huatec.com.mobileshop.R;
import mobileshop.edu.huatec.com.mobileshop.common.BaseActivity;
import mobileshop.edu.huatec.com.mobileshop.http.entity.MemberEntity;
import mobileshop.edu.huatec.com.mobileshop.http.presenter.MemberPresenter;
import mobileshop.edu.huatec.com.mobileshop.http.service.ProgressDialogSubscriber;
import mobileshop.edu.huatec.com.mobileshop.untils.SystemConfig;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_pwd)
    EditText etPwd;


    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.iv_back)
    void close(){finish();}

    @OnClick(R.id.bt_login)
    void login(){
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        if(TextUtils.isEmpty(userName)){
            toastshort("请输入用户名");
            return;
        }if (TextUtils.isEmpty(pwd)){
            toastshort("请输入密码");
            return;
        }
        MemberPresenter.login(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemConfig.setLogin(true);
                toastshort("登陆成功");
                SystemConfig.setLoginUserName(memberEntity.uname);
                SystemConfig.setLoginUserEmail(memberEntity.email);
                SystemConfig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }

        },userName,pwd);
    }
}
