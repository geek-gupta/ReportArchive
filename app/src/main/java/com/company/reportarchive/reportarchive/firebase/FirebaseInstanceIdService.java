package com.company.reportarchive.reportarchive.firebase;

/**
 * Created by gaurav on 18/3/18.
 */

public class FirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {
    //    FirebaseDatabase firebaseDatabase;
//    DatabaseReference myRef;
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
//        String token = FirebaseInstanceId.getInstance().getToken();
//        firebaseDatabase = FirebaseDatabase.getInstance();

    }

}