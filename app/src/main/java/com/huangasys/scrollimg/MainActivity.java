package com.huangasys.scrollimg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private Button mButton;
    private ScollLinearLayoutManager mScollLinearLayoutManager;
    float x = 30f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mRecyclerView = findViewById(R.id.recycle);
        mRecyclerView.setAdapter(new ScrollAdapter());
        mScollLinearLayoutManager = new ScollLinearLayoutManager(MainActivity.this);
        mScollLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mScollLinearLayoutManager);

        //smoothScrollToPosition滚动到某个位置（有滚动效果）
        mRecyclerView.smoothScrollToPosition(Integer.MAX_VALUE / 2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScollLinearLayoutManager.setSpeedSlow((x--));
                mRecyclerView.smoothScrollToPosition(Integer.MAX_VALUE / 2);
                Log.d("print", "onClick: "+x);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.smoothScrollToPosition(Integer.MAX_VALUE / 2);
    }
}
