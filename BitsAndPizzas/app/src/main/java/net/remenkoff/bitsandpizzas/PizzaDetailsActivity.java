package net.remenkoff.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class PizzaDetailsActivity extends AppCompatActivity {

    // MARK: - AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_details);

        // Set the toolbar as the activity's app bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Display details of the pizza
        int pizzaID = getIntent().getIntExtra(Intent.EXTRA_INDEX, -1);

        if (pizzaID == -1) {
            throw new IllegalArgumentException("Integer value for EXTRA_PIZZA_ID not found!");
        }

        String pizzaName = Pizza.pizzas[pizzaID].name;
        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);

        int pizzaImageResID = Pizza.pizzas[pizzaID].imageResID;
        ImageView imageView= findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImageResID));
        imageView.setContentDescription(pizzaName);
    }

}
