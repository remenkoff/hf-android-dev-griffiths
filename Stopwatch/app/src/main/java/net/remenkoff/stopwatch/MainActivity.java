package net.remenkoff.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import java.util.Locale;

public final class MainActivity extends Activity implements MainLayoutDelegate {

    // MARK: - Private Instance Properties
    private final String K_SECS_PASSED_KEY = "K_SECS_PASSED_KEY";
    private final String K_IS_RUNNING_KEY = "K_IS_RUNNING_KEY";
    private final long K_HANDLER_FREQ = 1000;
    private final int K_SECS_DEFAULT_VALUE = 0;
    private final boolean K_IS_RUNNING_DEFAULT_VALUE = false;

    private int secondsPassed = K_SECS_DEFAULT_VALUE;
    private boolean isRunning = K_IS_RUNNING_DEFAULT_VALUE;

    private MainLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreInstanceState(savedInstanceState);
        setupInitialState();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(K_SECS_PASSED_KEY, secondsPassed);
        savedInstanceState.putBoolean(K_IS_RUNNING_KEY, isRunning);
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }

        secondsPassed = savedInstanceState.getInt(K_SECS_PASSED_KEY, K_SECS_DEFAULT_VALUE);
        isRunning = savedInstanceState.getBoolean(K_IS_RUNNING_KEY, false);
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        runTimer();
    }

    private void setupLayout() {
        layout = new MainLayout(this);
        layout.delegate = this;
        layout.timerTextView.setText(convertSecondsToTimeText(secondsPassed));
        layout.startButton.setText(getString(R.string.ma_start_btn_title));
        layout.stopButton.setText(getString(R.string.ma_stop_btn_title));
        layout.resetButton.setText(getString(R.string.ma_reset_btn_title));

        setContentView(layout);
    }

    private String convertSecondsToTimeText(int secs) {
        final int K_SECS_IN_HOUR = 3600;
        final int K_SECS_IN_MIN = 60;

        int hours = secs / K_SECS_IN_HOUR;
        int minutes = (secs % K_SECS_IN_HOUR) / K_SECS_IN_MIN;
        int seconds = secs % K_SECS_IN_MIN;

        return String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds);
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    String timeText = convertSecondsToTimeText(secondsPassed);
                    layout.timerTextView.setText(timeText);
                    secondsPassed += 1;
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
        if (isRunning && secondsPassed > 0) {
            secondsPassed -= 1;
        }
        isRunning = false;
    }

    @Override
    public void didTapResetButton() {
        isRunning = false;
        secondsPassed = K_SECS_DEFAULT_VALUE;
        layout.timerTextView.setText(convertSecondsToTimeText(secondsPassed));
    }

}
