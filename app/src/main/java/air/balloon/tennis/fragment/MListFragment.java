package air.balloon.tennis.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by oliver on 5/9/14.
 */
public class MListFragment extends ParentFragment {
    PullToRefreshListView pullToRefreshView;

    int mPosition;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public void onStart() {
        super.onStart();


        pullToRefreshView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                // 不滚动时保存当前滚动到的位置
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    mPosition = view.getFirstVisiblePosition();

                    Log.i(TAG,"mPosition:"+mPosition);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }
}
