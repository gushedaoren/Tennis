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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import air.balloon.tennis.adapter.EventAdapter;
import air.balloon.tennis.app.CourtActivity;
import air.balloon.tennis.app.EventActivity;
import air.balloon.tennis.app.R;
import air.balloon.tennis.model.Event;
import air.balloon.tennis.model.EventListDTO;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;


/**
 * Created by oliver on 5/9/14.
 */
public class EventListFragment extends MListFragment {
    List<Event> events;
    int page=1;
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
        getEvents(73,"",1);

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
                Intent intent=new Intent(getActivity(), EventActivity.class);


                Bundle b=new Bundle();
                b.putSerializable("event",events.get(position-1));
                intent.putExtras(b);
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
        return inflater.inflate(R.layout.fragment_event_list,container,false);



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
            getEvents(73,"",page);
        }
    }
    public Object getEvents(int cityid,String keyword, final int page) {
        MyLog.print(TAG, "getEvents");

        String url= API.getEventList(keyword,page);
        MyLog.print(TAG,url);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);
                String json=new String(responseBody);



                MyLog.print(TAG,json);
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();



                        Type type = new TypeToken<EventListDTO>() {}.getType();

                        EventListDTO dto=gson.fromJson(json,type);




                        events=dto.getResults();

                        MyLog.print(TAG,"size:"+events.size());

                        for (Iterator iterator = events.iterator(); iterator.hasNext();) {
                            Event event = (Event) iterator.next();
                           // MyLog.print(TAG,"event:"+event.toString());
                        }

                        if(events==null)return;

                        EventAdapter adapter=new EventAdapter(getActivity().getBaseContext(),events);
                        pullToRefreshView.setAdapter(adapter);




            }
        });

        return null;
    }
}
