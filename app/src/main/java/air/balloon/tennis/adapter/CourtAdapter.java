package air.balloon.tennis.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import air.balloon.tennis.app.R;
import air.balloon.tennis.model.Court;

/**
 * Created by oliver on 5/12/14.
 */
public class CourtAdapter extends BaseAdapter {

    Context context;
    List<Court> courts;

    public CourtAdapter(Context context, List<Court> courts) {
        this.context = context;
        this.courts = courts;
    }

    @Override
    public int getCount() {
        return courts.size();
    }

    @Override
    public Object getItem(int position) {
        return courts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return courts.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Court court=courts.get(position);
        Holder holder=new Holder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.court_list_item,null);
            holder.img1= (ImageView) convertView.findViewById(R.id.img);

            holder.txt1= (android.widget.TextView) convertView.findViewById(R.id.txt1);
            holder.txt2= (android.widget.TextView) convertView.findViewById(R.id.txt2);
            holder.txt3= (android.widget.TextView) convertView.findViewById(R.id.txt3);

        }

        holder.txt1.setText(court.getTitle());
        holder.txt2.setText(court.getCourtDesc());
        holder.txt3.setText(court.getFee());
        return convertView;
    }

    class Holder {

        ImageView img1;
        public TextView txt1,txt2,txt3,txt4,txt5,txt6;

    }
}
