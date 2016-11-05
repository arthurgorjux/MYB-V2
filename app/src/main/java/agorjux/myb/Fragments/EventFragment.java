package agorjux.myb.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import agorjux.myb.Adapter.EventAdapter;
import agorjux.myb.R;

/**
 * Created by agorjux on 16/09/16.
 */
public class EventFragment extends Fragment {

    private ListView listView;

    public EventFragment(){

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.event_fragment, container, false);
        String[] adapterData = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        final List<String> data = Arrays.asList(adapterData);
        listView = (ListView) rootView.findViewById(R.id.listView);
        EventAdapter adapter = new  EventAdapter(getActivity().getApplicationContext(), data);
        listView.setAdapter(adapter);

       /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getActivity();
                CharSequence text = "test";
                int duration = Toast.LENGTH_LONG;
                Toast.makeText(context, text, duration).show();
            }
        });*/
        return rootView;
    }
}
