package com.inreadyworkgroup.drtravel_beta.api;

import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.KulinerResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.LoginResponse;
import com.inreadyworkgroup.drtravel_beta.models.DefaultResponse;
import com.inreadyworkgroup.drtravel_beta.models.MasjidResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.MasjidResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseBawah;
import com.inreadyworkgroup.drtravel_beta.models.PenginapanResponseAtas;
import com.inreadyworkgroup.drtravel_beta.models.WisataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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

    @FormUrlEncoded
    @POST("forgetPass")
    Call<DefaultResponse> forgetPass(
            @Field("email") String email
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

    @GET("allKuliner")
    Call<KulinerResponseBawah> getAllKuliner();

    @GET("kulinerPopuler")
    Call<KulinerResponseAtas> getPopulerKuliner();

    @FormUrlEncoded
    @POST("detailKulinerAll")
    Call<KulinerResponseBawah> detailKulinerBawah(
            @Field("tvMenuBawah") String tvMenuBawah
    );

    @FormUrlEncoded
    @POST("detailKulinerFav")
    Call<KulinerResponseAtas> detailKulinerAtas(
            @Field("tvMenuAtas") String tvMenuAtas
    );

    @GET("allPenginapan")
    Call<PenginapanResponseBawah> getAllPenginapan();

    @GET("penginapanPopuler")
    Call<PenginapanResponseAtas> getPopulerPenginapan();

    @FormUrlEncoded
    @POST("detailPenginapanAll")
    Call<PenginapanResponseBawah> detailPenginapanBawah(
            @Field("tvMenuBawah") String tvMenuBawah
    );

    @GET("allMasjid")
    Call<MasjidResponseBawah> getAllMasjid();

    @GET("masjidPopuler")
    Call<MasjidResponseAtas> getPopulerMasjid();

    @FormUrlEncoded
    @POST("detailMasjidAll")
    Call<MasjidResponseBawah> detailMasjidBawah(
            @Field("tvMenuBawah") String tvMenuBawah
    );

    @FormUrlEncoded
    @PUT("updateUser/{id}")
    Call<LoginResponse> updateUser(
            @Path("id") int id,
            @Field("email") String email,
            @Field("name") String name
    );
}
