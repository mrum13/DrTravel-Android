package com.inreadyworkgroup.drtravel_beta.api;

import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.models.DefaultResponse;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

    @GET("allWisata")
    Call<WisataResponse> getAllWisata();

    @GET("wisataPopuler")
    Call<WisataResponse> getPopulerWisata();

    @FormUrlEncoded
    @POST("searchWisata")
    Call<WisataResponse> searchWisata(
            @Field("nama_tempat") String nama_tempat
    );

    @FormUrlEncoded
    @POST("detailWisata")
    Call<WisataResponse> detailWisata(
            @Field("nama_tempat") String nama_wisata
    );
}
