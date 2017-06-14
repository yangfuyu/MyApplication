package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.presenter.UserPresenerImpl;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.UserShowLogin;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/19.
 */
@ContentView(R.layout.act_login)
public class LoginActivity extends SwipeBackActivity implements UserShowLogin {
    private SwipeBackLayout swipeBackLayout;
    @ViewInject(R.id.login_btn)
    TextView login_btn;
    UserPresenerImpl userPresenerImpl;
    @ViewInject(R.id.login_et_name)
    EditText login_et_name;
    @ViewInject(R.id.login_et_pass)
    EditText login_et_pass;
    @ViewInject(R.id.login_phone_tv_reg)
    TextView login_phone_tv_reg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        userPresenerImpl=new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);

        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=login_et_name.getText().toString().trim();
                String pw=login_et_pass.getText().toString().trim();
                String url= Constants.USERLOGIN_URL+"loginId="+name+"&loginPwd="+pw;
                userPresenerImpl.userDengLu(url);
            }
        });
        IntentRegisterTo();

    }


    private void IntentRegisterTo(){
        login_phone_tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterPhoneActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void showUserLogin(boolean bool) {

    }

    @Override
    public void showAddUser(boolean boo) {

    }

    @Override
    public void showUserDenglu(boolean boo,String userName) {
        if(boo){
            SharedPreferences sh=getSharedPreferences("LoginSuccess",MODE_PRIVATE);
            SharedPreferences.Editor sd=sh.edit();
            sd.putString("LoginSuccessName",userName);
            sd.putBoolean("LoginSuccessBool",true);
            sd.commit();
            Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
            LoginActivity.this.finish();
        }else{
            Toast.makeText(LoginActivity.this, "没有此用户！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showUpdateName(boolean bool) {

    }

    @Override
    public void showUpdatePwd(boolean bool) {

    }

    @Override
    public void showUpdateSex(boolean bool) {

    }

    @Override
    public void showQueryUserCar(UserCar_data data) {

    }


}
