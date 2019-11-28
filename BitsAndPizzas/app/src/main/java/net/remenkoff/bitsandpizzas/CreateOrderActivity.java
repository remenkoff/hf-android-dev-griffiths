package net.remenkoff.bitsandpizzas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;

public class CreateOrderActivity extends AppCompatActivity {

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


    }

}
