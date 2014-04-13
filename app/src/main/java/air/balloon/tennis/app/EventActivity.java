package air.balloon.tennis.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.*;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import org.apache.http.Header;

import java.lang.reflect.Type;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import air.balloon.tennis.model.Court;
import air.balloon.tennis.model.Evaluate;
import air.balloon.tennis.model.Event;
import air.balloon.tennis.model.ImageFile;
import air.balloon.tennis.model.TennisUser;
import air.balloon.tennis.parent.BaseActivity;
import air.balloon.tennis.utils.MyLog;


public class EventActivity extends BaseActivity {


    List<Event> listEvent;
    List<Court> listCourt;
    List<Evaluate> listEvaluate;
    List<ImageFile> listImage;
    List<TennisUser> listUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        getEvents();
    }

    public Object getEvents() {
        MyLog.print(TAG,"getEvents");
        String url="http://218.244.146.177:8080/quickstart/api/v1/event";
        String url2="http://218.244.146.177:8080/quickstart/api/v1/event/1";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                super.onSuccess(statusCode, headers, responseBody);
                String json=new String(responseBody);


                Gson gson = new GsonBuilder().registerTypeAdapter(Timestamp.class, new SqlTimestampConverter()).setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .create();

                Type listType = new TypeToken<LinkedList<Event>>(){}.getType();


                LinkedList<Event> events=gson.fromJson(json,listType);

                MyLog.print(TAG,"size:"+events.size());

                for (Iterator iterator = events.iterator(); iterator.hasNext();) {
                    Event event = (Event) iterator.next();
                    MyLog.print(TAG,"event:"+event.toString());
                }


            }
        });

        return null;
    }
}


 class SqlTimestampConverter implements JsonSerializer<Timestamp> {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public JsonElement serialize(Timestamp src, Type srcType,
                                 JsonSerializationContext context) {
        return new JsonPrimitive(sdf.format(src));
    }
}
