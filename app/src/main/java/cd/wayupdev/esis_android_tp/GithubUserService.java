package cd.wayupdev.esis_android_tp;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubUserService {

    @GET("/users/{id}")
    GithubUser getUser(@Path("id") int id);
}
