package air.balloon.tennis.value;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import air.balloon.tennis.utils.MD5;

/**
 * Created by oliver on 4/14/14.
 */
public class API {




   public static final String PRE_API=Config.Server+"/tennis/";


   private static final String salt="freeteam2014";


   public static final String getEventList(String keyword,int page){

       try {
           keyword= URLEncoder.encode(keyword,"utf-8");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       String url=PRE_API+"event?filter_LIKE_title="+keyword+"&page="+page+"";

       return url;
   }



    public static final String getCourtList(int cityid,int page){

        String url=PRE_API+"court_list?city_model__id="+cityid+"&page="+page+"";

        return url;
    }





    public static final String getMunicipalityCourtList(int provinceid,int page){

        String url=PRE_API+"court_list?province_model__id="+provinceid+"&page="+page+"";

        return url;
    }
    public static final String getFriendList(String keyword,int page){

        try {
            keyword= URLEncoder.encode(keyword,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url=PRE_API+"tennis_user?filter_LIKE_title="+keyword+"&page="+page+"";

        return url;
    }

    public static final String getFriend(long id){
        String url=PRE_API+"tennis_user/"+id;
        return url;
    }

    public static final String getCourt(long id){
        String url=PRE_API+"court_detial/"+id;
        return url;
    }

    public static final String getEvent(long id){

        String end="event"+salt+id;

      //  end=MD5.GetMD5Code(end);

        String url=PRE_API+end;
        return url;
    }


    public static final String REGISTER=PRE_API+"register";

    public static final String LOGIN=PRE_API+"login";

}
