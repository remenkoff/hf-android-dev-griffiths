package net.remenkoff.bitsandpizzas;

import androidx.fragment.app.ListFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PastaListFragment extends ListFragment {

    // MARK: - Fragment Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupAdapter(inflater.getContext());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // MARK: - Private Instance Interface
    private void setupAdapter(Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.pasta)
        );
        setListAdapter(adapter);
    }

}
