package net.remenkoff.duck;

import android.content.Context;
import android.icu.util.MeasureUnit;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

final class DuckLayout extends FrameLayout {

    // MARK: - Instance Interface
    private final int K_DEFAULT_PADDING = 16;

    public ImageView imageView;

    private LinearLayout labelLinearLayout;
    public TextView titleTextView;
    public TextView subtitleTextView;

    // MARK: - Instantiation
    public DuckLayout(Context context) {
        super(context);

        imageView = new ImageView(context);
        labelLinearLayout = new LinearLayout(context);
        titleTextView = new TextView(context);
        subtitleTextView = new TextView(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupImageView();

        setupLabelLinearLayout();
        setupTitleTextView();
        setupSubtitleTextView();
    }

    private void setupLayout() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        setLayoutParams(params);

        addView(imageView);
        addView(labelLinearLayout);
    }

    private void setupImageView() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void setupLabelLinearLayout() {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.CENTER_VERTICAL | Gravity.END;
        labelLinearLayout.setLayoutParams(params);
        labelLinearLayout.setOrientation(LinearLayout.VERTICAL);
        labelLinearLayout.setGravity(Gravity.END);
        labelLinearLayout.setPadding(
                K_DEFAULT_PADDING,
                K_DEFAULT_PADDING,
                K_DEFAULT_PADDING,
                K_DEFAULT_PADDING
        );

        labelLinearLayout.addView(titleTextView);
        labelLinearLayout.addView(subtitleTextView);
    }

    private void setupTitleTextView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        titleTextView.setLayoutParams(params);
        titleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }

    private void setupSubtitleTextView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        subtitleTextView.setLayoutParams(params);
        subtitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
    }

}
