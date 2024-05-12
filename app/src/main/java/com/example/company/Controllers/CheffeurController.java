package com.example.company.Controllers;

import androidx.annotation.NonNull;

import com.example.company.Entety.entity.Cheffeur; // Changed from Person to Cheffeur
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheffeurController { // Changed from PersonController to CheffeurController
    private AllApi allApi;

    public CheffeurController() {
        RetrofitService retrofitService = new RetrofitService();
        allApi = retrofitService.getRetrofit().create(AllApi.class);
    }

    public void getAllCheffeurs(CheffeurListCallback callback) { // Changed from getAllPersons to getAllCheffeurs
        allApi.getCheffeurs().enqueue(new Callback<List<Cheffeur>>() { // Changed from getPersons to getCheffeurs
            @Override
            public void onResponse(@NonNull Call<List<Cheffeur>> call, @NonNull Response<List<Cheffeur>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch cheffeurs"); // Changed from persons to cheffeurs
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Cheffeur>> call, @NonNull Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }
    public void addCheffeur(Cheffeur cheffeur, CheffeurCallback callback) {
        allApi.addCheffeur(cheffeur).enqueue(new Callback<Cheffeur>() {
            @Override
            public void onResponse(Call<Cheffeur> call, Response<Cheffeur> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to add cheffeur");
                }
            }

            @Override
            public void onFailure(Call<Cheffeur> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void updateCheffeur(Long id, Cheffeur cheffeur, CheffeurCallback callback) {
        allApi.updateCheffeur(id, cheffeur).enqueue(new Callback<Cheffeur>() {
            @Override
            public void onResponse(Call<Cheffeur> call, Response<Cheffeur> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to update cheffeur");
                }
            }

            @Override
            public void onFailure(Call<Cheffeur> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void deleteCheffeur(Long id, CheffeurCallback callback) {
        allApi.deleteCheffeur(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to delete cheffeur");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void getCheffeurById(Long id, CheffeurCallback callback) { // Changed from getPersonById to getCheffeurById
        allApi.getCheffeur(id).enqueue(new Callback<Cheffeur>() { // Changed from getPerson to getCheffeur
            @Override
            public void onResponse(Call<Cheffeur> call, Response<Cheffeur> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch cheffeur"); // Changed from person to cheffeur
                }
            }

            @Override
            public void onFailure(Call<Cheffeur> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    // Other methods (addCheffeur, updateCheffeur, deleteCheffeur) follow the same pattern.

    // Define callback interfaces for various operations

    public interface CheffeurListCallback { // Changed from PersonListCallback to CheffeurListCallback
        void onSuccess(List<Cheffeur> cheffeurs); // Changed from persons to cheffeurs

        void onError(String message);
    }

    public interface CheffeurCallback { // Changed from PersonCallback to CheffeurCallback
        void onSuccess();

        void onSuccess(Cheffeur cheffeur); // Changed from person to cheffeur

        void onError(String message);
    }

    // VoidCallback remains the same.
}
