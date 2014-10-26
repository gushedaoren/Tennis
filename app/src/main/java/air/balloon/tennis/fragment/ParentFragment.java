package air.balloon.tennis.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;


/**
 * Created by oliver on 5/9/14.
 */
public class ParentFragment extends Fragment {

    public String TAG=getClass().getSimpleName();
    SharedPreferences sp;

    int cityid=73;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getActivity().getSharedPreferences("sp", Context.MODE_PRIVATE);

    }
}
