package com.bc.mcapp.ui.activity;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.bc.mcapp.R;

public class MainActivity extends Activity {
	boolean bo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);


		try {
			Thread.sleep(2000);
			SharedPreferences sh=getSharedPreferences("logo",MODE_PRIVATE);
			bo=sh.getBoolean("bool", false);
			if(bo == true){
				Intent intent=new Intent(MainActivity.this,FirstActivity.class);
				startActivity(intent);
				MainActivity.this.finish();
			}else{
				Intent intent=new Intent(MainActivity.this,LogoViewpagerActivity.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
	
}
