package com.example.administrator.listviewskills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<String> strings=new ArrayList<String>();
    private ListView mylist=null;
    private int lastVisibleItemPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist=(ListView) findViewById(R.id.myListview);
        mylist.setEmptyView(findViewById(R.id.myEmptyView));
        for (int i = 0; i < 20; i++) {
            String onestring=""+i;
            strings.add(onestring);
        }
//        for (int i = 0; i < 10; i++) {
//            Log.d(TAG, "onCreate: -----------"+strings.get(i));
//        }
        final ViewHolderAdapter holderAdapter=new ViewHolderAdapter(this,strings);
        mylist.setAdapter(holderAdapter);
        mylist.setSelection(3);
        mylist.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        Log.d(TAG, "onScrollStateChanged: ----"+"stop");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        Log.d(TAG, "onScrollStateChanged: ****"+"moving");
                        break;
                    case SCROLL_STATE_FLING:
                        Log.d(TAG, "onScrollStateChanged: !!!!!!!!!"+"up");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                Log.d(TAG, "onScroll: "+firstVisibleItem+";"+visibleItemCount+";"+totalItemCount);
//                if(firstVisibleItem+visibleItemCount>=totalItemCount&&totalItemCount>0){
//                    Log.d(TAG, "onScroll: -------------get the last!");
//
//                }
                if(firstVisibleItem > lastVisibleItemPosition){
                    Log.d(TAG, "onScroll: 上滑");
                }else if (firstVisibleItem<lastVisibleItemPosition){
                    Log.d(TAG, "onScroll: x下滑");
                }
                lastVisibleItemPosition=firstVisibleItem;
            }
        });













//        mylist.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        Log.d(TAG, "onTouch: ----------"+"action_down");
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        Log.d(TAG, "onTouch:*********"+"action_move");
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        Log.d(TAG, "onTouch: !!!!!!!!!!!"+"action_up");
//                        break;
//                }
//                return false;
//            }
//        });
    }
}
