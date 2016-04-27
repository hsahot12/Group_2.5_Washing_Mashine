package icte.cph.aau.group25washingmashine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.auth0.core.Token;
import com.auth0.core.UserProfile;
import com.auth0.lock.Lock;
import com.auth0.lock.LockActivity;

public class MainActivity extends AppCompatActivity {
    //Defining the LocalBroadcastManager.
    // This class returns the results from the service runned by Auth0
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate Localbroadcastmanager
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //Auth0 handles the internet connecting in the background via a service,
                // and the user information are returned back to this localbroadcastmanager.

                //Retrieving user information. The scopes are defined inside Auth0 Dashboard.
                UserProfile userProfile = intent.getParcelableExtra(Lock.AUTHENTICATION_ACTION_PROFILE_PARAMETER);



                Token token = intent.getParcelableExtra(Lock.AUTHENTICATION_ACTION_TOKEN_PARAMETER);



            }
        }, new IntentFilter(Lock.AUTHENTICATION_ACTION));


//        loginWithAuth0();
    }

    private void loginWithAuth0() {
        //Starting the built-in Activity for Lock in order to log in.
        // Auth0 creates the UI which we just need to call
        Intent lockIntent = new Intent(this, LockActivity.class);
        startActivity(lockIntent);
    }
}
