package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.application.MyApplication;
import com.bc.mcapp.entity.usercar.UserCar_data;
import com.bc.mcapp.presenter.UserPresenerImpl;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.view.UserShowLogin;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/19.
 */
@ContentView(R.layout.act_phone_register)
public class RegisterPhoneActivity extends SwipeBackActivity implements View.OnClickListener,UserShowLogin{
    @ViewInject(R.id.reg_et_phone)
    EditText reg_et_phone;
    @ViewInject(R.id.reg_et_code)
    EditText reg_et_code;
    @ViewInject(R.id.reg_tvTip)
    TextView reg_tvTip;
    @ViewInject(R.id.reg_tv_next)
    TextView reg_tv_next;
    @ViewInject(R.id.tv_getTime)
    TextView tv_getTime;
    @ViewInject(R.id.tv_getCode)
    TextView tv_getCode;
    @ViewInject(R.id.reg_iv_back)
    ImageView reg_iv_back;
    @ViewInject(R.id.tv_getRegisterPhone)
    TextView tv_getRegisterPhone;
    final String CODE="86";
    private EventHandler handler;
    int num=60;
    Timer timer=new Timer();
    boolean bool=false;
    UserPresenerImpl userPresenerImpl;
    String phoneNums;
    String isPhoneNumsFit;
    private SwipeBackLayout swipeBackLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        userPresenerImpl=new UserPresenerImpl();
        userPresenerImpl.setUserShowLogin(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

        ////.初始化SDK,单例
        SMSSDK.initSDK(this,"17f97e69df6e5","43bd570ab7b291ab4c29062fd2eb9269");

        /*短信验证回调机制*/
        handler=new EventHandler(){
            @Override
            public void afterEvent(final int i,final int i1, Object o) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(i == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                            /** 提交验证码 */
                            if(i1 == SMSSDK.RESULT_COMPLETE){
                                Toast.makeText(RegisterPhoneActivity.this, "验证成功！", Toast.LENGTH_SHORT).show();

                                if(isPhoneNumsFit != null ){
                                    if(isPhoneNumsFit == phoneNums){
                                        Intent intent=new Intent(RegisterPhoneActivity.this,RegisterNextActivity.class);
                                        intent.putExtra("registerPhone",isPhoneNumsFit);
                                        startActivity(intent);
                                        RegisterPhoneActivity.this.finish();
                                        SMSSDK.unregisterEventHandler(handler);

                                    }else{
                                        Toast.makeText(RegisterPhoneActivity.this, "手机号不是注册手机号！", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(RegisterPhoneActivity.this, "手机号不能为空！", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(RegisterPhoneActivity.this, "验证码错误！", Toast.LENGTH_SHORT).show();
                            }
                        }else if(i == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                            /** 获取验证码成功后的执行动作 */
                            Toast.makeText(RegisterPhoneActivity.this, "已成功发送验证码！", Toast.LENGTH_SHORT).show();
                            reg_tv_next.setEnabled(true);
                            reg_tv_next.setBackgroundResource(R.drawable.dialog_btn);
                        }
                    }
                });
            }
        };
        /////注册回调接口
        SMSSDK.registerEventHandler(handler);
        tv_getCode.setOnClickListener(this);
        reg_tv_next.setOnClickListener(this);
        reg_iv_back.setOnClickListener(this);
        setMyEnabled(bool);

        reg_et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userPresenerImpl.userCheckLogin(Constants.USERLOGINPHONE_URL+s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    /*这是倒计时方法*/
   TimerTask task=new TimerTask() {
       @Override
       public void run() {
           runOnUiThread(new Runnable() {   /////这是一个UI线程
               @Override
               public void run() {
                   tv_getCode.setEnabled(false);
                   tv_getCode.setBackgroundResource(R.drawable.login_tv_bg);
                   tv_getTime.setVisibility(View.VISIBLE);
                   tv_getTime.setText(num+"秒");
                    num--;
                   if(num == 0){
                        timer.cancel();
                       tv_getTime.setVisibility(View.GONE);
                        bool=true;
                       tv_getCode.setBackgroundResource(R.drawable.dialog_btn);
                   }
               }
           });
       }

   };


    private  void setMyEnabled(boolean bool){
        if(bool == true){
            tv_getCode.setEnabled(true);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_getCode:


                    /////发送验证码
                phoneNums=reg_et_phone.getText().toString().trim();
                isPhoneNumsFit=phoneNums;
                    if(isMobelNo(phoneNums) == true){

                        timer.schedule(task,1000,1000);
                        SMSSDK.getVerificationCode(CODE,phoneNums);
                        String phoneHead=reg_et_phone.getText().toString().trim().substring(0,3);
                        String phoneEnd=reg_et_phone.getText().toString().trim().substring(7,11);
                        reg_tvTip.setText("验证码短信已经发送至"+phoneHead+"****"+phoneEnd+",请注意查收");
                    }else{
                        Toast.makeText(RegisterPhoneActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    }



                break;
            case R.id.reg_tv_next:
                /////提交验证码
                if(!(reg_et_code.getText().toString().trim()).equals("")){
                    if(phoneNums != null){
                        SMSSDK.submitVerificationCode(CODE,phoneNums,reg_et_code.getText().toString().trim());
                    }
                }else{
                    Toast.makeText(RegisterPhoneActivity.this, "请输入验证码！", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.reg_iv_back:
                RegisterPhoneActivity.this.finish();
                break;
        }
    }



    //////正则表达式手机号验证
    public static  boolean isMobelNo(String phone){
        boolean isValid = false;
        CharSequence inputStr = phone;
        Pattern p = Pattern.compile("^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8]))\\d{8}$");
        Matcher m = p.matcher(inputStr);
        if(m.matches()){
            isValid = true;
        }
        return isValid;
    }

    @Override
    public void showUserLogin(boolean bool) {
        if(bool == true){
            tv_getRegisterPhone.setVisibility(View.VISIBLE);
            tv_getRegisterPhone.setText("手机号已注册!");
        }else{

            tv_getRegisterPhone.setVisibility(View.GONE);
        }
    }

    @Override
    public void showAddUser(boolean boo) {}

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
