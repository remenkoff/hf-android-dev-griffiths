package net.remenkoff.workout;

import androidx.fragment.app.ListFragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment extends ListFragment {

    // MARK: - Package-Private Type Properties
    static interface Listener {
        void didSelectItem(long index);
    }

    // MARK: - Private Instance Properties
    private Listener listener;

    // MARK: - Fragment Lifecycle
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setupAdapter(inflater.getContext());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.didSelectItem(id);
        }
    }

    // MARK: - Private Instance Interface
    private void setupAdapter(Context context) {
        String[] objects = new String[Workout.workouts.length];

        for (int index = 0; index < objects.length; index++) {
            objects[index] = Workout.workouts[index].name;
        }

        setListAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, objects));
    }

}
