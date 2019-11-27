package net.remenkoff.widgetsexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WidgetsActivity extends AppCompatActivity {

    // MARK: - Private Instance Properties
    private WidgetsLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new WidgetsLayout(this);
        layout.textView.setText(getString(R.string.wa_textview_text));
        layout.toggleButton.setTextOn(getString(R.string.wa_toggle_on_title));
        layout.toggleButton.setTextOff(getString(R.string.wa_toggle_off_title));
        layout.toggleButton.setChecked(true);
        layout.milkCheckbox.setText(getString(R.string.wa_checkbox_milk_text));
        layout.sugarCheckbox.setText(getString(R.string.wa_checkbox_sugar_text));
        layout.lemonCheckbox.setText(getString(R.string.wa_checkbox_lemon_text));

        setContentView(layout);
    }

}
