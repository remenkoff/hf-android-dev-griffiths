package net.remenkoff.starbuzz;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

final class DrinkDetailsLayout extends LinearLayout implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        assert delegate != null;
        delegate.onFavoriteClick();
    }

    interface Delegate {
        void onFavoriteClick();
    }

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;

    // MARK: - Public Instance Properties
    @Nullable
    public Delegate delegate;

    public final ImageView drinkImageView;
    public final TextView nameTextView;
    public final TextView descTextView;
    public final CheckBox favoriteCheckBox;

    // MARK: - Instantiation
    public DrinkDetailsLayout(Context context) {
        super(context);

        drinkImageView = new ImageView(context);
        nameTextView = new TextView(context);
        descTextView = new TextView(context);
        favoriteCheckBox = new CheckBox(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupDrinkImageView();
        setupNameTextView();
        setupDescriptionTextView();
        setupFavoriteCheckBox();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(drinkImageView);
        addView(nameTextView);
        addView(descTextView);
        addView(favoriteCheckBox);
    }

    private void setupDrinkImageView() {

    }

    private void setupNameTextView() {

    }

    private void setupDescriptionTextView() {

    }

    private void setupFavoriteCheckBox() {
        favoriteCheckBox.setText(getResources().getText(R.string.favorite));
        favoriteCheckBox.setOnClickListener(this);
    }
}
