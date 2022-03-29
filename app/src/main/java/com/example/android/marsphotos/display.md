# COIL
Bibliothèque développée par la communauté  pour télécharger, mettre en mémoire tampon, décoder et mettre en cache vos images.

L'image doit être mise en cache dans un cache en mémoire, un cache basé sur le stockage ou les deux. 
Tout cela doit se produire dans des threads d'arrière-plan de faible priorité afin que l'interface utilisateur reste réactive.

Coil a essentiellement besoin de deux choses :
[1.] L' [URL] de l'image que vous souhaitez charger et afficher.
[2.] Un [ImageView] objet pour afficher réellement cette image

 #Ajouter une dépendance Coil
[
// Coil
implementation "io.coil-kt:coil:1.1.1"
]
La bibliothèque Coil est hébergée et disponible sur le mavenCentral()référentiel.
Dans build.gradle (Projet : MarsPhotos), ajoutez mavenCentral() le repositories bloc supérieur


# Binding Adapters
Méthodes annotées utilisées pour créer des setters personnalisés pour les propriétés personnalisées de votre view.
[@BindingAdapter]annotation prend le nom de [l'attribut] comme paramètre.
 #let
[let] est l'une des fonctions Scope de Kotlin qui vous permet d'exécuter un bloc de code dans le contexte d'un objet.
Est utilisé pour invoquer une ou plusieurs fonctions sur les résultats des chaînes d'appel.


# ListAdapter
Est une sous-classe de la RecyclerView.Adapter classe pour présenter les données de la liste
dans un RecyclerView, y compris le calcul des différences entre les listes sur un thread d'arrière-plan.
 
#DiffUtil:
L'avantage d'utiliser [DiffUtil] est qu'à chaque fois qu'un élément [RecyclerView] est ajouté, supprimé ou 
modifié, la liste entière n'est pas actualisée. Seuls les éléments qui ont été modifiés sont actualisés.

 # areItemsTheSame()méthode
Cette méthode est appelée par [DiffUtil] pour décider [si deux objets représentent le même élément.] 
DiffUtil utilise cette méthode pour déterminer si le nouvel MarsPhoto objet est le même que l'ancien MarsPhoto objet.
L'ID de chaque élément ( MarsPhoto objet) est unique.

 # areContentsTheSame()
Cette méthode est appelée par DiffUtil lorsqu'elle veut vérifier [si deux éléments ont les mêmes données.]
Les données importantes dans MarsPhoto sont l'URL de l'image. Comparez les URL de oldItem et newItemet renvoyez le résultat.


# Add the binding adapter and connect the parts:

# Add Binding Adapter to initialize the PhotoGridAdapter
vous utiliserez [BindingAdapter] pour initialiser le [PhotoGridAdapter] avec la liste des MarsPhoto objets.
L'utilisation de  [BindingAdapter] pour définir les [RecyclerView] données entraîne l'observation automatique de [data binding] LiveData
pour la liste d' MarsPhoto objets
Ensuite, [BindingAdapter] est appelé automatiquement lorsque la MarsPhoto liste change.

Pour tout connecter,  Ajoutez [app:listData]attribut à [RecyclerView élément] et définissez-le sur  [viewmodel.photos]

# Add status to the ViewModel
#Classes Enum dans Kotlin
Pour représenter ces trois états dans votre application, vous utiliserez [enum]. enum est l'abréviation d'énumération, 
ce qui signifie une liste ordonnée de tous les éléments d'une collection. Chaque enum constante est un objet de la enum classe.

Dans Kotlin, un [enum] est un type de données qui peut contenir un [ensemble de constantes.]
Les constantes Enum sont séparées par des virgules

Défini des [status enumeration] pour le statut et défini [status loading]  au début de la coroutine, 
défini terminé lorsque votre application a fini de récupérer les données du serveur Web et défini une erreur en cas d'exception.

# Add a binding adapter for the status ImageView
Vous utilisez un [binding adapter] pour un ImageView, pour afficher les icônes des status loading et Error. 
Lorsque l'application est en [loading status] ou en [error status],  ImageView doit être visible.
Lorsque l'application est chargée, le ImageView devrait être invisible


