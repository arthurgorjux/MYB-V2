package agorjux.myb.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import agorjux.myb.R;

/**
 * Created by agorjux on 16/09/16.
 */
public class ListFragment extends Fragment {

    public ListFragment(){

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.configuration_fragment, container, false);
    }
}
