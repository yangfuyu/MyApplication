package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
 */
@ContentView(R.layout.act_updatesex)
public class Act_Updatesex extends SwipeBackActivity implements UserShowLogin {
    @ViewInject(R.id.sex_ok1)
    ImageView sex_ok1;
    @ViewInject(R.id.sex_ok2)
    ImageView sex_ok2;
    @ViewInject(R.id.sex_ok3)
    ImageView sex_ok3;
    @ViewInject(R.id.updateSex_tv_ok)
    TextView updateSex_tv_ok;
    UserPresenerImpl userPresenerImpl;
    private SwipeBackLayout swipeBackLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        sex_ok1.setVisibility(View.GONE);
        sex_ok2.setVisibility(View.GONE);
        sex_ok3.setVisibility(View.VISIBLE);
        userPresenerImpl=new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);


    }

    @Event(value = {R.id.rela_nan,R.id.rela_nv,R.id.rela_baomi,R.id.updatesex_iv_back},type = View.OnClickListener.class)
    private void myOnClick(View v){
        switch (v.getId()){
            case R.id.rela_nan:
                sex_ok1.setVisibility(View.VISIBLE);
                sex_ok2.setVisibility(View.GONE);
                sex_ok3.setVisibility(View.GONE);
                updateSex_tv_ok.setEnabled(true);
                updateSex_tv_ok.setBackgroundResource(R.drawable.dialog_btn);
                myOnBtuClick(1);
            break;

            case R.id.rela_nv:
                sex_ok1.setVisibility(View.GONE);
                sex_ok2.setVisibility(View.VISIBLE);
                sex_ok3.setVisibility(View.GONE);
                updateSex_tv_ok.setEnabled(true);
                updateSex_tv_ok.setBackgroundResource(R.drawable.dialog_btn);
                myOnBtuClick(2);
            break;

            case R.id.rela_baomi:
                sex_ok1.setVisibility(View.GONE);
                sex_ok2.setVisibility(View.GONE);
                sex_ok3.setVisibility(View.VISIBLE);
                updateSex_tv_ok.setEnabled(true);
                updateSex_tv_ok.setBackgroundResource(R.drawable.dialog_btn);
                myOnBtuClick(3);
            break;

            case R.id.updatesex_iv_back:
                Act_Updatesex.this.finish();
                break;
        }

    }

    private void myOnBtuClick(final int i){
        updateSex_tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sh=getSharedPreferences("LoginSuccess",MODE_PRIVATE);
                String userId= sh.getString("LoginSuccessName","美美+") ;
                boolean bo=  sh.getBoolean("LoginSuccessBool",false);
                if(bo) {
                    userPresenerImpl.userUpdateSex(Constants.UPDATENAME_URL + "3&loginId=" + userId + "&value=" + i);
                    Act_Updatesex.this.finish();
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

    }

    @Override
    public void showUpdatePwd(boolean bool) {

    }

    @Override
    public void showUpdateSex(boolean bool) {
        if(bool){
            Toast.makeText(Act_Updatesex.this, "修改成功！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Act_Updatesex.this, "修改失败！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showQueryUserCar(UserCar_data data) {

    }


}
