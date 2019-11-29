package net.remenkoff.workout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public final class StopwatchFragment extends Fragment implements StopwatchLayout.StopwatchLayoutDelegate {

    // MARK: - Private Instance Properties
    private final String K_SECS_PASSED_KEY = "K_SECS_PASSED_KEY";
    private final String K_IS_RUNNING_KEY = "K_IS_RUNNING_KEY";
    private final String K_IS_RUNNING_NEEDED_KEY = "K_IS_RUNNING_NEEDED_KEY";
    private final int K_SECS_DEFAULT_VALUE = 0;
    private final boolean K_IS_RUNNING_DEFAULT_VALUE = false;
    private final long K_HANDLER_FREQ = 1000;

    private Handler handler;
    private StopwatchLayout layout;

    private int secondsPassed = K_SECS_DEFAULT_VALUE;
    private boolean isRunning = K_IS_RUNNING_DEFAULT_VALUE;
    private boolean isRunningNeeded = K_IS_RUNNING_DEFAULT_VALUE;

    // MARK: - Activity Lifecycle
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreInstanceState(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        setupLayout(inflater.getContext());
        runTimer();

        return layout;
    }

    private void restoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }

        secondsPassed = savedInstanceState.getInt(K_SECS_PASSED_KEY, K_SECS_DEFAULT_VALUE);
        isRunning = savedInstanceState.getBoolean(K_IS_RUNNING_KEY, false);
        isRunningNeeded = savedInstanceState.getBoolean(K_IS_RUNNING_NEEDED_KEY, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isRunningNeeded) {
            isRunning = true;
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(K_SECS_PASSED_KEY, secondsPassed);
        savedInstanceState.putBoolean(K_IS_RUNNING_KEY, isRunning);
        savedInstanceState.putBoolean(K_IS_RUNNING_NEEDED_KEY, isRunningNeeded);
    }

    @Override
    public void onPause() {
        super.onPause();
        isRunningNeeded = isRunning;
        isRunning = false;
        handler = null;
    }

    // MARK: - Private Instance Interface
    private void setupLayout(Context context) {
        layout = new StopwatchLayout(context);
        layout.delegate = this;
        layout.timerTextView.setText(convertSecondsToTimeText(secondsPassed));
        layout.startButton.setText(getString(R.string.ma_start_btn_title));
        layout.stopButton.setText(getString(R.string.ma_stop_btn_title));
        layout.resetButton.setText(getString(R.string.ma_reset_btn_title));
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
        if (handler == null) {
            handler = new Handler();
            handler.post(getRunnable());
        }
    }

    private Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    String timeText = convertSecondsToTimeText(secondsPassed);
                    layout.timerTextView.setText(timeText);
                    secondsPassed += 1;
                }

                if (handler != null) {
                    handler.postDelayed(this, K_HANDLER_FREQ);
                }
            }
        };
    }

    private void stopRunning() {
        if (isRunning && secondsPassed > 0) {
            secondsPassed -= 1;
        }
        isRunning = false;
    }

    // MARK: - MainLayoutDelegate
    @Override
    public void didTapStartButton() {
        isRunning = true;
    }

    @Override
    public void didTapStopButton() {
        stopRunning();
    }

    @Override
    public void didTapResetButton() {
        isRunning = false;
        secondsPassed = K_SECS_DEFAULT_VALUE;
        layout.timerTextView.setText(convertSecondsToTimeText(secondsPassed));
    }

}
