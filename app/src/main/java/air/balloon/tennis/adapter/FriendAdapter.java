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

import air.balloon.tennis.model.TennisUser;

/**
 * Created by oliver on 5/12/14.
 */
public class FriendAdapter extends BaseAdapter {

    Context context;
    List<TennisUser> users;

    public FriendAdapter(Context context, List<TennisUser> users) {
        this.context = context;
        this.users=users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }
    Holder holder=new Holder();
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TennisUser user=users.get(position);

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.friend_list_item,null);
            holder.img1= (ImageView) convertView.findViewById(R.id.img);

            holder.txt1= (TextView) convertView.findViewById(R.id.txt1);
            holder.txt2= (TextView) convertView.findViewById(R.id.txt2);
//            holder.txt3= (TextView) convertView.findViewById(R.id.txt3);
//            holder.txt4= (TextView) convertView.findViewById(R.id.txt4);
//            holder.txt5= (TextView) convertView.findViewById(R.id.txt5);
//            holder.txt6= (TextView) convertView.findViewById(R.id.txt6);

            convertView.setTag(holder);

        }else{
           holder= (Holder) convertView.getTag();
        }

        holder.txt1.setText(user.getName());
        holder.txt2.setText(user.getGender_BaseEnum_Model().getEnumDesc());

        return convertView;
    }

    class Holder {

        ImageView img1;
        public TextView txt1,txt2,txt3,txt4,txt5,txt6;

    }
}
