package sakurafish.com.mvvm.sample;

import android.app.Application;
import android.support.annotation.NonNull;

import sakurafish.com.mvvm.sample.di.ApplicationComponent;
import sakurafish.com.mvvm.sample.di.ApplicationModule;
import sakurafish.com.mvvm.sample.di.DaggerApplicationComponent;

public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    @NonNull
    public ApplicationComponent getComponent() {
        return applicationComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
