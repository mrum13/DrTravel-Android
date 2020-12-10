package com.inreadyworkgroup.drtravel_beta.api;

import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("createUser")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("name") String name
    );

    @FormUrlEncoded
    @POST("userLogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );
}
