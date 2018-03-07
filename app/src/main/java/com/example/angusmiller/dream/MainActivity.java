package com.example.angusmiller.dream;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Record> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecordsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // config card view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new RecordsAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // Floating Action Bar Config
        final boolean[] flag_clicked = {true};
        final Record[] record = new Record[1];
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag_clicked[0]){
                    Snackbar.make(view, "Record added! We have just started recording your sleep pattern.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fab.setImageResource(R.drawable.stop);
                    record[0] = addRecordData();
                    flag_clicked[0] = false;
                } else {
                    Snackbar.make(view, "Record stop! We have just stopped recording your sleep pattern.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    fab.setImageResource(R.drawable.start);
                    stopRecordData(record[0]);
                    flag_clicked[0] = true;
                }
            }
        });
    }

    private Record addRecordData() {
        // get data
        String date = new SimpleDateFormat("EEE, d MMM", Locale.getDefault()).format(new Date());
        String startTime = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());
        Record record = new Record(date, startTime);
        movieList.add(record);

        mAdapter.notifyDataSetChanged();
        return  record;
    }

    private void stopRecordData(Record record) {
        // get data
        String endTime = new SimpleDateFormat("h:mm a", Locale.getDefault()).format(new Date());
        record.updateRecord("8 hours 44 minutes", endTime);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, settings.class);
                startActivity(intent);
                return true;
            case R.id.action_history:
                intent = new Intent(this, Graph.class);
                startActivity(intent);
                return true;
            case R.id.action_records:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
