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
 */

@ContentView(R.layout.act_advice)
public class Act_Advice extends SwipeBackActivity {
    private SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        swipeBackLayout=getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);

    }



}
