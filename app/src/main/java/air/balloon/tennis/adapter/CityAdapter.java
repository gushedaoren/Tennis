package air.balloon.tennis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;



import java.util.HashMap;
import java.util.List;


import air.balloon.tennis.app.R;
import air.balloon.tennis.model.BaseCity;
import air.balloon.tennis.utils.MyLog;
import indexable.StringMatcher;

/**
 * Created by oliver on 5/24/14.
 */
public class CityAdapter extends BaseAdapter implements SectionIndexer {

    Context context;

    private String mSections = "热ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String TAG="CityAdapter";

    List<BaseCity> citys;
    HashMap<String,Integer> hashMap=new HashMap<String, Integer>();

    public CityAdapter(Context context, List<BaseCity> citys) {
        this.context = context;
        this.citys = citys;
        initIndex();
    }

    private void initIndex() {
        int i=0;
        for(BaseCity city:citys){

            String header=city.getFirsrLetter();
            if(city.isHot())header=context.getString(R.string.hot_city);

            if(!hashMap.containsKey(header)){
                hashMap.put(header,i);
            }

            i++;

        }

        MyLog.print(TAG,"hashMap:"+hashMap.toString());
    }

    @Override
    public int getCount() {
        return citys.size();
    }



    @Override
    public String getItem(int position) {
        if(citys.get(position).isHot())return "热";

        return citys.get(position).getFirsrLetter();
    }

    @Override
    public long getItemId(int position) {
        return citys.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BaseCity city=citys.get(position);
        Holder holder=new Holder();
       if(convertView==null){
        convertView= LayoutInflater.from(context).inflate(R.layout.city_list_item,null);


        holder.txt1= (android.widget.TextView) convertView.findViewById(R.id.txt1);
        holder.txt2= (android.widget.TextView) convertView.findViewById(R.id.txt2);
       // holder.txt3= (android.widget.TextView) convertView.findViewById(R.id.txt3);
        convertView.setTag(holder);

       }else{
        holder= (Holder) convertView.getTag();
       }

        String header=city.getFirsrLetter();
        if(city.isHot())header=context.getString(R.string.hot_city);

        MyLog.print(TAG,"pos:"+position);
        if(hashMap.containsValue(position)){
            holder.txt1.setVisibility(View.VISIBLE);
            holder.txt1.setText(header);

        }else{
            holder.txt1.setVisibility(View.GONE);
        }


        holder.txt2.setText(city.getCityName());
        return convertView;
    }

    @Override
    public int getPositionForSection(int section) {
        // If there is no item for current section, previous section will be selected
        for (int i = section; i >= 0; i--) {
            for (int j = 0; j < getCount(); j++) {
                if (i == 0) {
                    // For numeric section
                    for (int k = 0; k <= 9; k++) {
                        if (StringMatcher.match(String.valueOf(getItem(j)), String.valueOf(k)))
                            return j;
                    }
                } else {
                    if (StringMatcher.match(String.valueOf(getItem(j)), String.valueOf(mSections.charAt(i))))
                        return j;
                }
            }
        }
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    @Override
    public Object[] getSections() {
        String[] sections = new String[mSections.length()];
        for (int i = 0; i < mSections.length(); i++) {
            sections[i] = String.valueOf(mSections.charAt(i));
            MyLog.print(TAG,"section:"+sections[i]);
        }

        return sections;
    }
    class Holder {

        ImageView img1;
        public TextView txt1,txt2,txt3,txt4,txt5,txt6;

    }

}
