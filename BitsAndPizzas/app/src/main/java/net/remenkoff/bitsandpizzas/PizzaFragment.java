package net.remenkoff.bitsandpizzas;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzaFragment extends Fragment implements CaptionedImagesAdapter.Listener {

    // MARK: - Fragment Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pizza, container, false);

        String[] pizzasCaptions = new String[Pizza.pizzas.length];
        for (int index = 0; index < pizzasCaptions.length; index++) {
            pizzasCaptions[index] = Pizza.pizzas[index].name;
        }

        int[] pizzasImagesIDs = new int[Pizza.pizzas.length];
        for (int index = 0; index < pizzasImagesIDs.length; index++) {
            pizzasImagesIDs[index] = Pizza.pizzas[index].imageResID;
        }

        CaptionedImagesAdapter ciAdapter = new CaptionedImagesAdapter(pizzasCaptions, pizzasImagesIDs);
        ciAdapter.setListener(this);
        pizzaRecycler.setAdapter(ciAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(gridLayoutManager);

        return pizzaRecycler;
    }

    // MARK: - CaptionedImagesAdapter.Listener
    @Override
    public void onClick(int index) {
        FragmentActivity fragmentActivity = getActivity();

        if (fragmentActivity == null) {
            return;
        }

        Intent intent = new Intent(fragmentActivity, PizzaDetailsActivity.class);
        intent.putExtra(Intent.EXTRA_INDEX, index);
        fragmentActivity.startActivity(intent);
    }

}
