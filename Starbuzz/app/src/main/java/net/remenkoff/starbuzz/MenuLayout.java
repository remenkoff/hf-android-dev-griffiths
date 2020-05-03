package net.remenkoff.starbuzz;

import android.content.Context;
import android.os.Build;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

final class MenuLayout extends LinearLayout {

    // MARK: - Private Instance Properties
    private final int K_DEFAULT_PADDING = 16;

    // MARK: - Public Instance Properties
    final ImageView logoImageView;
    final ListView menuListView;
    final TextView favoritesTextView;
    final ListView favoritesListView;

    // MARK: - Instantiation
    public MenuLayout(Context context) {
        super(context);

        logoImageView = new ImageView(context);
        menuListView = new ListView(context);
        favoritesTextView = new TextView(context);
        favoritesListView = new ListView(context);

        configureLayout();
    }

    // MARK: - Private Instance Interface
    private void configureLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(params);
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        setPadding(K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING, K_DEFAULT_PADDING);

        addView(configuredLogoImageView());
        addView(configuredMenuListView());
        addView(configuredFavoritesTextView());
        addView(configuredFavoritesListView());
    }

    private ImageView configuredLogoImageView() {
        LayoutParams params = new LayoutParams(200, 100);
        logoImageView.setLayoutParams(params);
        return logoImageView;
    }

    private ListView configuredMenuListView() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        menuListView.setLayoutParams(params);
        return menuListView;
    }

    private TextView configuredFavoritesTextView() {
        favoritesTextView.setText(getResources().getText(R.string.favorites));
        favoritesTextView.setTextAppearance(android.R.style.TextAppearance_Large);
        return favoritesTextView;
    }

    private ListView configuredFavoritesListView() {
        favoritesListView.setId(getResources().getIdentifier("list_favs", null, null));
        return favoritesListView;
    }
}
