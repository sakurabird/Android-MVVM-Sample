package sakurafish.com.mvvm.sample.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import sakurafish.com.mvvm.sample.model.network.DummyData;

public interface DummyDataService {

    @GET("/api/v1/dummy_api/status")
    Single<DummyData> getDummyData();
}
