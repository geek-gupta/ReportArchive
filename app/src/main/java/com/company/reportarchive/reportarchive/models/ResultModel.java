package com.company.reportarchive.reportarchive.models;

/**
 * Created by gaurav on 17/3/18.
 */

public class ResultModel {


    private String mTestName;
    private String mDoctorName;
    private String mDateTime;


    public ResultModel(String mTestName, String mDoctorName, String mDateTime) {
        this.mTestName = mTestName;
        this.mDoctorName = mDoctorName;
        this.mDateTime = mDateTime;
    }

    public String getmTestName() {
        return mTestName;
    }

    public void setmTestName(String mTestName) {
        this.mTestName = mTestName;
    }

    public String getmDoctorName() {
        return mDoctorName;
    }

    public void setmDoctorName(String mDoctorName) {
        this.mDoctorName = mDoctorName;
    }

    public String getmDateTime() {
        return mDateTime;
    }

    public void setmDateTime(String mDateTime) {
        this.mDateTime = mDateTime;
    }
}
