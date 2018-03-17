package com.company.reportarchive.reportarchive.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.company.reportarchive.reportarchive.R;
import com.company.reportarchive.reportarchive.models.ResultModel;

import java.util.ArrayList;

/**
 * Created by gaurav on 17/3/18.
 */

public class QueryDataAdapter extends RecyclerView.Adapter<QueryDataAdapter.ViewHolder> {

    Context context;
    ArrayList<ResultModel> mResultModelArrayList;

    public QueryDataAdapter(Context context, ArrayList<ResultModel> mResultModelArrayList) {
        this.context = context;
        this.mResultModelArrayList = mResultModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.result_item_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mTestNameTextView.setText(mResultModelArrayList.get(position).getmTestName());
            holder.mDoctorNameTextView.setText(mResultModelArrayList.get(position).getmDoctorName());
            holder.mTimeTextView.setText(mResultModelArrayList.get(position).getmDateTime());
    }

    @Override
    public int getItemCount() {
        return mResultModelArrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTestNameTextView;
        private TextView mDoctorNameTextView;
        private TextView mTimeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTestNameTextView = itemView.findViewById(R.id.testNameTextView);
            mDoctorNameTextView = itemView.findViewById(R.id.doctorNameTextView);
            mTimeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }

}
