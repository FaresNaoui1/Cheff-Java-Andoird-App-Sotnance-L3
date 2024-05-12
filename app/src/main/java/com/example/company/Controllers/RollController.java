package com.example.company.Controllers;

import com.example.company.Entety.entity.Roll;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RollController {
    private AllApi allApi;

    public RollController() {
        RetrofitService retrofitService = new RetrofitService();
        allApi = retrofitService.getRetrofit().create(AllApi.class);
    }

    public void GetRolls(RollListCallback callback) {
        allApi.getRolls().enqueue(new Callback<List<Roll>>() {
            @Override
            public void onResponse(Call<List<Roll>> call, Response<List<Roll>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch rolls");
                }
            }

            @Override
            public void onFailure(Call<List<Roll>> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void AddRoll(Roll roll, RollCallback callback) {
        allApi.addRoll(roll).enqueue(new Callback<Roll>() {
            @Override
            public void onResponse(Call<Roll> call, Response<Roll> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to add roll");
                }
            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void UpdateRoll(Long id, Roll roll, RollCallback callback) {
        allApi.updateRoll(id, roll).enqueue(new Callback<Roll>() {
            @Override
            public void onResponse(Call<Roll> call, Response<Roll> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to update roll");
                }
            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

 /*   public void DeleteRoll(Long id, RollCallback callback) {
        allApi.deleteRoll(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to delete roll");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }*/

    public void GetRoll(Long id, RollCallback callback) {
        allApi.getRoll(id).enqueue(new Callback<Roll>() {
            @Override
            public void onResponse(Call<Roll> call, Response<Roll> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch roll");
                }
            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    // Define callback interfaces

    public interface RollListCallback {
        void onSuccess(List<Roll> rolls);

        void onError(String message);
    }

    public interface RollCallback {
        void onSuccess(Roll body);

        void onError(String message);
    }
}
