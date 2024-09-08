# Breedly
Breedly is a small Kotlin app to display some core fundamentals of Android development.
* Layered Architecture (Data, Domain, UI)
* REST Api calls
* Room dependency
* Dependency Injection
* Light Mode & Dark Mode support
* Compose UI

The purpose of this app is to showcase my understanding of Room library, dependency injection, and Epoxy RecyclerView.

Minimum SDK Version: 24
Compile SDK Version: 33

## Architecture
The architecture of this project is MVVM (Model View ViewModel) Clean Architecture. The app is built
in a way for easy readability by other developers. I have followed the [recommended app architecture](https://developer.android.com/topic/architecture#recommended-app-arch)
from Android.

The architecture is divided into three layers:
* UI Layer (Presentation Layer)
* Domain Layer (Mapping)
* Data Layer (Data Source & Repository)

### UI Layer
The responsibility of the UI layer (or presentation layer) is to display the application data on the screen.
In this project, the UI layer includes UI elements from [AirBnB Epoxy RecyclerView](https://airbnb.io/projects/epoxy/) library.
All the UI element designing is done using XML.

<p align="center" width="100%">
    <img width="75%" src="https://user-images.githubusercontent.com/9715067/197088633-488dbb42-a099-42e9-a788-bcfe5ba64eef.png" alt="Unidirectional Data Flow"/>
</p>

### Data Layer
The [data layer](https://developer.android.com/topic/architecture/data-layer) contains business logic and repositories containing
data sources.
I am using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) dependency injection library to provide all the dependencies I have to pass into the data layer.


## In this branch, you'll find:

* [Jetpack Compose](https://developer.android.com/compose) - Jetpack Compose is Android’s recommended modern toolkit for building native UI.
* [Modern App Architecture](https://developer.android.com/topic/architecture) - best practices and recommended architecture for building robust, high-quality apps.
* [Retrofit](https://square.github.io/retrofit/) - Interacts with the API and send network requests with OkHttp.
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency injection plays a central role in the architectural pattern used.
* [Kotlinx Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines. I used this for asynchronous programming to obtain data from the network.
* [Flows](https://developer.android.com/kotlin/flow) - A flow is conceptually a stream of data that can be computed asynchronously. The emitted values must be of the same type.
* [Room](https://developer.android.com/training/data-storage/room) - Create, store, and manage persistent data backed by an SQLite database.

## Screenshots:
<p align="center" width="100%">
    <img width="30%" src="https://tylerryden.com/images/breedly_breed-list_light.png" alt="home screen light theme"/>
    <img width="30%" src="https://tylerryden.com/images/breedly_breed-list_dark.png" alt="home screen dark theme"/>
</p>
<p align="center" width="100%">
    <img width="30%" src="https://tylerryden.com/images/breedly_dog-screen-top__light.png" alt="dog screen light theme"/>
    <img width="30%" src="https://tylerryden.com/images/breedly_dog-screen-top__dark.png" alt="dog screen dark theme"/>
</p>