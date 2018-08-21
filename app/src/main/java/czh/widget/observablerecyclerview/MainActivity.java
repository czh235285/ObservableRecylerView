package czh.widget.observablerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import czh.widget.ObservableRecylerView;
import czh.widget.ObservableScrollViewCallbacks;
import czh.widget.ScrollState;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        ObservableRecylerView rcv = (ObservableRecylerView) findViewById(R.id.rcv);
        rcv.setScrollViewCallbacks(this);
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            a.add(i + "");
        }
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(new DemoAdapter(R.layout.item, a));
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (scrollState == ScrollState.UP) {
            if (tv.getVisibility() == View.VISIBLE) {
                tv.setVisibility(View.GONE);
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (tv.getVisibility() == View.GONE) {
                tv.setVisibility(View.VISIBLE);
            }
        }
    }
}
