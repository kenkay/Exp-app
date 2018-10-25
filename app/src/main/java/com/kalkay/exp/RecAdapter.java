package com.kalkay.exp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import java.io.InputStream;
import java.net.URL;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> {

    ImageView image;
    private Bitmap bitmap;

    private List<Movie> list;

    public RecAdapter(List<Movie> list) {
        this.list = list;
    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new RecViewHolder(view);
    }



    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {
        Movie movie = list.get(position);

        holder.bind(movie);

        holder.itemView.setOnClickListener(v -> {
            boolean expanded = movie.isExpanded();
            movie.setExpanded(!expanded);
            notifyItemChanged(position);
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0: list.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView genre;
        private TextView year;
        private View subItem;

        public RecViewHolder (View itemView) {
            super (itemView);

            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.sub_item_genre);
            year = itemView.findViewById(R.id.sub_item_year);
            subItem = itemView.findViewById(R.id.sub_item);
            image = itemView.findViewById(R.id.image_view);
        }

        private void bind(Movie movie) {
            boolean expanded = movie.isExpanded();

            subItem.setVisibility(expanded ? View.VISIBLE: View.GONE);

            title.setText(movie.getTitle());
            genre.setText("Genre: " + movie.getGenre());
            year.setText("year: " + movie.getYear());

            new doIt().execute();
        }

        public class doIt extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    bitmap = BitmapFactory.
                            decodeStream((InputStream) new URL("https://posterspy.com/wp-content/uploads/2018/09/pulp-fiction-poster-1-480x710.png")
                                    .getContent());
                } catch (Exception e){e.printStackTrace();}
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                image.setImageBitmap(bitmap);
            }
    }
}}
