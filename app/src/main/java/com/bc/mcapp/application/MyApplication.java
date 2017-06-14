	package com.bc.mcapp.application;

import org.xutils.DbManager;
import org.xutils.x;

import android.app.Application;

import com.yolanda.nohttp.NoHttp;

import java.io.File;

public class MyApplication extends Application {
	private DbManager.DaoConfig daoConfig;
	public DbManager.DaoConfig getDaoConfig(){
		return daoConfig;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		x.Ext.init(this);
		NoHttp.initialize(this);
		daoConfig=new DbManager.DaoConfig()
		.setDbName("myDbSQLite")
		.setDbDir(new File("/sdcard"))
		.setDbVersion(1)
		.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
			/////更新数据库
			@Override
			public void onUpgrade(DbManager dbManager, int i, int i1) {

			}
		});
	}




}
