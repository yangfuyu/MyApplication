package com.bc.mcapp.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bc.mcapp.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by admins on 2016/10/21.
 *
 *
 * 收藏商品
 */
@ContentView(R.layout.act_collection)
public class Act_Collection extends SwipeBackActivity {
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

    }



}
