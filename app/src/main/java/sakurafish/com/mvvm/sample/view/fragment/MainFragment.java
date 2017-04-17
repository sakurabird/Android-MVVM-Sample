package sakurafish.com.mvvm.sample.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import sakurafish.com.mvvm.sample.R;
import sakurafish.com.mvvm.sample.databinding.FragmentMainBinding;
import sakurafish.com.mvvm.sample.viewmodel.MainViewModel;

public class MainFragment extends BaseFragment {

    public static final String TAG = MainFragment.class.getSimpleName();

    private FragmentMainBinding binding;

    @Inject
    MainViewModel viewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {
    }

    @Override
    public void onDetach() {
        viewModel.destroy();
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO 後で消す
        viewModel.setCode("１と表示されたら成功");

        viewModel.requestDummyData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setMainViewModel(viewModel);
        return binding.getRoot();
    }
}
