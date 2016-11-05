package agorjux.myb.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import agorjux.myb.R;

/**
 * Created by agorjux on 06/10/16.
 */
public class CreateEventFragment extends Fragment {

    private Button btn;
    public static EditText titleEvent, dateEvent, timeEvent, descriptionEvent;
    private TextInputLayout layoutTitleEvent, layoutDescriptionEvent, layoutDateEvent, layoutTimeEvent;

    public LinearLayout layout;

    public CreateEventFragment(){

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.event_form, container, false);

        btn = (Button) rootView.findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        titleEvent = (EditText) rootView.findViewById(R.id.input_title);
        layoutTitleEvent = (TextInputLayout) rootView.findViewById(R.id.input_layout_title);

        descriptionEvent = (EditText) rootView.findViewById(R.id.input_description);
        layoutDescriptionEvent = (TextInputLayout) rootView.findViewById(R.id.input_layout_description);

        dateEvent = (EditText) rootView.findViewById(R.id.input_date);
        layoutDateEvent = (TextInputLayout) rootView.findViewById(R.id.input_layout_date);

        timeEvent = (EditText) rootView.findViewById(R.id.input_time);
        layoutTimeEvent = (TextInputLayout) rootView.findViewById(R.id.input_layout_time);

        dateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker(view);
            }
        });

        timeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker(view);
            }
        });

        layout = (LinearLayout) rootView.findViewById(R.id.layout_form);
        return rootView;
    }

    public void showDatePicker(View v){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getActivity().getFragmentManager(), new String("datePicker"));
    }

    public void showTimePicker(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getActivity().getFragmentManager(), new String("timePicker"));
    }

    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if(!validateDescription()){
            return;
        }

        if(!validateDate()){
            return;
        }

        if(!validateTime()){
            return;
        }

        //Toast.makeText(getContext(), "Evénement créé avec succès !", Toast.LENGTH_SHORT).show();
        Snackbar snackbar = Snackbar.make(layout, "Evénement créé avec succès !", Snackbar.LENGTH_LONG);
        snackbar.show();

    }

    private boolean validateDate(){
        if (dateEvent.getText().toString().trim().isEmpty()) {
            layoutDateEvent.setError(getString(R.string.error_date_event));
            requestFocus(dateEvent);
            return false;
        } else {
            layoutDateEvent.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateTime(){
        if (timeEvent.getText().toString().trim().isEmpty()) {
            layoutTimeEvent.setError(getString(R.string.error_time_event));
            requestFocus(timeEvent);
            return false;
        } else {
            layoutTimeEvent.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateName() {
        if (titleEvent.getText().toString().trim().isEmpty()) {
            layoutTitleEvent.setError(getString(R.string.error_title_event));
            requestFocus(titleEvent);
            return false;
        } else {
            layoutTitleEvent.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDescription() {
        if (descriptionEvent.getText().toString().trim().isEmpty()) {
            layoutDescriptionEvent.setError(getString(R.string.error_description_event));
            requestFocus(descriptionEvent);
            return false;
        } else {
            layoutDescriptionEvent.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar c = Calendar.getInstance();
            c.set(year, month, day);

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(c.getTime());
            dateEvent.setText(formattedDate);
        }
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, hourOfDay);
            c.set(Calendar.MINUTE, minute);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String formattedTime = sdf.format(c.getTime());
            timeEvent.setText(formattedTime);
        }
    }
}
