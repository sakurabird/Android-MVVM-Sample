package sakurafish.com.mvvm.sample.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import sakurafish.com.mvvm.sample.R;
import sakurafish.com.mvvm.sample.databinding.ActivityMainBinding;
import sakurafish.com.mvvm.sample.view.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        replaceFragment(MainFragment.newInstance(), R.id.content_view);
    }
}
