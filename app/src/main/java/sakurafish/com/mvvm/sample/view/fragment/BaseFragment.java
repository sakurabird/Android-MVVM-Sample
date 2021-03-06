package sakurafish.com.mvvm.sample.view.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import sakurafish.com.mvvm.sample.di.FragmentComponent;
import sakurafish.com.mvvm.sample.di.FragmentModule;
import sakurafish.com.mvvm.sample.view.activity.BaseActivity;

public abstract class BaseFragment extends Fragment {

    private FragmentComponent fragmentComponent;

    @NonNull
    public FragmentComponent getComponent() {
        if (fragmentComponent != null) {
            return fragmentComponent;
        }

        Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            fragmentComponent = ((BaseActivity) activity).getComponent().plus(new FragmentModule(this));
            return fragmentComponent;
        } else {
            throw new IllegalStateException(
                    "The activity of this fragment is not an instance of BaseActivity");
        }
    }
}
