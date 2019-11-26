package net.remenkoff.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import java.util.Locale;

public final class MainActivity extends Activity implements MainLayoutDelegate {

    // MARK: - Private Instance Properties
    private final String K_RESET_TIMER_VALUE = "0:00:00";
    private final long K_HANDLER_FREQ = 1000;

    private int secs = 0;
    private boolean isRunning = false;

    private MainLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        runTimer();
    }

    private void setupLayout() {
        layout = new MainLayout(this);
        layout.delegate = this;
        layout.timerTextView.setText(K_RESET_TIMER_VALUE);
        layout.startButton.setText(getString(R.string.ma_start_btn_title));
        layout.stopButton.setText(getString(R.string.ma_stop_btn_title));
        layout.resetButton.setText(getString(R.string.ma_reset_btn_title));

        setContentView(layout);
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    int hours = secs / 3600;
                    int minutes = (secs % 3600) / 60;
                    int seconds = secs % 60;

                    String timeText = String.format(Locale.getDefault(),
                                                    "%d:%02d:%02d",
                                                    hours,
                                                    minutes,
                                                    seconds);

                    layout.timerTextView.setText(timeText);

                    secs += 1;
                }

                handler.postDelayed(this, K_HANDLER_FREQ);
            }
        });
    }

    // MARK: - MainLayoutDelegate
    @Override
    public void didTapStartButton() {
        isRunning = true;
    }

    @Override
    public void didTapStopButton() {
        isRunning = false;
    }

    @Override
    public void didTapResetButton() {
        isRunning = false;
        secs = 0;
        layout.timerTextView.setText(K_RESET_TIMER_VALUE);
    }

}
