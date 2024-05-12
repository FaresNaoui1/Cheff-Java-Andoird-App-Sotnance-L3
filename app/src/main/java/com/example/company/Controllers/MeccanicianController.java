
 package com.example.company.Controllers;

import androidx.annotation.NonNull;

import com.example.company.Entety.entity.Mecanician; // Changed from Person to Mecanician
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MeccanicianController {
    private AllApi allApi;

    public MeccanicianController() {
        RetrofitService retrofitService = new RetrofitService();
        allApi = retrofitService.getRetrofit().create(AllApi.class);
    }

    public void getAllMecanicians(MecanicianListCallback callback) { // Changed from getAllPersons to getAllMecanicians
        allApi.getMecanicians().enqueue(new Callback<List<Mecanician>>() { // Changed from getPersons to getMecanicians
            @Override
            public void onResponse(@NonNull Call<List<Mecanician>> call, @NonNull Response<List<Mecanician>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch mecanicians"); // Changed from persons to mecanicians
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Mecanician>> call, @NonNull Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void getMecanicianById(Long id, MecanicianCallback callback) { // Changed from getPersonById to getMecanicianById
        allApi.getMecanician(id).enqueue(new Callback<Mecanician>() { // Changed from getPerson to getMecanician
            @Override
            public void onResponse(Call<Mecanician> call, Response<Mecanician> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch mecanician"); // Changed from person to mecanician
                }
            }

            @Override
            public void onFailure(Call<Mecanician> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }
    public void addMecanician(Mecanician mecanician, MecanicianCallback callback) { // Changed from addPerson to addMecanician
        allApi.addMecanician(mecanician).enqueue(new Callback<Mecanician>() { // Changed from addPerson to addMecanician
            @Override
            public void onResponse(Call<Mecanician> call, Response<Mecanician> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to add mecanician"); // Changed from person to mecanician
                }
            }

            @Override
            public void onFailure(Call<Mecanician> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void updateMecanician(Long id, Mecanician mecanician, MecanicianCallback callback) { // Changed from updatePerson to updateMecanician
        allApi.updateMecanician(id, mecanician).enqueue(new Callback<Mecanician>() { // Changed from updatePerson to updateMecanician
            @Override
            public void onResponse(Call<Mecanician> call, Response<Mecanician> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to update mecanician"); // Changed from person to mecanician
                }
            }

            @Override
            public void onFailure(Call<Mecanician> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void deleteMecanician(Long id, MecanicianCallback callback) { // Changed from deletePerson to deleteMecanician
        allApi.deleteMecanician(id).enqueue(new Callback<Void>() { // Changed from deletePerson to deleteMecanician
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to delete mecanician"); // Changed from person to mecanician
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    // Other methods (addMecanician, updateMecanician, deleteMecanician) follow the same pattern.

    // Define callback interfaces for various operations

    public interface MecanicianListCallback { // Changed from PersonListCallback to MecanicianListCallback
        void onSuccess(List<Mecanician> mecanicians); // Changed from persons to mecanicians

        void onError(String message);
    }

    public interface MecanicianCallback { // Changed from PersonCallback to MecanicianCallback
        void onSuccess();

        void onSuccess(Mecanician mecanician); // Changed from person to mecanician

        void onError(String message);
    }

    // VoidCallback remains the same.
}


