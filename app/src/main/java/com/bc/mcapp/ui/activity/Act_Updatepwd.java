package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.presenter.UserPresenerImpl;
import com.bc.mcapp.view.UserShowLogin;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/21.
 *
 */
@ContentView(R.layout.act_updatepwd)
public class Act_Updatepwd extends SwipeBackActivity implements UserShowLogin {
  /*  @ViewInject(R.id.et_old)
    EditText et_old;*/
    @ViewInject(R.id.et_new)
    EditText et_new;
    @ViewInject(R.id.et_new_agion)
    EditText et_new_agion;
    @ViewInject(R.id.update_pwd_ok)
    TextView update_pwd_ok;
    UserPresenerImpl userPresenerImpl;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        userPresenerImpl=new  UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

      /*  et_old.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                userPresenerImpl.userUpdatePwd(et_old.getText().toString());
            }
        });*/
        if(et_new.getText().toString()!= null && et_new_agion.getText().toString()!= null ){
            if(et_new.getText().toString().equals(et_new_agion.getText().toString())){
                update_pwd_ok.setEnabled(true);
                update_pwd_ok.setBackgroundResource(R.drawable.dialog_btn);
                update_pwd_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sh=getSharedPreferences("LoginSuccess",MODE_PRIVATE);
                        String userId= sh.getString("LoginSuccessName","美美+") ;
                        boolean bo=  sh.getBoolean("LoginSuccessBool",false);
                        if(bo){
                            userPresenerImpl.userUpdatePwd(4+"&loginId="+userId+"&value="+et_new.getText().toString().trim());
                            Act_Updatepwd.this.finish();
                        }
                    }
                });
            }else {
                Toast.makeText(Act_Updatepwd.this, "两次密码不符!", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Act_Updatepwd.this, "请输入完整信息!", Toast.LENGTH_SHORT).show();
        }



    }


    @Override
    public void showUserLogin(boolean bool) {

    }

    @Override
    public void showAddUser(boolean boo) {

    }

    @Override
    public void showUserDenglu(boolean boo, String name) {

    }

    @Override
    public void showUpdateName(boolean bool) {

    }

    @Override
    public void showUpdatePwd(boolean bool) {
        if(bool){
            Toast.makeText(Act_Updatepwd.this, "修改成功！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Act_Updatepwd.this, "修改失败！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showUpdateSex(boolean bool) {

    }

    @Override
    public void showQueryUserCar(UserCar_data data) {

    }


}
