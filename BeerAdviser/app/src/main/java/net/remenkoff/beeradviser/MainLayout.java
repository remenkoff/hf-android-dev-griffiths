package net.remenkoff.beeradviser;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

interface MainLayoutDelegate {
    void onClickSearchButton();
}

public final class MainLayout extends LinearLayout {

    // MARK: - Public Type Properties
    public static final int id = 0xDAA0;

    // MARK: - Private Instance Properties
    private static final int K_DEFAULT_INDENT= 16;
    private static final int K_SPINNER_TOP_MARGIN = 40;

    // MARK: - Public Instance Interface
    public MainLayoutDelegate delegate;

    public final Spinner beerTypeSpinner;
    public final Button searchButton;
    public final TextView searchResultsTextView;

    // MARK: - Instantiation
    public MainLayout(Context context) {
        super(context);

        beerTypeSpinner = new Spinner(context);
        searchButton = new Button(context);
        searchResultsTextView = new TextView(context);

        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setupLayout();
        setupBeerTypeSpinner();
        setupSearchButton();
        setupSearchResultsTextView();
    }

    private void setupLayout() {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        setOrientation(VERTICAL);
        setPadding(K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        setId(MainLayout.id);
    }

    private void setupBeerTypeSpinner() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(K_DEFAULT_INDENT, K_SPINNER_TOP_MARGIN, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        params.gravity = Gravity.CENTER;
        beerTypeSpinner.setLayoutParams(params);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                getContext(),
                R.array.main_beer_colors,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        beerTypeSpinner.setAdapter(adapter);

        addView(beerTypeSpinner);
    }

    private void setupSearchButton() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        params.gravity = Gravity.CENTER;

        searchButton.setLayoutParams(params);
        searchButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) { if (delegate != null) delegate.onClickSearchButton(); }
        });

        addView(searchButton);
    }

    private void setupSearchResultsTextView() {
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT, K_DEFAULT_INDENT);
        params.gravity = Gravity.CENTER;

        searchResultsTextView.setLayoutParams(params);

        addView(searchResultsTextView);
    }

}
