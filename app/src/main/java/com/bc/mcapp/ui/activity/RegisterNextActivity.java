package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.application.MyApplication;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.presenter.UserPresenerImpl;
import com.bc.mcapp.view.UserShowLogin;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/19.
 */
@ContentView(R.layout.act_setmessage)
public class RegisterNextActivity extends SwipeBackActivity implements UserShowLogin{
    @ViewInject(R.id.login_et_Name)
    EditText login_et_name;
    @ViewInject(R.id.set_tv_next)
    TextView set_tv_next;
    UserPresenerImpl userPresenerImpl;
    String phoneNum;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Intent intent=getIntent();
        phoneNum=intent.getStringExtra("registerPhone");
        userPresenerImpl=new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);




            set_tv_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!(login_et_name.getText().toString().trim()).equals("")) {
                        userPresenerImpl.userAddInfo(phoneNum, login_et_name.getText().toString().trim());

                    } else {
                        Toast.makeText(RegisterNextActivity.this, "请输入密码!", Toast.LENGTH_SHORT).show();
                    }
                };
            });

        
    }


    @Override
    public void showUserLogin(boolean bool) {}

    @Override
    public void showAddUser(boolean boo) {
        if(boo){
            if(phoneNum != null){
                Log.i("ttt",phoneNum+"");
                SharedPreferences sh=getSharedPreferences("isLogin",MODE_PRIVATE);
                SharedPreferences.Editor sd=sh.edit();
                sd.putBoolean("isLogBool",true);
                sd.putString("userName",phoneNum);
                sd.commit();
                Toast.makeText(RegisterNextActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                RegisterNextActivity.this.finish();
            }else {
                Toast.makeText(RegisterNextActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(RegisterNextActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showUserDenglu(boolean boo,String name) {

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
