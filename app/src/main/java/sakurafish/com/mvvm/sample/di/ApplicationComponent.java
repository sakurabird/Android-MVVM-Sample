package sakurafish.com.mvvm.sample.di;

import javax.inject.Singleton;

import dagger.Component;
import sakurafish.com.mvvm.sample.MainApplication;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainApplication application);
    ActivityComponent plus(ActivityModule module);
}
