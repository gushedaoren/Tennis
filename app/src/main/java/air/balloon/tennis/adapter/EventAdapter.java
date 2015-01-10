package air.balloon.tennis.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import air.balloon.tennis.app.R;
import air.balloon.tennis.model.Event;

/**
 * Created by oliver on 5/8/14.
 */
public class EventAdapter extends BaseAdapter {
    List<Event> events;
    Context context;

    public EventAdapter(Context context,List<Event> events) {
        this.events = events;
        this.context = context;
    }




    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return events.get(position).getId();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event=events.get(position);
        Holder holder=new Holder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.event_list_item,null);
            holder.txt1= (android.widget.TextView) convertView.findViewById(R.id.txt1);
            holder.txt2= (android.widget.TextView) convertView.findViewById(R.id.txt2);
            holder.txt3= (android.widget.TextView) convertView.findViewById(R.id.txt3);
            holder.txt4= (android.widget.TextView) convertView.findViewById(R.id.txt4);
            holder.txt5= (android.widget.TextView) convertView.findViewById(R.id.txt5);
            holder.txt6= (android.widget.TextView) convertView.findViewById(R.id.txt6);
            convertView.setTag(holder);

        }else{
           holder= (Holder) convertView.getTag();
        }
        holder.txt1.setText(event.getTitle());
        holder.txt2.setText(event.getAddress());
//        holder.txt3.setText(event.getEventTime());
//        holder.txt4.setText(event.getTotolPrice()+"");
//        holder.txt5.setText(event.getRequire());
//        holder.txt6.setText(event.getParticipant_TennisUser_List()+"");


        return convertView;
    }





   class Holder {


        public TextView txt1,txt2,txt3,txt4,txt5,txt6;

    }
}
