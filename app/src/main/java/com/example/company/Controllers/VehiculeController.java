package com.example.company.Controllers;

import com.example.company.Entety.entity.Vehicule;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehiculeController {
    private AllApi allApi;

    public VehiculeController() {
        RetrofitService retrofitService = new RetrofitService();
        allApi = retrofitService.getRetrofit().create(AllApi.class);
    }

    public void getAllVehicules(VehiculeListCallback callback) {
        allApi.getVehicules().enqueue(new Callback<List<Vehicule>>() {
            @Override
            public void onResponse(Call<List<Vehicule>> call, Response<List<Vehicule>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch vehicles");
                }
            }

            @Override
            public void onFailure(Call<List<Vehicule>> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    /*public void getVehiculeById(Long id, VehiculeCallback callback) {
        allApi.getVehicule(id).enqueue(new Callback<Vehicule>() {
            @Override
            public void onResponse(Call<Vehicule> call, Response<Vehicule> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch vehicle");
                }
            }

            @Override
            public void onFailure(Call<Vehicule> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }*/
    public void addVehicule(Vehicule vehicule, VehiculeCallback callback) {
        allApi.addVehicule(vehicule).enqueue(new Callback<Vehicule>() {
            @Override
            public void onResponse(Call<Vehicule> call, Response<Vehicule> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to add vehicule");
                }
            }

            @Override
            public void onFailure(Call<Vehicule> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void updateVehicule(Long id, Vehicule vehicule, VehiculeCallback callback) {
        allApi.updateVehicule(id, vehicule).enqueue(new Callback<Vehicule>() {
            @Override
            public void onResponse(Call<Vehicule> call, Response<Vehicule> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to update vehicule");
                }
            }

            @Override
            public void onFailure(Call<Vehicule> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void deleteVehicule(Long id, VehiculeCallback callback) {
        allApi.deleteVehicule(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to delete vehicule");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public interface VehiculeListCallback {
        void onSuccess(List<Vehicule> vehicules);

        void onError(String message);
    }

    public interface VehiculeCallback {
        void onSuccess();

        void onSuccess(Vehicule vehicule);

        void onError(String message);
    }
}
