package net.remenkoff.mymessenger.CreateMessage;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

interface CreateMessageLayoutDelegate {
    void didTapSendButton();
}

final class CreateMessageLayout extends LinearLayout {

    // MARK: - Public Type Properties
    public static final int id = 0xCEAEEAEA;

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_INDENT= 16;

    // MARK: - Package-Private Instance Properties
    final Button sendButton;
    final EditText msgEditText;

    // MARK: - Public Instance Interface
    public CreateMessageLayoutDelegate delegate;

    // MARK: - Instantiation
    public CreateMessageLayout(Context context) {
        super(context);

        sendButton = new Button(context);
        msgEditText = new EditText(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupMessageEditText();
        setupSendButton();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        setId(CreateMessageLayout.id);

        addView(msgEditText);
        addView(sendButton);
    }

    private void setupMessageEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;

        msgEditText.setLayoutParams(params);
        msgEditText.setEms(10);
    }

    private void setupSendButton() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        params.topMargin = K_DEFAULT_INDENT;

        sendButton.setLayoutParams(params);
        sendButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { if (delegate != null) delegate.didTapSendButton(); }
        });
    }

}
