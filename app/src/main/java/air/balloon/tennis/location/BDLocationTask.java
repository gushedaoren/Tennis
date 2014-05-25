package air.balloon.tennis.location;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import air.balloon.tennis.app.R;
import air.balloon.tennis.utils.MyLog;
import air.balloon.tennis.value.Preference;

/**
 * Created by oliver on 5/21/14.
 */
public class BDLocationTask {
    public Context context;
    LocationClient locationClient;
    private static final int UPDATE_TIME = 5000;
    String TAG="BDLocationTask";
    SharedPreferences sp;

    public BDLocationTask(Context context) {
        this.context = context;
        sp=context.getSharedPreferences(Preference.SP,Context.MODE_PRIVATE);
    }


    public void stop(){
        locationClient.stop();
    }

    public void saveLocation() {
        MyLog.print(TAG,"saveLocation");
        locationClient=new LocationClient(context);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);                                //是否打开GPS
        option.setCoorType("bd09ll");                           //设置返回值的坐标类型。
        option.setPriority(LocationClientOption.NetWorkFirst);  //设置定位优先级
        option.setProdName(context.getString(R.string.app_name));                     //设置产品线名称。强烈建议您使用自定义的产品线名称，方便我们以后为您提供更高效准确的定位服务。
        option.setScanSpan(UPDATE_TIME);                        //设置定时定位的时间间隔。单位毫秒
        option.setIsNeedAddress(true);                         //显示城市
        locationClient.setLocOption(option);



        locationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                if(bdLocation==null)return;
               double lat=  bdLocation.getLatitude();
                double lon=bdLocation.getLongitude();
                MyLog.print(TAG,"lat:"+lat+" lon:"+lon);
                String city= bdLocation.getProvince();
                MyLog.print(TAG,"city:"+city);

                if(city!=null)
                sp.edit().putString("city",city).commit();

                locationClient.stop();



            }

            @Override
            public void onReceivePoi(BDLocation bdLocation) {


            }
        });

        locationClient.start();
        locationClient.requestLocation();

    }
}
