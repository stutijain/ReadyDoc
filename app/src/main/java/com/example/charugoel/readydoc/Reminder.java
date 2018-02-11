package com.example.charugoel.readydoc;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Reminder extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context = this;
    PendingIntent pending_intent;

    //   private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //this.context = this;

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm_timepicker = findViewById(R.id.timePicker);
        update_text =  findViewById(R.id.update_text);

        // mTextView= findViewById(R.id.textView);

        final Calendar calendar = Calendar.getInstance();

        Button alarm_on = findViewById(R.id.alarm_on);

        final Intent my_intent=new Intent(this.context,AlarmReceiver.class);

        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(23)
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY,alarm_timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,alarm_timepicker.getCurrentMinute());

                int hour= alarm_timepicker.getCurrentHour();
                int minute=alarm_timepicker.getCurrentMinute();

                String hour_string= String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                set_alarm_set("Alarm set to:"+ hour_string+":"+minute_string);

                my_intent.putExtra("extra", "alarm on");

                pending_intent=PendingIntent.getBroadcast(Reminder.this,0,my_intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_intent);
            }

        });

        // Intent myIntent = new Intent(context, Reminder.class);
        //startActivity(myIntent);

        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_set("Alarm off");

                alarm_manager.cancel(pending_intent);

                my_intent.putExtra("extra", "alarm off");

                sendBroadcast(my_intent);
            }
        });

    }

    private void set_alarm_set(String output){

        update_text.setText(output);
    }
   /* public void onTimeSet(TimePicker view,int hourOfDay,int minute){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hour: "+ hourOfDay+"Minute: "+minute);
        Calendar c= Calendar.getInstance();

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c){
        String timeText="Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        mTextView.setText(timeText);
    }
    private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this,AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1,intent,0);

        alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
    }

   private void cancelAlarm(){
       AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
       Intent intent = new Intent(this,AlertReceiver.class);
       PendingIntent pendingIntent = PendingIntent.getBroadcast(this,1,intent,0);

       alarmManager.cancel(pendingIntent);
       mTextView.setText("Alarm cancelled");
   }*/

}