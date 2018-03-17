package com.company.reportarchive.reportarchive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.company.reportarchive.reportarchive.adapters.QueryDataAdapter;
import com.company.reportarchive.reportarchive.models.ResultModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private EditText mAadharQuery;
    private QueryDataAdapter mQueryDataAdapter;
    ArrayList<ResultModel> mResultModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mResultModelArrayList = new ArrayList<>();

        mResultModelArrayList.add(new ResultModel("HIV-1B","XYZ","12-12-2010"));
        mResultModelArrayList.add(new ResultModel("HeamoGlobin Test","Abc","12-2-2015"));
        mResultModelArrayList.add(new ResultModel("E.S.R","JHG","1-09-2011"));
        mResultModelArrayList.add(new ResultModel("Blood Clotting","KUL","23-7-2009"));
        mResultModelArrayList.add(new ResultModel("Blood Test","NHG","10-09-2015"));
        mResultModelArrayList.add(new ResultModel("LFT","HSS","30-07-2014"));

        mQueryDataAdapter = new QueryDataAdapter(this,mResultModelArrayList);

        mRecyclerView.setAdapter(mQueryDataAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setHasFixedSize(true);

    }


    void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        mAadharQuery = (EditText) findViewById(R.id.aadhar_text_field);
    }
}
