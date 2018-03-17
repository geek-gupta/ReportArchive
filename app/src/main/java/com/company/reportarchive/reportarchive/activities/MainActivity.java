package com.company.reportarchive.reportarchive.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.company.reportarchive.reportarchive.R;
import com.company.reportarchive.reportarchive.adapters.QueryDataAdapter;
import com.company.reportarchive.reportarchive.models.ResultModel;
import com.company.reportarchive.reportarchive.send_data.AddTestData;

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

        init();

        mResultModelArrayList = new ArrayList<>();

        mResultModelArrayList.add(new ResultModel("HIV-1B","XYZ","12-12-2010"));
        mResultModelArrayList.add(new ResultModel("HeamoGlobin Test","Abc","12-2-2015"));
        mResultModelArrayList.add(new ResultModel("E.S.R","JHG","1-09-2011"));
        mResultModelArrayList.add(new ResultModel("Blood Clotting","KUL","23-7-2009"));
        mResultModelArrayList.add(new ResultModel("Blood Test","NHG","10-09-2015"));
        mResultModelArrayList.add(new ResultModel("LFT","HSS","30-07-2014"));

        mQueryDataAdapter = new QueryDataAdapter(this,mResultModelArrayList);



        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mQueryDataAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_test_data){
            Intent intent = new Intent(MainActivity.this, AddTestData.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        mAadharQuery = (EditText) findViewById(R.id.aadhar_text_field);
    }
}
