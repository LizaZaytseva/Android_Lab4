package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;
import name.ank.lab4.Keys;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemClass> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdaptClass adapter = new AdaptClass(this, data);
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void init() throws IOException {
        try {
            BibDatabase database = new BibDatabase(
                    new InputStreamReader(getResources().openRawResource(R.raw.articles))
            );
            int i = 0;
            while (i < 32){
                BibEntry entry = database.getEntry(i);
                ItemClass item = new ItemClass();
                item.item(entry.getField(Keys.AUTHOR), entry.getField(Keys.TITLE), entry.getField(Keys.JOURNAL), entry.getField(Keys.YEAR), entry.getField(Keys.PAGES));
                data.add(item);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}