package icte.cph.aau.group25washingmashine;

import android.app.Application;

import com.auth0.lock.Lock;
import com.auth0.lock.LockProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


public class WashineMachineApplication extends Application implements LockProvider {
    private Lock lock;

    @Override
    public void onCreate() {
        super.onCreate();

        //Initiating Facebook SDK with our project.
        FacebookSdk.sdkInitialize(getApplicationContext());

        //Initiating AppsEventsLogger.
        // We can now see how many people are using the app by checking
        // how many times Facebook SDK is initiated, and how many have signed in/out.
        AppEventsLogger.activateApp(this);

        //Initiating Auth0. We can now log in with Auth0 and the added Identity Providers.
        /*
        lock = new Lock.Builder()
                .withIdentityProvider(Strategies.Facebook, new FacebookIdentityProvider(this))
                .withIdentityProvider(Strategies.GooglePlus, new GooglePlusIdentityProvider(this))
                .build();

        */
    }

    @Override
    public Lock getLock() {
        return lock;
    }
}
