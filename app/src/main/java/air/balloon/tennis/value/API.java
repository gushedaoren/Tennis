package air.balloon.tennis.value;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by oliver on 4/14/14.
 */
public class API {

   public static final String REGISTER="http://www.baidu.com/";


   public static final String getEventList(String keyword,int page){

       try {
           keyword= URLEncoder.encode(keyword,"utf-8");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       String url="http://218.244.146.177:8080/quickstart/api/v1/event?filter_LIKE_title="+keyword+"&page="+page+"";

       return url;
   }



    public static final String getCourtList(String keyword,int page){

        try {
            keyword= URLEncoder.encode(keyword,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url="http://218.244.146.177:8080/quickstart/api/v1/court?filter_LIKE_title="+keyword+"&page="+page+"";

        return url;
    }

}
