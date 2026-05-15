# Contact App With Room

A modern Android application for managing contacts, entirely implemented in Kotlin, using the Room persistence library for local data storage. This app demonstrates clean architectural principles, the use of Jetpack components, and an organized modular structure.

---

## Table of Contents
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Build & Run](#build--run)
- [Configuration](#configuration)
- [Scripts](#scripts)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Add, edit, and delete contacts
- Display a list of contacts with sorting support
- Persistent local data using Room database
- MVVM architecture with separation of concerns
- Reactive UI using ViewModels and State management

---

## Architecture

This app uses a layered, modular architecture:

- **Data Layer** (`data/`): Handles data persistence with Room. Example: [data/room/](app/src/main/java/com/example/contactappwithroom/data/room)
- **Presentation Layer** (`presentation/`): UI logic, event handling, state management. Submodules:
  - `event/` – defines events between UI and ViewModel
  - `navigation/` – manages app navigation
  - `screens/` – contains composable UI screens and activities
  - `state/` – maintains immutable UI state
  - `viewModel/` – implements business logic in ViewModels
- **UI Components** (`ui/`): Thematic resources, styles, colors, etc. [ui/theme/](app/src/main/java/com/example/contactappwithroom/ui/theme)
- **Utils** (`util/`): Helpers and constants. For example, [SortType enum](app/src/main/java/com/example/contactappwithroom/util/SortType.kt)

---

## Project Structure

```
Contact_App_With_Room/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/contactappwithroom/
│           │   ├── MainActivity.kt
│           │   ├── data/
│           │   │   └── room/
│           │   ├── presentation/
│           │   │   ├── event/
│           │   │   ├── navigation/
│           │   │   ├── screens/
│           │   │   ├── state/
│           │   │   └── viewModel/
│           │   ├── ui/
│           │   │   └── theme/
│           │   └── util/
│           │       └── SortType.kt
│           └── res/
├── build.gradle.kts
├── settings.gradle.kts
```

---

## Getting Started

### Prerequisites

- Android Studio
- Gradle
- Kotlin (entire codebase is 100% Kotlin)
- Android device or emulator (minimum SDK as specified in `build.gradle.kts`)

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/abdelrahmanHossam23/Contact_App_With_Room.git
    cd Contact_App_With_Room
    ```
2. Open in Android Studio and let it sync dependencies.

---

## Build & Run

- To build and run on a device/emulator:
    1. Open the project in Android Studio.
    2. Click "Run" or use:
        ```sh
        ./gradlew assembleDebug
        ./gradlew installDebug
        ```

- The app’s entry point is [MainActivity.kt](app/src/main/java/com/example/contactappwithroom/MainActivity.kt).

---

## Configuration

- Build properties are managed in `gradle.properties`.
- Project dependencies are declared in `build.gradle.kts` at the project and app levels.

---

## Scripts

- Gradle wrapper scripts are provided:
  - Unix: `./gradlew`
  - Windows: `gradlew.bat`

---

## Contributing

Contributions are welcome! Please open issues and submit pull requests for improvements or bug fixes.

---

## License

This project is licensed under the MIT License.
