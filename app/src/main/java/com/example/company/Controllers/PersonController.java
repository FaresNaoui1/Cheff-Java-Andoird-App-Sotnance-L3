package com.example.company.Controllers;

import androidx.annotation.NonNull;

import com.example.company.Entety.entity.Person;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonController {
    private AllApi allApi;

    public PersonController() {
        RetrofitService retrofitService = new RetrofitService();
        allApi = retrofitService.getRetrofit().create(AllApi.class);
    }

    public void getAllPersons(PersonListCallback callback) {
        allApi.getPersons().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(@NonNull Call<List<Person>> call, @NonNull Response<List<Person>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch persons");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Person>> call, @NonNull Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void getPersonById(Long id, PersonCallback callback) {
        allApi.getPerson(id).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to fetch person");
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void addPerson(Person person, PersonCallback callback) {
        allApi.addPerson(person).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to add person");
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void updatePerson(Long id, Person person, PersonCallback callback) {
        allApi.updatePerson(id, person).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError("Failed to update person");
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    public void deletePerson(Long id, VoidCallback callback) {
        allApi.deletePerson(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess();
                } else {
                    callback.onError("Failed to delete person");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onError("Network error: " + t.getMessage());
            }
        });
    }

    // Define callback interfaces for various operations

    public interface PersonListCallback {
        void onSuccess(List<Person> persons);

        void onError(String message);
    }

    public interface PersonCallback {
        void onSuccess();

        void onSuccess(Person person);

        void onError(String message);
    }

    public interface VoidCallback {
        void onSuccess();

        void onError(String message);
    }
}
