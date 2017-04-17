package sakurafish.com.mvvm.sample.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sakurafish.com.mvvm.sample.api.DummyDataService;

public final class MainViewModel extends BaseObservable implements ViewModel {

    public ObservableField<String> code;

    private CompositeDisposable compositeDisposable;
    private DummyDataService dummyDataService;

    @Inject
    MainViewModel(DummyDataService dummyDataService, CompositeDisposable compositeDisposable) {
        if (code == null) {
            code = new ObservableField<>();
        }
        this.compositeDisposable = compositeDisposable;
        this.dummyDataService = dummyDataService;
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }

    public void requestDummyData() {
        Disposable disposable = dummyDataService.getDummyData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dummyData -> {
                    code.set(String.valueOf(dummyData.code));
                }, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    // TODO 後で消す
    public void setCode(String code) {
        this.code.set(code);
    }
}
