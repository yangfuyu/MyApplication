package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bc.mcapp.R;
import com.bc.mcapp.utils.IsIntentUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/21.
 *
 */
@ContentView(R.layout.act_myaccount)
public class Act_Myaccount extends SwipeBackActivity {
    private SwipeBackLayout swipeBackLayout;
    IsIntentUtils iss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        iss=new IsIntentUtils();
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);


    }


    @Event(value ={R.id.account_name,R.id.account_sex,
            R.id.account_brithday,R.id.account,
            R.id.exit,R.id.myaccount_iv_back},
            type= View.OnClickListener.class)
    private void toOnClick(View v){
       switch (v.getId()){
           case R.id.account_name:
                iss.toIntentActivity(this,Act_Updatename.class);
           break;
           case R.id.account_sex:
               iss.toIntentActivity(this,Act_Updatesex.class);
               break;
           case R.id.account_brithday:
               iss.toIntentActivity(this,Act_Brithday.class);
               break;
           case R.id.account:
              iss.toIntentActivity(this, Act_Updatepwd.class);
               break;
           case  R.id.exit:
             //退出登录
               SharedPreferences sh=getSharedPreferences("LoginSuccess",MODE_PRIVATE);
               SharedPreferences.Editor sd=sh.edit();
               sd.putBoolean("LoginSuccessBool",false);
               sd.commit();
               Act_Myaccount.this.finish();
               break;
           case  R.id.myaccount_iv_back:
               Act_Myaccount.this.finish();////fanhui
               break;
       }

    }



}
