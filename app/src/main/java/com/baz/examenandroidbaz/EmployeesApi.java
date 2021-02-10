package com.baz.examenandroidbaz;

import com.baz.examenandroidbaz.data.Service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeesApi {
    @GET("https://dl.dropboxusercontent.com/s/5u21281sca8gj94/getFile.json?dl=0")
    public Call<Service> getZip();
}
