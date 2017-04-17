package sakurafish.com.mvvm.sample.di;


import dagger.Subcomponent;
import sakurafish.com.mvvm.sample.view.activity.MainActivity;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent{

    void inject(MainActivity activity);

    FragmentComponent plus(FragmentModule module);
}
