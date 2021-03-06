/* ---------------------------------------------------------------------
*
*  LICENSE
*
*  This file is part of the GLPI API Client Library for Java,
*  a subproject of GLPI. GLPI is a free IT Asset Management.
*
*  GLPI is free software: you can redistribute it and/or
*  modify it under the terms of the GNU General Public License
*  as published by the Free Software Foundation; either version 3
*  of the License, or (at your option) any later version.
*
*  GLPI is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*  --------------------------------------------------------------------
*  @author    Rafael Hernandez - <rhernandez@teclib.com>
*  @copyright (C) 2017 Teclib' and contributors.
*  @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
*  @link      https://github.com/glpi-project/java-library-glpi
*  @link      http://www.glpi-project.org/
*  --------------------------------------------------------------------
*/

package org.glpi.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.glpi.api.request.ChangeActiveEntitiesRequest;
import org.glpi.api.request.ChangeActiveProfileRequest;
import org.glpi.api.request.RecoveryPasswordRequest;
import org.glpi.api.request.ResetPasswordRequest;
import org.glpi.api.response.InitSession;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface Routes {

    @Headers("Content-Type: application/json")
    @GET("initSession")
    Call<InitSession> initSessionByUserToken(@Header("Authorization") String authorization);

    @Headers("Content-Type: application/json")
    @GET("initSession")
    Call<InitSession> initSessionByCredentials(@Header("Authorization") String authorization);

    @Headers("Content-Type: application/json")
    @GET("killSession")
    Call<Void> killSession(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getMyProfiles")
    Call<JsonObject> getMyProfiles(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getActiveProfile")
    Call<JsonObject> getActiveProfile(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getMyEntities")
    Call<JsonObject> getMyEntities(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getActiveEntities")
    Call<JsonObject> getActiveEntities(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getFullSession")
    Call<JsonObject> getFullSession(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("getGlpiConfig")
    Call<JsonObject> getGlpiConfig(@HeaderMap Map<String, String> headers);

    @Headers("Content-Type: application/json")
    @GET("{itemType}")
    Call<JsonArray> getAllItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @GET("{itemType}/{id}")
    Call<JsonObject> getAnItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Path("id") String id, @QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @GET("{itemType}/{id}/{subItemType}")
    Call<JsonObject> getSubItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Path("id") String id, @Path("subItemType") String subItemType, @QueryMap Map<String, String> options);

    @Headers("Content-Type: application/json")
    @POST("changeActiveProfile")
    Call<Void> changeActiveProfile(@HeaderMap Map<String, String> headers,  @Body ChangeActiveProfileRequest requestPost);

    @Headers("Content-Type: application/json")
    @POST("changeActiveEntities")
    Call<Void> changeActiveEntities(@HeaderMap Map<String, String> headers,  @Body ChangeActiveEntitiesRequest requestPost);

    @Headers("Content-Type: application/json")
    @POST("{itemType}")
    Call<JsonArray> addItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Body Object requestPost);

    @Headers("Content-Type: application/json")
    @PUT("{itemType}/{id}")
    Call<JsonArray> updateItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Path("id") String id, @Body Object requestPost);

    @Headers("Content-Type: application/json")
    @DELETE("{itemType}/{id}")
    Call<JsonArray> deleteItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Path("id") String id);

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "{itemType}", hasBody = true)
    Call<JsonArray> deleteMultiplesItem(@HeaderMap Map<String, String> headers, @Path("itemType") String itemType, @Body Object requestPost);

    @Headers("Content-Type: application/json")
    @PUT("lostPassword")
    Call<Void> lostPassword(@Body RecoveryPasswordRequest requestPost);

    @Headers("Content-Type: application/json")
    @PUT("lostPassword")
    Call<Void> recoveryPassword(@Body ResetPasswordRequest requestPost);

}
