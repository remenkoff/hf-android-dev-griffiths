package net.remenkoff.layoutexamples;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

final class MainLayout extends LinearLayout {

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;

    // MARK: - Public Instance Properties
    public EditText toEditText;
    public EditText msgEditText;
    public Button sendButton;

    // MARK: - Instantiation
    public MainLayout(Context context) {
        super(context);

        toEditText = new EditText(context);
        msgEditText = new EditText(context);
        sendButton = new Button(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupToEditText();
        setupMessageEditText();
        setupSendButton();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(toEditText);
        addView(msgEditText);
        addView(sendButton);
    }

    private void setupToEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        toEditText.setLayoutParams(params);
    }

    private void setupMessageEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 0);
        params.weight = 1;
        msgEditText.setLayoutParams(params);
        msgEditText.setGravity(Gravity.TOP);
    }

    private void setupSendButton() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        params.gravity = Gravity.END;
        sendButton.setLayoutParams(params);
    }

}
