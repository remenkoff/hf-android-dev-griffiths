package net.remenkoff.beeradviser;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

final public class MainActivity extends AppCompatActivity implements MainLayoutDelegate {

    // MARK: - Private Instance Properties
    MainLayout layout;
    BeerExpert expert = new BeerExpert();

    // MARK: - View Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        layout = new MainLayout(this);
        layout.delegate = this;
        layout.searchButton.setText(getString(R.string.main_activity_search_button_title));
        layout.searchResultsTextView.setText(getString(R.string.main_activity_search_results_text));

        setContentView(layout);
    }

    // MARK: - MainLayoutDelegate
    @Override
    public void onClickSearchButton() {
        String selectedValue = String.valueOf(layout.beerTypeSpinner.getSelectedItem());
        List<String> brands = expert.getBrands(selectedValue);
        layout.searchResultsTextView.setText(TextUtils.join("\n", brands));
    }

}
