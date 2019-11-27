package net.remenkoff.constraintlayoutexample;

import android.content.Context;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.concurrent.ThreadLocalRandom;

final class MainLayout extends ConstraintLayout {

    // MARK: - Private Instance Properties
    private final int K_DFLT_PADDING = 16;

    // MARK: - Public Instance Properties
    public TextView toTextView;
    public EditText emailEditText;
    public EditText sbjEditText;
    public EditText msgEditText;
    public Button sendButton;

    // MARK: - Instantiation
    public MainLayout(Context context) {
        super(context);

        toTextView = new TextView(context);
        emailEditText = new EditText(context);
        sbjEditText = new EditText(context);
        msgEditText = new EditText(context);
        sendButton = new Button(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupToTextView();
        setupEmailEditText();
        setupSubjectEditText();
        setupSendButton();
        setupMessageEditText();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setPadding(K_DFLT_PADDING, K_DFLT_PADDING, K_DFLT_PADDING, K_DFLT_PADDING);
        setId(getRandomAbsInt());

        addView(toTextView);
        addView(emailEditText);
        addView(sbjEditText);
        addView(msgEditText);
        addView(sendButton);
    }

    private void setupToTextView() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftToLeft = getId();
        params.topToTop = getId();
        toTextView.setLayoutParams(params);
        toTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        toTextView.setId(getRandomAbsInt());
    }

    private void setupEmailEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftToRight = toTextView.getId();
        params.rightToRight = getId();
        params.topToTop = getId();
        params.baselineToBaseline = toTextView.getId();
        params.leftMargin = K_DFLT_PADDING;
        params.width = 0;
        emailEditText.setLayoutParams(params);
        emailEditText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        emailEditText.setId(getRandomAbsInt());
    }

    private void setupSubjectEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.leftToLeft = getId();
        params.rightToRight = getId();
        params.topToBottom = emailEditText.getId();
        params.width = 0;
        sbjEditText.setLayoutParams(params);
        sbjEditText.setEms(10);
        sbjEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        sbjEditText.setId(getRandomAbsInt());
    }

    private void setupMessageEditText() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_CONSTRAINT, LayoutParams.MATCH_CONSTRAINT);
        params.leftToLeft = getId();
        params.rightToRight = getId();
        params.topToBottom = sbjEditText.getId();
        params.bottomToTop = sendButton.getId();
        msgEditText.setLayoutParams(params);
        msgEditText.setEms(10);
        msgEditText.setGravity(Gravity.TOP);
        msgEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        msgEditText.setId(getRandomAbsInt());
    }

    private void setupSendButton() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.leftToLeft = getId();
        params.rightToRight = getId();
        params.bottomToBottom = getId();
        sendButton.setLayoutParams(params);
        sendButton.setId(getRandomAbsInt());
    }

    private int getRandomAbsInt() {
        return ThreadLocalRandom.current().nextInt(0, 2147483647);
    }

}
