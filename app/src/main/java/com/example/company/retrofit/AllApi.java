package com.example.company.retrofit;

import com.example.company.Entety.entity.Cheffeur;
import com.example.company.Entety.entity.Facture;
import com.example.company.Entety.entity.Mecanician;
import com.example.company.Entety.entity.Onpanne;
import com.example.company.Entety.entity.Person;
import com.example.company.Entety.entity.Piece;
import com.example.company.Entety.entity.Rapport;
import com.example.company.Entety.entity.Roll;
import com.example.company.Entety.entity.Vehicule;
import com.example.company.Entety.entity.VehiculeMarque;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AllApi {
    //PERSON
    @GET("/api/v1/person")
    Call<List<Person>> getPersons();
    @POST("/api/v1/person")
    Call<Person> addPerson(@Body Person person);
    @PUT("/api/v1/person/{id}")
    Call<Person> updatePerson(@Path("id") Long id, @Body Person person);
    @DELETE("/api/v1/person/{id}")
    Call<Void> deletePerson(@Path("id") Long id);
    @GET("/api/v1/person/{id}")
    Call<Person> getPerson(@Path("id") Long id);
    //cheffeur
    @DELETE("/api/v1/cheffeur/{id}")
    Call<Void> deleteCheffeur(@Path("id") Long id);
    @GET("/api/v1/cheffeur/{id}")
    Call<Cheffeur> getCheffeur(@Path("id") Long id);

    @GET("/api/v1/cheffeur")
    Call<List<Cheffeur>> getCheffeurs();
    @POST("/api/v1/cheffeur")
    Call<Cheffeur> addCheffeur(@Body Cheffeur person);
    @PUT("/api/v1/cheffeur/{id}")
    Call<Cheffeur> updateCheffeur(@Path("id") Long id, @Body Cheffeur person);
//mecanician
@GET("/api/v1/mecancian")
Call<List<Mecanician>> getMecanicians();
    @POST("/api/v1/mecancian")
    Call<Mecanician> addMecanician(@Body Mecanician person);
    @PUT("/api/v1/mecancian/{id}")
    Call<Mecanician> updateMecanician(@Path("id") Long id, @Body Mecanician person);
    @DELETE("/api/v1/mecancian/{id}")
    Call<Void> deleteMecanician(@Path("id") Long id);
    @GET("/api/v1/mecancian/{id}")
    Call<Mecanician> getMecanician(@Path("id") Long id);


//VEHICULES
@GET("/api/v1/vehicule")
Call<List<Vehicule>> getVehicules();
    @POST("/api/v1/vehicule")
    Call<Vehicule> addVehicule(@Body Vehicule vehicule);

    @PUT("/api/v1/vehicule/{id}")
    Call<Vehicule> updateVehicule(@Path("id") Long id, @Body Vehicule vehicule);

    @DELETE("/api/v1/vehicule/{id}")
    Call<Void> deleteVehicule(@Path("id") Long id);
//VMARQUE
    @GET("/api/v1/VM")
    Call<List<VehiculeMarque>> getVehicleMarques();

    @POST("/api/v1/VM")
    Call<VehiculeMarque> addVehicleMarque(@Body VehiculeMarque vehicleMarque);

    @PUT("/api/v1/VM/{id}")
    Call<VehiculeMarque> updateVehicleMarque(@Path("id") Long id, @Body VehiculeMarque vehicleMarque);

    @DELETE("/api/v1/VM/{id}")
    Call<Void> deleteVehicleMarque(@Path("id") Long id);



    //Roll
    @GET("/api/v1/roll")
    Call<List<Roll>> getRolls();

    @POST("/api/v1/roll")
    Call<Roll> addRoll(@Body Roll roll);

    @PUT("/api/v1/roll/{id}")
    Call<Roll> updateRoll(@Path("id") Long id, @Body Roll roll);

    @DELETE("/api/v1/roll/{id}")
    Call<Void> deleteRoll(@Path("id") Long id);
    @GET("/api/v1/Roll/{id}")
    Call<Roll> getRoll(@Path("id") Long id);
    // Rapport operations
    @GET("/api/v1/rapport")
    Call<List<Rapport>> getRapports();

    @POST("/api/v1/rapport")
    Call<Rapport> addRapport(@Body Rapport rapport);

    @PUT("/api/v1/rapport/{id}")
    Call<Rapport> updateRapport(@Path("id") Long id, @Body Rapport rapport);

    @DELETE("/api/v1/rapport/{id}")
    Call<Void> deleteRapport(@Path("id") Long id);

    // Piece operations
    @GET("/api/v1/piece")
    Call<List<Piece>> getPieces();

    @POST("/api/v1/piece")
    Call<Piece> addPiece(@Body Piece piece);

    @PUT("/api/v1/piece/{id}")
    Call<Piece> updatePiece(@Path("id") Long id, @Body Piece piece);

    @DELETE("/api/v1/piece/{id}")
    Call<Void> deletePiece(@Path("id") Long id);

    // Onpanne operations
    @GET("/api/v1/onpanne")
    Call<List<Onpanne>> getOnpannes();

    @POST("/api/v1/onpanne")
    Call<Onpanne> addOnpanne(@Body Onpanne onpanne);

    @PUT("/api/v1/onpanne/{id}")
    Call<Onpanne> updateOnpanne(@Path("id") Long id, @Body Onpanne onpanne);

    @DELETE("/api/v1/onpanne/{id}")
    Call<Void> deleteOnpanne(@Path("id") Long id);

    // Facture operations
    @GET("/api/v1/facture")
    Call<List<Facture>> getFactures();

    @POST("/api/v1/facture")
    Call<Facture> addFacture(@Body Facture facture);

    @PUT("/api/v1/facture/{id}")
    Call<Facture> updateFacture(@Path("id") Long id, @Body Facture facture);

    @DELETE("/api/v1/facture/{id}")
    Call<Void> deleteFacture(@Path("id") Long id);

}
