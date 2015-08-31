package com.example.duy.timerbeta;

import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.CountDownTimer;
import android.app.Activity;
import android.widget.Button;
import android.os.Vibrator;


public class MainActivity extends Activity {

    CountDownTimer timerPlay;
    CountDownTimer timerWork;
    boolean on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);

        final TextView work = (TextView) findViewById(R.id.textView4);
        final TextView play = (TextView) findViewById(R.id.textView);

        work.setText("Work Time");
        play.setText("Play Time");

        final Button w10 = (Button) findViewById(R.id.button);
        w10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("10");

            }
        });

        final Button w20 = (Button) findViewById(R.id.button2);
        w20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("20");
            }
        });

        final Button w30 = (Button) findViewById(R.id.button3);
        w30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("30");
            }
        });

        final Button w60 = (Button) findViewById(R.id.button4);
        w60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("60");
            }
        });

        final Button w90 = (Button) findViewById(R.id.button5);
        w90.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("90");
            }
        });

        final Button w120 = (Button) findViewById(R.id.button6);
        w120.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                work.setText("120");
            }
        });

        final Button p1 = (Button) findViewById(R.id.button7);
        p1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("1");
            }
        });

        final Button p5 = (Button) findViewById(R.id.button8);
        p5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("5");
            }
        });

        final Button p10 = (Button) findViewById(R.id.button9);
        p10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("10");
            }
        });

        final Button p20 = (Button) findViewById(R.id.button10);
        p20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("20");
            }
        });

        final Button p30 = (Button) findViewById(R.id.button11);
        p30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("30");
            }
        });

        final Button p60 = (Button) findViewById(R.id.button12);
        p60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                play.setText("60");
            }
        });

        toggle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Integer workTime;
                Integer playTime;

                try {

                    workTime = (Integer.parseInt(work.getText().toString()))*60*1000;

                } catch (NumberFormatException nfe) {

                    workTime = 0;

                }


                try {

                    playTime = Integer.parseInt(play.getText().toString())*60*1000;

                } catch (NumberFormatException nfe) {

                    playTime = 0;

                }

                on = ((ToggleButton) view).isChecked();

                timerPlay = new CountDownTimer(playTime, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (on) {

                            long hours = millisUntilFinished/3600000;
                            long minutes = (millisUntilFinished - (hours*3600000))/60000;
                            long seconds = millisUntilFinished - (hours*3600000) - (minutes*60000);

                            play.setText("Time left: " +  hours + ":" + minutes + ":" + seconds/1000);

                        } else {

                            cancel();

                        }
                    }

                    @Override
                    public void onFinish() {

                        play.setText("Get back to work!");
                        v.vibrate(1000);
                        timerWork.start();

                    }
                };


                timerWork = new CountDownTimer(workTime, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        if (on) {

                            long hours = millisUntilFinished/3600000;
                            long minutes = (millisUntilFinished - (hours*3600000))/60000;
                            long seconds = millisUntilFinished - (hours*3600000) - (minutes*60000);

                            work.setText("Time left: " +  hours + ":" + minutes + ":" + seconds/1000);

                        } else {

                            cancel();

                        }
                    }

                    @Override
                    public void onFinish() {

                        work.setText("It's Play Time!");
                        v.vibrate(1000);
                        timerPlay.start();


                    }

                };

                if (workTime == 0 || playTime == 0){

                    work.setText("Select a work time:");
                    play.setText("Select a play time:");

                } else if(on){

                    timerWork.start();


                }else {

                    work.setText("Select a work time:");
                    play.setText("Select a play time:");
                    timerWork.cancel();
                    timerPlay.cancel();

                };

            };


        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
