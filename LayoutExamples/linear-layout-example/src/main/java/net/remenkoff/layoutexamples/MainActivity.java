package net.remenkoff.layoutexamples;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public final class MainActivity extends Activity {

    // MARK: - Private Instance Properties
    MainLayout layout;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new MainLayout(this);
        setContentView(layout);

        layout.toEditText.setHint(getString(R.string.ma_to_hint));
        layout.msgEditText.setHint(getString(R.string.ma_msg_hint));
        layout.sendButton.setHint(getString(R.string.ma_send_btn_title));
    }

}
