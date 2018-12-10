package saha.app.portalti16.network;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import saha.app.portalti16.entity.DaftarMahasiswa;
import saha.app.portalti16.entity.Mahasiswa;

public interface Routes {

    /**
     medefinisikan route dari web services yang disediakan
     jika di deskripsikan, berarti:
     https://ti16.herokuapp.com/list.php
     */
    @GET("dev/list_mahasiswa")
    Call<DaftarMahasiswa> getMahasiswa();

    /**
     medefinisikan route dari web services yang disediakan
     jika di deskripsikan, berarti:
     https://ti16.herokuapp.com/add.php
     @param name
     @param nim
     */
    @POST("insert_mahasiswa")
    @FormUrlEncoded
    Call<Mahasiswa> postMahasiswa(
            @Field("name") String name,
            @Field("nim") String nim
    );

    //untuk menghapus mahasiswa berdasarkan id
    @DELETE("mahasiswatest/{mhsId}")
    Call<Mahasiswa> deleteMahasiswa(
            @Path("mhsId") String mhsId
    );

}
