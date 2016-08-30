package hedgehoglab.com.tweets_hedgehoglab;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import hedgehoglab.com.tweets_hedgehoglab.TwitterAPI;
import hedgehoglab.com.tweets_hedgehoglab.TwitterTweet;

/**
 * Created by BALAJI on 28-08-2016.
 */
public class TwitterAsyncTask extends AsyncTask<Object, Void, ArrayList<TwitterTweet>> {
    ListActivity callerActivity;
    Context context;

    public TwitterAsyncTask(Context context) {
        this.context = context;
    }


    final static String TWITTER_API_KEY = "InRvycCzcG3gngedyLyJcYESi";
    final static String TWITTER_API_SECRET = "CpdINtc4L35VFkOQG7JToXZTIXBgKU81ZogMGC6XwVF6jTrKWe";

    public TwitterAsyncTask() {

    }



    @Override
    protected ArrayList<TwitterTweet> doInBackground(Object... params) {
        ArrayList<TwitterTweet> twitterTweets = null;
        callerActivity = (ListActivity) params[1];
        if (params.length > 0) {
            TwitterAPI twitterAPI = new TwitterAPI(TWITTER_API_KEY,TWITTER_API_SECRET);
            twitterTweets = twitterAPI.getTwitterTweets(params[0].toString());
        }
        return twitterTweets;
    }

    @Override
    protected void onPostExecute(ArrayList<TwitterTweet> twitterTweets) {

        ArrayAdapter<TwitterTweet> adapter =
                new ArrayAdapter<TwitterTweet>(callerActivity, R.layout.activity_main,
                        R.id.listTextView, twitterTweets);
        callerActivity.setListAdapter(adapter);
        ListView lv = callerActivity.getListView();
        lv.setDividerHeight(0);
    }
}
