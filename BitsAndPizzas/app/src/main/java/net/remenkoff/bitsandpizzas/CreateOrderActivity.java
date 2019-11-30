package net.remenkoff.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class CreateOrderActivity extends AppCompatActivity {

    // MARK: - Private Instance Proeprties
    Snackbar snackbar;

    // MARK: - Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupInitialState();
    }

    // MARK: - Private Instance Interface
    private void setupInitialState() {
        setContentView(R.layout.activity_create_order);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        snackbar = Snackbar.make(
                findViewById(R.id.coordinator),
                R.string.hello_me,
                Snackbar.LENGTH_SHORT
        );
        snackbar.setAction(R.string.undo, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(
                        CreateOrderActivity.this,
                        "Undone!",
                        Toast.LENGTH_SHORT
                );
                toast.show();
            }
        });
    }

    // MARK: - Public Instance Interface
    public void didTapFAB(View view) {
        snackbar.show();
    }

}
