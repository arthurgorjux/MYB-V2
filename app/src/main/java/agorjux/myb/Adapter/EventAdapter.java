package agorjux.myb.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import agorjux.myb.R;

/**
 * Created by agorjux on 19/09/16.
 */
public class EventAdapter extends ArrayAdapter<String> {
    public EventAdapter(Context context, List<String> events) {
        super(context, 0, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_event,parent, false);
        }

        EventViewHolder viewHolder = (EventViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EventViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(viewHolder);
        }

        String event = getItem(position);
        viewHolder.title.setText(event);

        return convertView;
    }

    private class EventViewHolder{
        public TextView title;

    }
}
