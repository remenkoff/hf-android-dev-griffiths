package net.remenkoff.constraintlayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // MARK: - Private Instance Properties
    private MainLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new MainLayout(this);
        layout.toTextView.setText(getString(R.string.ma_to_hint));
        layout.emailEditText.setHint(getString(R.string.ma_email_hint));
        layout.sbjEditText.setHint(getString(R.string.ma_sbj_hint));
        layout.msgEditText.setHint(getString(R.string.ma_msg_hint));
        layout.sendButton.setText(getString(R.string.ma_btn_title));

        setContentView(layout);
    }

}
