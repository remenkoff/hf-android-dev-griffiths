package net.remenkoff.widgetsexample;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

final class WidgetsLayout extends LinearLayout {

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;
    private final LayoutParams wrapContentLayoutParams =
            new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    // MARK: - Public Instance Properties
    public TextView textView;
    public ToggleButton toggleButton;
    public CheckBox milkCheckbox;
    public CheckBox sugarCheckbox;
    public CheckBox lemonCheckbox;

    // MARK: - Instantiation
    public WidgetsLayout(Context context) {
        super(context);

        textView = new TextView(context);
        toggleButton = new ToggleButton(context);
        milkCheckbox = new CheckBox(context);
        sugarCheckbox = new CheckBox(context);
        lemonCheckbox = new CheckBox(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupTextView();
        setupToggleButton();
        setupCheckboxes();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(textView);
        addView(toggleButton);
        addView(milkCheckbox);
        addView(sugarCheckbox);
        addView(lemonCheckbox);
    }

    private void setupTextView() {
        textView.setLayoutParams(wrapContentLayoutParams);
    }

    private void setupToggleButton() {
        toggleButton.setLayoutParams(wrapContentLayoutParams);
    }

    private void setupCheckboxes() {
        milkCheckbox.setLayoutParams(wrapContentLayoutParams);
        sugarCheckbox.setLayoutParams(wrapContentLayoutParams);
        lemonCheckbox.setLayoutParams(wrapContentLayoutParams);
    }

}
