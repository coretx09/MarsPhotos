#  Web services and Retrofit
La plupart des serveurs Web exécutent aujourd'hui des services Web à l'aide d'une architecture Web commune sans état connue sous le nom de
[REST] qui signifie Representational State Transfer
Les services Web qui offrent cette architecture sont appelés services [RESTful].

Les [Request] sont adressées aux services Web RESTful de manière standardisée via des [URI (Uniform Resource Identifier)]
identifie une ressource dans le serveur par son nom, sans impliquer son emplacement ou comment y accéder.

[URL (Uniform Resource Locator)] est un URI qui spécifie les moyens d'agir sur ou d'obtenir la représentation d'une ressource,
c'est-à-dire en spécifiant à la fois son mécanisme d'accès principal et son emplacement sur le réseau.

#Web service request
Chaque demande de service Web contient un URI et est transférée au serveur à l'aide du même protocole 
[HTTP] que celui utilisé par les navigateurs Web, tels que Chrome. Les requêtes HTTP contiennent une opération pour dire au serveur quoi faire.

# Les opérations HTTP courantes incluent :
[GET] pour récupérer les données du serveur
[POST ou PUT]  pour ajouter/créer/mettre à jour le serveur avec de nouvelles données
[DELETE] pour supprimer des données du serveur

La réponse d'un service Web est généralement formatée dans l'un des formats Web courants 
tels que [XML ou JSON] - des formats pour représenter des données structurées dans des paires [key-value].

# External Libraries
Les bibliothèques externes ou les bibliothèques tierces sont comme des extensions des principales API Android. 
Ils sont pour la plupart open source, développés par la communauté et maintenus par les contributions collectives de l'immense communauté Android du monde entier.

#Retrofit Library
La bibliothèque de mise à niveau communiquera avec le backend. Il crée des URI pour le service Web en 
fonction des paramètres que nous lui transmettons. 
  #Add Retrofit dependencies
Android Gradle vous permet d'ajouter des bibliothèques externes à votre projet.
En plus de la dépendance de la bibliothèque, vous devez également inclure le [repository] dans lequel la bibliothèque est hébergée.
Les [bibliothèques Google] telles que _ViewModel et LiveData_ de la [bibliothèque Jetpack] sont hébergées
dans le référentiel Google. La majorité des bibliothèques communautaires sont hébergées sur JCenter comme Retrofit.

[1.] Ouvrez le fichier de niveau supérieur du projet [build.gradle(Project: MarsPhotos)]. 
Notez les référentiels répertoriés sous le [repositories] bloc. Vous devriez voir deux dépôts, [google(), mavenCentral()].

[2.] Ouvrez le fichier de niveau de module, build.gradle (Module: MarsPhots.app).
Dans la dependenciessection, ajoutez ces lignes pour les bibliothèques Retrofit :
[
// Retrofit
implementation "com.squareup.retrofit2:retrofit:2.9.0"
// Retrofit with Moshi Converter
implementation "com.squareup.retrofit2:converter-scalars:2.9.0" 
]
La première dépendance est pour la bibliothèque [Retrofit2] elle-même, et la seconde dépendance est 
pour le [convertisseur scalaire Retrofit]. Ce convertisseur permet à Retrofit de renvoyer le résultat 
JSON sous forme de fichier String. Les deux bibliothèques fonctionnent ensemble.

# Ajout de la prise en charge des fonctionnalités du langage Java 8
De nombreuses bibliothèques tierces, dont Retrofit2, utilisent les fonctionnalités du langage Java 8. 
Le plug-in Android Gradle fournit une prise en charge intégrée pour l'utilisation de certaines fonctionnalités du langage Java 8.

[1.] Pour utiliser les fonctionnalités intégrées, vous avez besoin du code suivant dans le build.gradlefichier de votre module.
[
android {
...
compileOptions {
sourceCompatibility JavaVersion.VERSION_1_8
targetCompatibility JavaVersion.VERSION_1_8
}

kotlinOptions {
jvmTarget = '1.8'
}
} ]


# Connexion à Internet
Vous utiliserez la bibliothèque [Retrofit] pour communiquer avec le service Web Mars et [afficher la réponse JSON brute 
sous forme de fichier String]. L'espace réservé TextView affichera soit la chaîne de réponse JSON renvoyée, soit un message indiquant une erreur de connexion.

[Retrofit] crée une API réseau pour l'application basée sur le contenu du service Web. 
Il récupère les data du service Web et les achemine via une bibliothèque de conversion distincte qui 
sait comment décoder les data et les renvoyer sous la forme de objects tels que String.

La mise à niveau inclut une prise en charge intégrée des formats de données courants tels que [XML et JSON].
[Retrofit] crée finalement le code pour appeler et utiliser ce service pour vous, y compris des détails critiques 
tels que l'exécution des requêtes sur des [threads d'arrière-plan].

 # Implémentez l'API du service Retrofit en procédant comme suit:
[1.] Créez une [network layer] (couche réseau) , la MarsApiService class.
[2.] Créez un [Retrofit object] avec l'URL de base et la [converter factory] .
[3.] Créez une [interface] qui explique comment Retrofit communique avec notre serveur Web.
[4.] Créez un [Retrofit service] et exposez l'instance au service API au reste de l'application.
 
 # Mettez en œuvre les étapes ci-dessus :
[1.] Create a new package called network
[2.] Create a new Kotlin file under the new package network. Name it MarsApiService.


