package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/21.
 *
 */
@ContentView(R.layout.act_updatename)
public class Act_Updatename extends SwipeBackActivity implements UserShowLogin {
    @ViewInject(R.id.updateName_tv_ok)
    TextView updateName_tv_ok;
    @ViewInject(R.id.updateName_et_name)
    EditText updateName_et_name;
    String name;
    UserPresenerImpl userPresenerImpl;
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        userPresenerImpl=new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

        updateName_et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                name=updateName_et_name.getText().toString().trim();
                if(updateName_et_name.getText()+"" == ""){
                    updateName_tv_ok.setBackgroundResource(R.drawable.login_tv_bg);
                }else{
                    updateName_tv_ok.setBackgroundResource(R.drawable.dialog_btn);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        updateName_tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(updateName_et_name.getText()+"" != ""){
                    SharedPreferences sh=getSharedPreferences("LoginSuccess",MODE_PRIVATE);
                    String userId= sh.getString("LoginSuccessName","美美+") ;
                    boolean bo=  sh.getBoolean("LoginSuccessBool",false);
                    if(bo){
                        userPresenerImpl.userUpdateName(Constants.UPDATENAME_URL+"2&loginId="+userId+"&value="+name);
                        Act_Updatename.this.finish();
                    }
                }else{
                    Toast.makeText(Act_Updatename.this, "昵称不能为空", Toast.LENGTH_SHORT).show();
                }
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
    public void showUserDenglu(boolean boo, String name) {

    }

    @Override
    public void showUpdateName(boolean bool) {
        if(bool){
            Toast.makeText(Act_Updatename.this, "修改成功！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Act_Updatename.this, "修改失败！", Toast.LENGTH_SHORT).show();
        }
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
