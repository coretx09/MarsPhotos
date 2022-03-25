package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET


private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/*
   générateur Retrofit pour construire et créer un objet Retrofit.
   Retrofit a un ScalarsConverter qui prend en charge les String et d'autres types primitifs,
   Ajoutez l'URI de base du service Web à l'aide de la baseUrl()méthode .
   Enfin, appelez build() pour créer  Retrofit Object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


/*  INTERFACE qui définit comment Retrofit communique avec le serveur Web à l'aide de requêtes HTTP.*/
interface MarsApiService {

    /*
    Utilisez l' @GET annotation pour indiquer à Retrofit qu'il s'agit d'une requête GET et spécifiez
    le point de terminaison pour cette méthode de service Web.
    Lorsque la getPhotos()méthode est invoquée, Retrofit ajoute le point de terminaison photosà l'URL de base
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

/*
 Le modèle singleton garantit qu'une, et une seule, instance d'un objet est créée, a un point d'accès global à cet objet.
 N'oubliez pas que "l'instanciation lazy" se produit lorsque la création d'un objet est délibérément retardée
 jusqu'à ce que vous ayez réellement besoin de cet objet pour éviter un calcul inutile ou l'utilisation d'autres ressources informatiques.
 */
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
