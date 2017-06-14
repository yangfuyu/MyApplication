package com.bc.mcapp.ui.fragment;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bc.mcapp.R;
import com.bc.mcapp.application.MyApplication;
import com.bc.mcapp.ui.activity.Act_Address;
import com.bc.mcapp.ui.activity.Act_Advice;
import com.bc.mcapp.ui.activity.Act_Collection;
import com.bc.mcapp.ui.activity.Act_EWCode;
import com.bc.mcapp.ui.activity.Act_Myaccount;
import com.bc.mcapp.utils.IsIntentUtils;

public class FirstMeFgm extends Fragment {
	View view;
	@ViewInject(R.id.fgm_me_tvLogin)
	TextView fgm_me_tvLogin;
	IsIntentUtils iss;
	String userName;
	boolean bo;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=LayoutInflater.from(getActivity()).inflate(R.layout.fgm_first_me,null);
		x.view().inject(this, view);
		iss=new IsIntentUtils();



		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		SharedPreferences sh=getActivity().getSharedPreferences("LoginSuccess", Context.MODE_PRIVATE);
		userName=sh.getString("LoginSuccessName","noUser");
		bo=sh.getBoolean("LoginSuccessBool",false);

		if(bo){
			fgm_me_tvLogin.setText(userName);
		}else{
			fgm_me_tvLogin.setText("登录/注册");
		}
	}

	/*
        * me监听事件
        * */
	@Event(value = {R.id.fgm_me_ivLogin,R.id.fgm_me_tvLogin,
	R.id.fgm_me_linGuanli,R.id.fgm_me_linGoods,R.id.fgm_me_linSee,
			R.id.fgm_me_linDaiFuKuan,R.id.fgm_me_linDaiPinJia,R.id.fgm_me_linTuiKuan,
			R.id.fgm_me_linAddrGuanLi,R.id.fgm_me_linQiangHongBao,R.id.fgm_me_linJiFen,
			R.id.fgm_me_HongBao,R.id.fgm_me_linYuE,R.id.fgm_me_linHelp,R.id.fgm_me_linDingdan,
			R.id.fgm_me_ivEWCode
	},type = View.OnClickListener.class)
	private void OnClickLogin(View view){
		switch (view.getId()){
			case R.id.fgm_me_ivLogin:
				if(bo){
					iss.toIntentActivity(getActivity(),Act_Myaccount.class);
				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_tvLogin:
				if(bo){
					iss.toIntentActivity(getActivity(),Act_Myaccount.class);
				}else{
					isIntentLoginOverGo();
				}
				break;
			case R.id.fgm_me_linGuanli:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linGoods:

				if(bo){
					iss.toIntentActivity(getActivity(),Act_Collection.class);
				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linSee:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}
				break;
			case R.id.fgm_me_linDaiPinJia:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linDaiFuKuan:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linTuiKuan:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linAddrGuanLi:

				if(bo){
					iss.toIntentActivity(getActivity(),Act_Address.class);
				}else{
					isIntentLoginOverGo();
				}


				break;
			case R.id.fgm_me_linQiangHongBao:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linJiFen:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_HongBao:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linYuE:
				if(bo){

				}else{
					isIntentLoginOverGo();
				}

				break;
			case R.id.fgm_me_linHelp:

				if(bo){
					iss.toIntentActivity(getActivity(),Act_Advice.class);
				}else{
					isIntentLoginOverGo();
				}
				break;
			case R.id.fgm_me_linDingdan:
				if(bo){
					iss.toIntentActivity(getActivity(),Act_Advice.class);
				}else{
					isIntentLoginOverGo();
				}
				break;
			case R.id.fgm_me_ivEWCode:
				if(bo){
					Intent intent=new Intent(getActivity(),Act_EWCode.class);
					intent.putExtra("ewCode",userName);
					startActivity(intent);
				}else{
					isIntentLoginOverGo();
				}
				break;

		}
	}




	private void isIntentLoginOverGo(){
		iss.isCheckLogin(getActivity(),true);
	}







}
