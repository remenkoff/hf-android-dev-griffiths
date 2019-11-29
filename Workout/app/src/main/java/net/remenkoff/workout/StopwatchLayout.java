package net.remenkoff.workout;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

final class StopwatchLayout extends LinearLayout {

    // MARK: - Public Type Properties
    public interface StopwatchLayoutDelegate {
        void didTapStartButton();
        void didTapStopButton();
        void didTapResetButton();
    }

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;
    private final int K_STOP_BTN_TOP_MARGIN = 20;
    private final int K_DEFAULT_TOP_MARGIN = 8;

    // MARK: - Public Instance Properties
    StopwatchLayoutDelegate delegate;

    public final TextView timerTextView;
    public final Button startButton;
    public final Button stopButton;
    public final Button resetButton;

    // MARK: - Instantiation
    public StopwatchLayout(Context context) {
        super(context);

        timerTextView = new TextView(context);
        startButton = new Button(context);
        stopButton = new Button(context);
        resetButton = new Button(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupTimerTextView();
        setupStartButton();
        setupStopButton();
        setupResetButton();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(timerTextView);
        addView(startButton);
        addView(stopButton);
        addView(resetButton);
    }

    private void setupTimerTextView() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;

        timerTextView.setLayoutParams(params);
        timerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 56);
    }

    private void setupStartButton() {
        LayoutParams params = defaultButtonsLayoutParams();
        params.topMargin = K_STOP_BTN_TOP_MARGIN;
        startButton.setLayoutParams(params);
        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.didTapStartButton();
                }
            }
        });
    }

    private void setupStopButton() {
        stopButton.setLayoutParams(defaultButtonsLayoutParams());
        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.didTapStopButton();
                }
            }
        });
    }

    private void setupResetButton() {
        resetButton.setLayoutParams(defaultButtonsLayoutParams());
        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (delegate != null) {
                    delegate.didTapResetButton();
                }
            }
        });
    }

    private LayoutParams defaultButtonsLayoutParams() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = K_DEFAULT_TOP_MARGIN;

        return params;
    }

}
