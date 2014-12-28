package air.balloon.tennis.fragment;

import android.app.Activity;
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

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import air.balloon.tennis.adapter.CourtAdapter;
import air.balloon.tennis.app.CourtActivity;
import air.balloon.tennis.app.R;
import air.balloon.tennis.city.ChangeCityListener;
import air.balloon.tennis.model.Court;
import air.balloon.tennis.model.CourtListDTO;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.API;
import air.balloon.tennis.value.Config;


/**
 * Created by oliver on 5/9/14.
 */
public class CourtListFragment extends MListFragment implements ChangeCityListener {

    String keyword="";
    int page=1;
    List<Court> courts;

    CourtAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter=new CourtAdapter(getActivity());
        Log.i(
                TAG,"onCreate"
        );

    }

    @Override
    public void onStart() {
        super.onStart();



        try{
            getCourts(cityid,page);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pullToRefreshView = (PullToRefreshListView) getView().findViewById(R.id.pull_to_refresh_listview);


        pullToRefreshView.setOnPullEventListener(new PullToRefreshBase.OnPullEventListener<ListView>() {
            @Override
            public void onPullEvent(PullToRefreshBase<ListView> refreshView, PullToRefreshBase.State state, PullToRefreshBase.Mode direction) {

            }
        });

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

                intent.putExtra("court", (Serializable) courts.get(position-1));
                startActivity(intent);
            }
        });

        View footerView=LayoutInflater.from(getActivity()).inflate(R.layout.footer_view,null);
        pullToRefreshView.getRefreshableView().addFooterView(footerView);
        footerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page++;
                new GetDataTask().execute();
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

    @Override
    public void onChangeCityAction(int cityid) {
        page=1;
        new GetDataTask().execute();
    }


    class GetDataTask extends AsyncTask<Void, Void, Object[]> {

        @Override
        protected Object[] doInBackground(Void... params) {
            return new String[0];
        }

        @Override
        protected void onPostExecute(Object[] result) {
            // Call onRefreshComplete when the list has been refreshed.


            pullToRefreshView.onRefreshComplete();
            super.onPostExecute(result);
            getCourts(cityid ,page);
        }
    }
    public Object getCourts(int cityid, final int page) {
        cityid=sp.getInt("cityid",73);
        MyLog.print(TAG, "getCourts");

        String url=API.getMunicipalityCourtList(9,page);
        switch (cityid){
            case 73:
                url=API.getMunicipalityCourtList(9,page);
                break;

            default:
                url=API.getCourtList(cityid,page);
                break;

        }



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

                if(page==1){
                    courts=dto.getResults();
                }else{
                    courts.addAll(dto.getResults());
                }


                MyLog.print(TAG,"size:"+courts.size());




                adapter.setCourts(courts);

                if(page==1)
                pullToRefreshView.setAdapter(adapter);



                adapter.notifyDataSetChanged();




            }
        });

        return null;
    }






}
