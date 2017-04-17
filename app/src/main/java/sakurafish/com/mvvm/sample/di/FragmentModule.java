package sakurafish.com.mvvm.sample.di;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import sakurafish.com.mvvm.sample.view.fragment.BaseFragment;

@Module
public class FragmentModule {

    private final BaseFragment fragment;

    public FragmentModule(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public BaseFragment provideFragment() {
        return fragment;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return fragment.getFragmentManager();
    }

}
