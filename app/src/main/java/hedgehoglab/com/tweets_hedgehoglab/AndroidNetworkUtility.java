package hedgehoglab.com.tweets_hedgehoglab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by BALAJI on 28-08-2016.
 */
public class AndroidNetworkUtility {
    public boolean isConnected(Context ctx){
        boolean flag = false;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            flag = true;
        }
        return flag;
    }
}
