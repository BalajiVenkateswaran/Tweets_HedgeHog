package hedgehoglab.com.tweets_hedgehoglab;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    final static String twitterScreenName = "HedgeHogLab";
    final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidNetworkUtility androidNetworkUtility = new AndroidNetworkUtility();
        if (androidNetworkUtility.isConnected(this)) {
            new TwitterAsyncTask().execute(twitterScreenName,this);
        } else {
            Log.v(TAG, "Network not Available!");
        }

    }

}
