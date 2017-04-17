package sakurafish.com.mvvm.sample.di;

import dagger.Subcomponent;
import sakurafish.com.mvvm.sample.view.fragment.MainFragment;

@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(MainFragment fragment);

}
