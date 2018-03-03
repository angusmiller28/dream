package com.example.angusmiller.dream;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by angusmiller on 3/3/18.
 */

public class RecordsAdapter extends RecyclerView.Adapter<RecordsAdapter.MyViewHolder> {
    private List<Record> recordsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView date, duration, period;

        public MyViewHolder(View view) {
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            duration = (TextView) view.findViewById(R.id.duration);
            period = (TextView) view.findViewById(R.id.period);
        }
    }


    public RecordsAdapter(List<Record> recordsList) {
        this.recordsList = recordsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Record record = recordsList.get(position);
        holder.date.setText(record.getDate());
        holder.duration.setText(record.getDuration());
        holder.period.setText(record.getPeriod());
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

}
