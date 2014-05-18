package air.balloon.tennis.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import air.balloon.tennis.adapter.FriendAdapter;
import air.balloon.tennis.app.FriendActivity;
import air.balloon.tennis.app.R;
import air.balloon.tennis.model.TennisUser;
import air.balloon.tennis.model.TennisUserDTO;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


/**
 * Created by oliver on 5/9/14.
 */
public class FriendFragment extends MListFragment {
    List<TennisUser> users;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(
                TAG,"onCreate"
        );

    }


    @Override
    public void onStart() {
        super.onStart();
        getFreinds();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pullToRefreshView = (PullToRefreshListView) getView().findViewById(R.id.pull_to_refresh_listview);


        pullToRefreshView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase <ListView> refreshView) {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });


        pullToRefreshView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), FriendActivity.class);
                intent.putExtra("id",users.get(position-1).getId());
                startActivity(intent);




            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.i(
                TAG,"onCreateView"
        );
        return inflater.inflate(R.layout.fragment_friend_list,container,false);



    }


    class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            return new String[0];
        }

        @Override
        protected void onPostExecute(String[] result) {
            // Call onRefreshComplete when the list has been refreshed.


            pullToRefreshView.onRefreshComplete();
            super.onPostExecute(result);
            getFreinds();
        }
    }
    public Object getFreinds() {
        MyLog.print(TAG, "getFreinds");

        String url= API.getFriendList("", 1);
        MyLog.print(TAG,url);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);
                String json=new String(responseBody);


                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();



                        Type type = new TypeToken<TennisUserDTO>() {}.getType();

                        TennisUserDTO dto=gson.fromJson(json,type);

                        users=dto.getUser_TennisUser_List();

                        MyLog.print(TAG,"size:"+users.size());

                        for (Iterator iterator = users.iterator(); iterator.hasNext();) {
                            TennisUser user = (TennisUser) iterator.next();
                            MyLog.print(TAG,"friends:"+user.toString());
                        }


                       if(users==null)return;

                        FriendAdapter adapter=new FriendAdapter(getActivity().getBaseContext(),users);
                        pullToRefreshView.setAdapter(adapter);




            }
        });

        return null;
    }
}
