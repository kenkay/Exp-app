package com.kalkay.exp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.kalkay.activities.MESSAGE"; //line could be commented out

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie ("Schindler's List", "Biography, Drama, History", 1993));
        movieList.add(new Movie ("Pulp Fiction", "Crime, Drama", 1994));

        RecAdapter adapter = new RecAdapter(movieList);

        RecyclerView recyclerView = findViewById(R.id.recview);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplaySecondAct.class);
        startActivity(intent);
    }
}
