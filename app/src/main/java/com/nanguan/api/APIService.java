package com.nanguan.api;

import com.nanguan.bean.HttpBean;
import com.nanguan.bean.UserInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
/**
 * Created by lj
 */
public interface APIService {
    @GET("user/login.do")
    Observable<HttpBean<UserInfo>> login(@Query("phone") String loginName, @Query("pwd") String password);
}
