package com.kwon.rest_prac.network;

import com.kwon.rest_prac.event.EventResult;
import com.kwon.rest_prac.event_update.EventUpdateResult;
import com.kwon.rest_prac.list.ListResult;
import com.kwon.rest_prac.main.MainResult;
import com.kwon.rest_prac.page.PageResult;
import com.kwon.rest_prac.update.UpdateResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkService {
      @POST("/user/login")
      Call<String> getLogin(@Field("id") String id,
                            @Field("pw") String pw);

      @GET("/user/logout")
      Call<String> getLogout();

      @GET("/main")
      Call<MainResult> getMain();

      @GET("/club/category/{name}")
      Call<ListResult> getCategory(@Path("name") String name);

      @GET("/club/search")
      Call<ListResult> getSearch(@Query("keyword") String keyword);

      @GET("/club/info/{num1}")
      Call<PageResult> getInfo(@Path("num1") int num1);

      @POST("/club/info/{num1}")    //동아리번호
      Call<String> modified_info(@Path("num1") int num1,
                                 @Body UpdateResult updateResult);

      @POST("/club/image/{num1}/{num2}")    //동아리번호, 사진번호
      Call<String> modified_photo(@Path("num1") int num1,
                                 @Path("num2") int num2);

      @GET("/event/list/{date}")
      Call<EventResult> getEventList(@Path("date") String date);

      @GET("/club/event/{event_num}")
      Call<EventResult> getEvent(@Path("event_num") int event_num);

      @POST("/event/new")
      Call<String> resister_event(@Body EventUpdateResult eventUpdateResult);

      @POST("/event/{event_num}/edit")
      Call<String> update_event(@Body EventUpdateResult eventUpdateResult);

      @POST("/event/{event_num}/delete")
      Call<String> delete_event();
}



