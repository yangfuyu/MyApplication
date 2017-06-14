package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bc.mcapp.R;
import com.bc.mcapp.entity.conditions.Conditions_data;
import com.bc.mcapp.entity.detailgoods.DetailGoods_data;
import com.bc.mcapp.entity.listquerygoodds.LikeQueryGoods_Data;
import com.bc.mcapp.entity.listquerygoodds.QueryData;
import com.bc.mcapp.presenter.GoodsInfoPreImpl;
import com.bc.mcapp.ui.adapter.GoodsLikeQueryAdapter;
import com.bc.mcapp.utils.Constants;
import com.bc.mcapp.utils.EncoderUtils;
import com.bc.mcapp.view.GoodsInfo;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by admins on 2016/10/31.
 */
@ContentView(R.layout.act_search_topbar)
public class Act_SearchClas extends Activity implements GoodsInfo{
    @ViewInject(R.id.autTV_Se_top)
    AutoCompleteTextView autTV_Se_top;
    @ViewInject(R.id.lv_Se_listviewOne)
    ListView lv_Se_listviewOne;
    @ViewInject(R.id.lv_Se_listviewTwo)
    ListView lv_Se_listviewTwo;
    ArrayList<QueryData> listLike=new ArrayList<QueryData>();
    @ViewInject(R.id.iv_Se_topGo)
    ImageView iv_Se_topGo;
    GoodsLikeQueryAdapter adapter;
    @ViewInject(R.id.tv_Se_topTvDeleAll)
    TextView tv_Se_topTvDeleAll;

    GoodsInfoPreImpl goodsInfoPreImpl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        goodsInfoPreImpl=new GoodsInfoPreImpl();
        goodsInfoPreImpl.setGoodsInfo(this);
        autoTextListener();
    }


    private  void autoTextListener(){
        autTV_Se_top.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if((autTV_Se_top.getText().toString()).equals("")){
                    lv_Se_listviewOne.setVisibility(View.GONE);
                    lv_Se_listviewTwo.setVisibility(View.VISIBLE);

                }else{
                    lv_Se_listviewOne.setVisibility(View.VISIBLE);
                    lv_Se_listviewTwo.setVisibility(View.GONE);
                    String info=autTV_Se_top.getText().toString();
                    String infoUTF= EncoderUtils.convertCodeNetUTF(info);
                    goodsInfoPreImpl.likeQueryGoods(Constants.LIKEQUERY_URL+infoUTF);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public void showGoodsTypeData(Conditions_data data) {}



    @Override
    public void showLikeQueryGooods(LikeQueryGoods_Data data) {
        listLike=data.getData();
       if(listLike != null){
           adapter=new GoodsLikeQueryAdapter(Act_SearchClas.this,listLike);
           lv_Se_listviewOne.setAdapter(adapter);
           adapter.notifyDataSetChanged();
       }

    }

    @Override
    public void showSingleGoodsInfo(DetailGoods_data data) {

    }


}
