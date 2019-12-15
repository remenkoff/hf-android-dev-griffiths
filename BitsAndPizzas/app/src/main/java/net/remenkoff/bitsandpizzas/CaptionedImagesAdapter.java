package net.remenkoff.bitsandpizzas;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

final class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>
    implements View.OnClickListener {

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    // MARK: - Private Instance Properties
    private String[] captions;
    private int[] imagesIDs;
    private Listener listener;

    interface Listener {
        void onClick(int index);
    }

    // MARK: - Instantiation
    public CaptionedImagesAdapter(String[] captions, int[] imagesIDs) {
        this.captions = captions;
        this.imagesIDs = imagesIDs;
    }

    // MARK: - Public Instance Interface
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // MARK: - RecyclerView.Adapter
    @Override
    public int getItemCount() {
        return captions.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(cardView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        cardView.setOnClickListener(this);

        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imagesIDs[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);
    }

    public void onClick(View view) {
        if (listener == null) {
            return;
        }

        int index = ((ViewGroup) view.getParent()).indexOfChild(view);
        listener.onClick(index);
    }

}
