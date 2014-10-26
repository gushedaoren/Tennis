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
import java.util.LinkedList;
import java.util.List;

import air.balloon.tennis.adapter.CourtAdapter;
import air.balloon.tennis.adapter.EventAdapter;
import air.balloon.tennis.app.CourtActivity;
import air.balloon.tennis.app.R;
import air.balloon.tennis.model.Court;
import air.balloon.tennis.model.CourtListDTO;
import air.balloon.tennis.model.Event;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;
import air.balloon.tennis.value.Config;


/**
 * Created by oliver on 5/9/14.
 */
public class CourtListFragment extends MListFragment {

    String keyword="";
    int page=1;
    List<Court> courts;
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
        getCourts(9,page);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pullToRefreshView = (PullToRefreshListView) getView().findViewById(R.id.pull_to_refresh_listview);


        pullToRefreshView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });


        pullToRefreshView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), CourtActivity.class);
                intent.putExtra("id",courts.get(position-1).getId());
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
        return inflater.inflate(R.layout.fragment_court_list,container,false);



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
            getCourts(9 ,1);
        }
    }
    public Object getCourts(int cityid,int page) {
        MyLog.print(TAG, "getCourts");
        String url= API.getMunicipalityCourtList(cityid,page);

        Log.i(TAG,url);
        AsyncHttpClient client = new AsyncHttpClient(Config.HTTP_PORT);
        client.get(url, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);
                String json=new String(responseBody);

                Log.i(TAG,json.toString());
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();

                Type listType = new TypeToken<CourtListDTO>(){}.getType();


                CourtListDTO dto=gson.fromJson(json,listType);

                courts=dto.getResults();

                MyLog.print(TAG,"size:"+courts.size());

                for (Iterator iterator =courts.iterator(); iterator.hasNext();) {
                    Court court = (Court) iterator.next();
                    MyLog.print(TAG, "court:" + court.toString());
                }



                CourtAdapter adapter=new CourtAdapter(getActivity().getBaseContext(),courts);
                pullToRefreshView.setAdapter(adapter);



            }
        });

        return null;
    }
}
