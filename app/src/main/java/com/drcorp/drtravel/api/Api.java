package com.drcorp.drtravel.api;

import com.drcorp.drtravel.models.GalleriResponse;
import com.drcorp.drtravel.models.KulinerResponseAtas;
import com.drcorp.drtravel.models.KulinerResponseBawah;
import com.drcorp.drtravel.models.LoginResponse;
import com.drcorp.drtravel.models.DefaultResponse;
import com.drcorp.drtravel.models.MasjidResponseAtas;
import com.drcorp.drtravel.models.MasjidResponseBawah;
import com.drcorp.drtravel.models.PenginapanResponseBawah;
import com.drcorp.drtravel.models.PenginapanResponseAtas;
import com.drcorp.drtravel.models.WisataResponse;

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
    @POST("detailWisata")
    Call<WisataResponse> detailWisata(
            @Field("nama_tempat") String nama_wisata
    );

    @FormUrlEncoded
    @POST("streetView")
    Call<WisataResponse> streetView(
            @Field("nama_tempat") String nama_wisata
    );

    @FormUrlEncoded
    @POST("searchWisata")
    Call<WisataResponse> searchWisata(
            @Field("nama_tempat") String nama_tempat
    );

    @FormUrlEncoded
    @POST("galleriWisata")
    Call<GalleriResponse> galleriWisata(
            @Field("nama_tempat") String nama_tempat
    );

    @FormUrlEncoded
    @POST("galleriPenginapan")
    Call<GalleriResponse> galleriPenginapan(
            @Field("nama_tempat") String nama_tempat
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
