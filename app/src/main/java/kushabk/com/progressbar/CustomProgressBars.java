package kushabk.com.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class CustomProgressBars extends AppCompatActivity {

    protected static final int MYTIMER = 3000;
    protected boolean mbActive;
    private ProgressBar pr1;

    private ProgressBar pr4;
    private ProgressBar pr5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_progress_bars);

       pr1 = (ProgressBar)findViewById(R.id.progressBar);

        pr5 = (ProgressBar)findViewById(R.id.kcircle);
        pr4 = (ProgressBar)findViewById(R.id.kucircle);





        Thread timerThread = new Thread() {
            public void run() {

                mbActive = true;
                try {
                    int waited = 0;

                    while (mbActive && (waited < MYTIMER)) {
                        sleep(3000);
                        if (mbActive) {
                            waited += 100;
                            updateProgress(waited);

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    onContinue();

                }
            }
        };
        timerThread.start();


    }

    public void updateProgress(final int timePassed) {
        if(null != pr1) {

            final int progress = pr1.getMax() * timePassed / MYTIMER;
            pr1.setProgress(progress);
        }


        if(null != pr5) {

            final int progress = pr5.getMax() * timePassed / MYTIMER;
            pr5.setProgress(progress);
        }


        if(null != pr4) {

            final int progress = pr4.getMax() * timePassed / MYTIMER;
            pr4.setProgress(progress);
        }






    }
    public void onContinue() {
        // perform any final actions here

    }


}
